package E_Stack;
import java.util.*;

public class Stack_07 {
    public static int isCelebrity(int arr[][]){
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while (st.size()>1) {
            int v2 = st.pop();
            int v1 = st.pop();
            if (arr[v2][v1]==0) {
                st.push(v2);
            }
            else if (arr[v1][v2]==0) {
                st.push(v1);
            }
        }
        if (st.size()==0) {
            return -1;
        }
        int potential  = st.pop();//but we don't know whether he is celebrity or not
        for (int j = 0; j < arr.length; j++) {//for column
            if (arr[potential][j]==1) {
                return -1;
            }
        }
        for (int i = 0; i < arr.length; i++) {//for row
            if (i==potential) {
                continue; //for skipping middle value 
            }
            if (arr[i][potential]==0) {
                return -1;
            }
        }
        return potential;
    }
    public static void main(String[] args) {
        //! Quse : Celebrity Problem 
        int arr[][] = {{0,0,0},{1,0,0},{1,0,0}};
        isCelebrity(arr);
        System.out.println("The index number "+isCelebrity(arr)+" is celebrity");
    }
}
