package I_Backtracking;

import java.util.*;

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

    public static void nqueenList(char board[][], int row, List<List<String>> ans) {
        int n = board.length;
        // base condition
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String str = "";
                for (int j = 0; j < board.length; j++) {
                    str = str + board[i][j];
                }
                l.add(str);
            }
            ans.add(l);
            return;
        }
        // work
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';// visited
                nqueenList(board, row + 1, ans);
                board[row][j] = '.';// Backtracking
            }
        }
    }

    public static boolean knightHelper(int grid[][], int row, int col, int num) {
        int n = grid.length;
        // base condition
        if (grid[row][col] == n * n - 1)
            return true;
        // 2 Up 1 right
        int i, j;
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n) {
            if (grid[i][j] == num + 1)
                return knightHelper(grid, i, j, num + 1);
        }
        // 2 Up 1 left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1)
            return knightHelper(grid, i, j, num + 1);
        // 2 Down 1 right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && grid[i][j] == num + 1)
            return knightHelper(grid, i, j, num + 1);
        // 2 Down 1 left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == num + 1)
            return knightHelper(grid, i, j, num + 1);
        // 2 Right 1 up
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == num + 1)
            return knightHelper(grid, i, j, num + 1);
        // 2 Right 1 down
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && grid[i][j] == num + 1)
            return knightHelper(grid, i, j, num + 1);
        // 2 Left 1 up
        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1)
            return knightHelper(grid, i, j, num + 1);
        // 2 Left 1 down
        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && grid[i][j] == num + 1)
            return knightHelper(grid, i, j, num + 1);

        return false;
    }

    public static boolean checkValidKnight(int grid[][]) {
        if (grid[0][0] != 0)
            return false;
        return knightHelper(grid, 0, 0, 0);
    }

    public static boolean isknightSafe(char grid[][], int row, int col) {
        int n = grid.length;
        // 2 Up 1 right
        int i, j;
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n) {
            if (grid[i][j] == 'k')
                return false;
        }
        // 2 Up 1 left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == 'k')
            return false;
        // 2 Down 1 right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && grid[i][j] == 'k')
            return false;
        // 2 Down 1 left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == 'k')
            return false;
        // 2 Right 1 up
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == 'k')
            return false;
        // 2 Right 1 down
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && grid[i][j] == 'k')
            return false;
        // 2 Left 1 up
        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == 'k')
            return false;
        // 2 Left 1 down
        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && grid[i][j] == 'k')
            return false;
        return true;
    }

    static int maxKnights = 0;

    public static void placedKnight(char arr[][], int row, int col, int number) {
        int n = arr.length;
        // Base condition: End of rows
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            if (number > maxKnights) {
                maxKnights = number;
            }

            return;
        }

        // Check if the knight can be placed at (row, col)
        if (isknightSafe(arr, row, col)) {
            arr[row][col] = 'k'; // Place the knight
            if (col != n - 1) {
                placedKnight(arr, row, col + 1, number + 1);
            } else {
                placedKnight(arr, row + 1, 0, number + 1);
            }
            arr[row][col] = 'x'; // Backtrack
        }

        // Move to the next cell without placing a knight
        if (col != n - 1) {
            placedKnight(arr, row, col + 1, number);
        } else {
            placedKnight(arr, row + 1, 0, number);
        }
    }

    public static void main(String[] args) {
        // ! Quse: n-queen Problem
        System.out.println("<======n-queen Problem using Array========>");
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nqueen(board, 0);
        System.out.println("<======n-queen Problem using List of ArrayList========>");
        int m = 4;
        List<List<String>> ans = new ArrayList<>();
        char chessBoard[][] = new char[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                chessBoard[i][j] = '.';
            }
        }
        nqueenList(chessBoard, 0, ans);
        System.out.println(ans);

        // ! Ques : Check Knight Tour Configuration [2596]
        /*
         * There is a knight on an n x n chessboard. In a valid configuration,
         * the knight starts at the top-left cell of the board and visits every cell on
         * the board exactly once.
         * You are given an n x n integer matrix grid consisting of distinct integers
         * from the range [0, n * n - 1] where grid[row][col] indicates that the cell
         * (row, col) is the grid[row][col]th cell that the knight visited. The moves
         * are 0-indexed.
         * Return true if grid represents a valid configuration of the knight's
         * movements or false otherwise.
         */
        System.out.println("<======Check Knight Tour Configuration=====>");
        int grid[][] = { { 0, 11, 16, 5, 20 }, { 17, 4, 19, 10, 15 }, { 12, 1, 8, 21, 6 }, { 3, 18, 23, 14, 9 },
                { 24, 13, 2, 7, 22 } };
        System.out.println(checkValidKnight(grid));

        System.out.println("<=====find maximum no. of knights that can be placed=====>");
        // ! Ques : Tell the maximum no. of knights that can be placed in a given nXn
        // chessboard
        int d =3;
        char[][] arr = new char[d][d];
        int number = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'x';
            }
        }

        placedKnight(arr, 0, 0, number);
        System.out.println("Maximum number of knights that can be placed: " + maxKnights);
    }
}
