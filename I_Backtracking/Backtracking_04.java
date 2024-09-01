package I_Backtracking;

public class Backtracking_04 {
    public static boolean isValid(char board[][], int row, int col, char num) {
        // Check the row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == num) return false;
        }
        // Check the column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) return false;
        }
        // Check the 3x3 subgrid
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;
        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true; // Return true if no conflicts are found
    }
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char num = board[i][j];
                if (num != '.') { // Only check if the cell is not empty
                    board[i][j] = '.'; // Temporarily empty the cell
                    if (!isValid(board, i, j, num)) {
                        return false;
                    }
                    board[i][j] = num; // Restore the cell's original value
                }
            }
        }
        return true;
    }
    
    
    static int check = 0;
    public static boolean isValidS(char board[][], int row, int col, char num) {
      // Check the row
      for (int j = 0; j < 9; j++) {
          if (board[row][j] == num) return false;
      }
      // Check the column
      for (int i = 0; i < 9; i++) {
          if (board[i][col] == num) return false;
      }
      // Check the 3x3 grid (smaller matrix)
      int sRow = (row / 3) * 3;
      int sCol = (col / 3) * 3;
      for (int i = sRow; i < sRow + 3; i++) {
          for (int j = sCol; j < sCol + 3; j++) {
              if (board[i][j] == num) return false;
          }
      }
      return true; // Return true if no conflicts are found
  }

    public static void solve(char[][] board, int row, int col) {
      if(row == 9){
          check=1;
          return;
      }
      if (board[row][col] != '.') {
          if (col != 8)
              solve(board, row, col + 1);
          else
              solve(board, row + 1,0);
      } else {// board[row][col]=='.'
          for(char ch='1';ch<='9';ch++){
              if(isValidS(board, row, col , ch)){
                  board[row][col]=ch;
                  if(col!=8) solve(board, row, col+1);
                  else solve(board,row+1,0);
                  if(check != 1 ) board[row][col]='.';//Backtracking
              }
          }
      }
  }


    public static void main(String[] args) {
        //! Ques : isValid sudoku
        /* CONDITION: A sudoku solution must satisfy all of the following rules:
        Each of the digits 1-9 must occur exactly once in each row.
        Each of the digits 1-9 must occur exactly once in each column.
        Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
        The '.' character indicates empty cells */
        System.out.println("<======isValid Sudoku=========>");
        char board[][]={{'5','3','.','.','7','.','.','.','.'}
                       ,{'6','.','.','1','9','5','.','.','.'}
                       ,{'.','9','8','.','.','.','.','6','.'}
                       ,{'8','.','.','.','6','.','.','.','3'}
                       ,{'4','.','.','8','.','3','.','.','1'}
                       ,{'7','.','.','.','2','.','.','.','6'}
                       ,{'.','6','.','.','.','.','2','8','.'}
                       ,{'.','.','.','4','1','9','.','.','5'}
                       ,{'.','.','.','.','8','.','.','7','9'}};
        // char board[][]={{'8','3','.','.','7','.','.','.','.'}
        //                ,{'6','.','.','1','9','5','.','.','.'}
        //                ,{'.','9','8','.','.','.','.','6','.'}
        //                ,{'8','.','.','.','6','.','.','.','3'}
        //                ,{'4','.','.','8','.','3','.','.','1'}
        //                ,{'7','.','.','.','2','.','.','.','6'}
        //                ,{'.','6','.','.','.','.','2','8','.'}
        //                ,{'.','.','.','4','1','9','.','.','5'}
        //                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));

        //!Quse : Sudoku Solver
        System.out.println("<=======Sudoku Solver=======>");
        solve(board, 0, 0);
        check=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        //?Use of check in sudoku Solver
        // If check wasn't used, the solve function would continue to run even after finding a valid solution, potentially undoing the solution through backtracking, and it could lead to exploring unnecessary paths

        //         1. Terminate Recursion Early:
        // Once a valid solution is found, the recursive solve function should stop further exploration and return immediately. Without check flag, even after finding a valid solution, the code might continue to explore other possibilities, leading to unnecessary computations.
        //        2.  Prevent Backtracking After Solution:
        // After finding a valid configuration for the Sudoku board, you don't want to revert the board back to its previous state (backtrack). The check variable ensures that once a solution is found (check == 1), the board is no longer modified.

    }
}
