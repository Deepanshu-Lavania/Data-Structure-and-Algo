package I_Backtracking;

public class Backtracking_03 {
    public static boolean isSafe(char board[][], int row, int col) {
        int n = board.length;
        // check row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        // check col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check lower left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check lower right diagonal
        for (int i = row, j = col; i < n && j < n; i++, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void nqueen(char board[][], int row) {
        int n = board.length;
        // base condition
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        // work
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';// visited
                nqueen(board, row + 1);
                board[row][j] = 'X';// Backtracking
            }
        }

    }

    public static void main(String[] args) {
        // ! Quse: n-queen Problem
        System.out.println("<======n-queen Problem========>");
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nqueen(board, 0);
    }
}
