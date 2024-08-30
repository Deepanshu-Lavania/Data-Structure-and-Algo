package I_Backtracking;

public class Backtracking_01 {
    public static int countWaysMaze(int startRow , int startCol, int endRow , int endCol){
        if (startRow>endRow || startCol>endCol) return 0;
        if (startRow==endRow && endRow==endCol ) return 1;
        int downways = countWaysMaze(startRow+1, startCol, endRow, endCol);
        int rightways = countWaysMaze(startRow, startCol+1, endRow, endCol);
        int totalWays = downways + rightways;
        
        return totalWays;
        
    }
    public static void printCountWaysMaze(int sr , int sc, int er , int ec,String s){
        if(sr>er || sc>ec) return;
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }   
        //go down      
        printCountWaysMaze(sr+1, sc, er, ec,s+"D");
        //go right   
        printCountWaysMaze(sr, sc+1, er, ec,s+"R");
    }
    public static void main(String[] args) {
        int row=3;
        int col=3;
        int count = countWaysMaze(1,1,row,col);
        System.out.println("total number of ways : "+count);

        printCountWaysMaze(1,1,row,col,"");
    }
}
