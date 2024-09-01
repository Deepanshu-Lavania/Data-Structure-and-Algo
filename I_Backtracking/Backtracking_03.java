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
            return ;
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
    public static void nqueenList(char board[][], int row,List<List<String>> ans) {
        int n = board.length;
        // base condition
        if (row == n) {
            List<String> l=new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String str="";
                for (int j = 0; j < board.length; j++) {
                    str=str+board[i][j];
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
                nqueenList(board, row + 1,ans);
                board[row][j] = '.';// Backtracking
            }
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
        nqueenList(chessBoard, 0,ans);
        System.out.println(ans);
    }
}
