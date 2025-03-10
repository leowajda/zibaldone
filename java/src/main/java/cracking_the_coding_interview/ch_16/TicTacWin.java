package cracking_the_coding_interview.ch_16;

public class TicTacWin {

    enum Marker { X, O, NIL }

    private static boolean isWin(Marker[][] board) {
        int boardSize = board.length;

        for (int row = 0; row < boardSize; row++) {
            int pos = 0;
            var marker = board[row][pos];
            if (marker == Marker.NIL) continue;

            while (pos < boardSize)
                if (board[row][pos] != marker)   break;
                else if (pos++ == boardSize - 1) return true;
        }

        for (int col = 0; col < boardSize; col++) {
            int pos = 0;
            var marker = board[pos][col];
            if (marker == Marker.NIL) continue;

            while (pos < boardSize)
                if (board[pos][col] != marker)   break;
                else if (pos++ == boardSize - 1) return true;
        }

        var marker = board[0][0];
        if (marker != Marker.NIL)
            for (int row = 1, col = 1; row < boardSize; row++, col++)
                if (board[row][col] != marker) break;
                else if (row == boardSize - 1) return true;

        marker = board[boardSize - 1][0];
        if (marker != Marker.NIL)
            for (int row = boardSize - 2, col = 1; row >= 0; row--, col++)
                if (board[row][col] != marker) break;
                else if (row == 0)             return true;

        return false;
    }

}
