package F_Queue;

import java.util.*;

public class Queue_04 {
    public static void printFirstNegativeInteger(int arr[], int n, int k) {
        for (int i = 0; i < n - k + 1; i++) {
            boolean flag = false;
            for (int j = 0; j < k; j++) {
                //* Imp Concept for accessing Window
                if (arr[j + i] < 0) {
                    System.out.print(arr[j + i] + " ");
                    flag = true;
                    break;
                } 
            }
            if (!flag)
                System.out.print("0" + " ");
        }
    }
    public static void reorderQueue(){
        System.out.println();
        System.out.println("<==========Reorder Queue===========>");
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        System.out.println(q);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <=(q.size()/2)+1; i++) {
            st.push(q.remove());
        }
        //-----------> O(n/2)
        System.out.println(q);
        System.out.println(st);
        while (st.size()!=0) {
            q.add(st.pop());
        }//------------> O(n)
        System.out.println(q);
        for (int i = 0; i <=(q.size()/2)+1; i++) {
            st.push(q.remove());
        }//-------------> O(n/2)
        System.out.println(q);
        System.out.println(st);

        while (st.size()!=0) {
            q.add(st.pop());
            q.add(q.remove());
        }//------------> O(n)
        System.out.println(q);
        //* Reverse the queue
        while (q.size()!=0) {
            st.push(q.remove());
        }
        while (st.size()!=0){
            q.add(st.pop());
        }//------------->O(n)
        System.out.println(q);
    }

    public static int[] printArrFirstNegInteger(int arr[], int n, int k) {
        int res[] = new int[n - k + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                q.add(i);
            }
        }
        //----------> O(n)
        System.out.println(q);
        for (int i = 0; i < n - k + 1; i++) {
            // window size will determine by: i+k-1
            if (q.size() > 0 && q.peek() < i)
                q.remove();
            if (q.size() > 0 && q.peek() <= i + k - 1) {
                res[i] = arr[q.peek()];
            } else {
                res[i] = 0;
            }
        }
        //----------->O(n-k+1) ~> O(n)
        return res;
    }

    public static void main(String[] args) {
        //! Ques : Find First negative in each window size k
        //* Approch 1: 
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int n = arr.length;
        int k = 3;
        printFirstNegativeInteger(arr, n, k);
        // ? Time complexity :O(k*n)

        //* Approch 2:
        System.out.println();
        int res[] = printArrFirstNegInteger(arr, n, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        //? Time Complexity :O(n) + O(n) ~> O(n)

        //! Ques : Reorder queue ( interleave 1st half with 2nd half)
        reorderQueue();
    }
}