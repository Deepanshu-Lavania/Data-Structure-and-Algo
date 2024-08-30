package I_Backtracking;

public class Backtracking_01 {
    public static int countWaysMaze(int startRow, int startCol, int endRow, int endCol) {
        if (startRow > endRow || startCol > endCol)
            return 0;
        if (startRow == endRow && endRow == endCol)
            return 1;
        int downways = countWaysMaze(startRow + 1, startCol, endRow, endCol);
        int rightways = countWaysMaze(startRow, startCol + 1, endRow, endCol);
        int totalWays = downways + rightways;

        return totalWays;

    }

    public static void printCountWaysMaze(int sr, int sc, int er, int ec, String s) {
        if (sr > er || sc > ec)
            return;
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        // go down
        printCountWaysMaze(sr + 1, sc, er, ec, s + "D");
        // go right
        printCountWaysMaze(sr, sc + 1, er, ec, s + "R");
    }

    public static void printWaysMazeFourDir(int sr, int sc, int er, int ec, String s, boolean isVisited[][]) {
        if (sr > er || sc > ec)
            return;
        if (sr < 0 || sc < 0)
            return;
        if (isVisited[sr][sc] == true)
            return;
        if (sr == er && sc == ec) {
            System.out.print(s + "  ");
            return;
        }
        isVisited[sr][sc] = true;
        // go right
        printWaysMazeFourDir(sr, sc + 1, er, ec, s + "R", isVisited);
        // go left
        printWaysMazeFourDir(sr, sc - 1, er, ec, s + "L", isVisited);
        // go down
        printWaysMazeFourDir(sr + 1, sc, er, ec, s + "D", isVisited);
        // go up
        printWaysMazeFourDir(sr - 1, sc, er, ec, s + "U", isVisited);

        // Backtracking
        isVisited[sr][sc] = false;
    }

    public static void twoWaysByRestri(int sr, int sc, int er, int ec, String s, int[][] maze) {
        if (sr > er || sc > ec)
            return;
        if (sr == er && sc == ec) {
            System.out.print(s + " ");
            return;
        }
        if (maze[sr][sc] == 0)
            return;
        // down
        twoWaysByRestri(sr + 1, sc, er, ec, s + "D", maze);
        // right
        twoWaysByRestri(sr, sc + 1, er, ec, s + "R", maze);
    }

    public static void fourWaysByRestri(int sr, int sc, int er, int ec, String s, int[][] maze) {
        if (sr > er || sc > ec)
            return;
        if (sr < 0 || sc < 0) {// otherwise give index -1 out of boud
            return;
        }
        if (sr == er && sc == ec) {
            System.out.print(s + " ");
            return;
        }
        if (maze[sr][sc] == 0)
            return;

        if (maze[sr][sc] == -1) {
            return;
        }

        // Check
        maze[sr][sc] = -1;
        // down
        fourWaysByRestri(sr + 1, sc, er, ec, s + "D", maze);
        // right
        fourWaysByRestri(sr, sc + 1, er, ec, s + "R", maze);
        // up
        fourWaysByRestri(sr - 1, sc, er, ec, s + "U", maze);
        // left
        fourWaysByRestri(sr, sc - 1, er, ec, s + "L", maze);
        // Backtacking
        maze[sr][sc] = 1;
    }

    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        System.out.println("<=========Count ways to reahed at loaction=========>");
        int count = countWaysMaze(1, 1, row, col);
        System.out.println("total number of ways : " + count);

        System.out.println("<======Print ways in maze using two direction======>");
        printCountWaysMaze(1, 1, row, col, "");

        System.out.println("<======Print ways in maze using four direction======>");
        boolean[][] isVisited = new boolean[row][col];// ? By default false is avilable present
        printWaysMazeFourDir(0, 0, row - 1, col - 1, "", isVisited);

        //! Quse :A maze is an N*N binary matrix of blocks where the upper left block is known as the Source block, and the lower rightmost block is known as the Destination block. If we consider the maze, then maze [0][0] is the source , and maze[N-1][N-1] is the destination. Our main task is to reach teh destination from teh source. We hace considered a rat as a character that can move either forward or downwards .
        //? If the maze matrix, a few dead blocks will be denoted by 0 and active blocks will be denoted by 1. A rat can move only in the active blocks.
        //!  Ques: Using two ways
        System.out.println();
        System.out.println("<=========Given maze array by two ways=========>");
        int[][] maze = { { 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 0, 1, 1 } };
        twoWaysByRestri(0, 0, 4 - 1, 6 - 1, "", maze);
        //! Ques: Using Four ways
        System.out.println();
        System.out.println("<=========Given maze array by four ways=========>");
        int[][] mazeArr = {{ 1, 0, 1, 1},
                           { 1, 1, 1, 1},
                           { 1, 1, 0, 1 } };
        // boolean[][] visited = new boolean[3][4];
        fourWaysByRestri(0, 0, 3 - 1, 4 - 1, "", mazeArr);

        // 1 1 1
        // 0 1 0
        // 1 1 1
//? Visualization of Backtacking 
        // Start from (0, 0):
        // Mark it as -1.
        // Explore down to (1, 0)—blocked, return.
        // Explore right to (0, 1).
        // At (0, 1):
        // Mark it as -1.
        // Explore down to (1, 1).
        // At (1, 1):
        // Mark it as -1.
        // Explore down to (2, 1)—a valid move.
        // Continue until all paths are explored or the destination (2, 2) is reached.
        // Once a path is completely explored, backtrack by unmarking cells, allowing other paths to try using those cells.

    }
}
