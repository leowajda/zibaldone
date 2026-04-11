package cracking_the_coding_interview.ch_08;

import java.util.ArrayList;
import java.util.List;

public class RobotInGrid {

    private record Coordinate(int row, int col) {}

    private static List<Coordinate> robotInGrid(boolean[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        List<Coordinate> path = new ArrayList<>();
        Boolean[][] isCellAccessible = new Boolean[rows][cols];
        helper(grid, isCellAccessible, 0, 0, path);
        return isCellAccessible[0][0] ? path : null;
    }

    private static Boolean helper(boolean[][] grid, Boolean[][] isCellAccessible, int row, int col, List<Coordinate> path) {

        if (row < 0 || col >= grid[0].length || !grid[row][col]) return false;
        if (isCellAccessible[row][col] != null)                  return isCellAccessible[row][col];
        if (row == grid.length - 1 && col == grid[0].length - 1) return true;

        if (helper(grid, isCellAccessible, row - 1, col, path)) {
            path.addFirst(new Coordinate(row, col));
            return isCellAccessible[row][col] = true;
        }

        if (helper(grid, isCellAccessible, row, col + 1, path)) {
            path.addFirst(new Coordinate(row, col));
            return isCellAccessible[row][col] = true;
        }

        return isCellAccessible[row][col] = false;
    }

}
