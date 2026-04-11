package cracking_the_coding_interview.ch_08;

public class PaintFill {

    // assume monochrome screen
    private static void paint(int[][] screen, int row, int col, int color) {
        helper(screen, row, col, screen[row][col], color);
    }

    private static void helper(int[][] screen, int row, int col, int from, int to) {

        if (row < 0 || row >= screen.length || col < 0 || col >= screen[0].length) return;
        if (screen[row][col] != from)                                              return;
        screen[row][col] = to;

        helper(screen, row - 1, col, from, to);
        helper(screen, row + 1, col, from, to);
        helper(screen, row, col - 1, from, to);
        helper(screen, row, col + 1, from, to);
    }

}
