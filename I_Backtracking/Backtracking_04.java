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
    public static void main(String[] args) {
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
    }
}
