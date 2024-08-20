package E_Stack;

import java.util.*;

public class Stack_07 {
    public static int isCelebrity(int arr[][]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int v2 = st.pop();
            int v1 = st.pop();
            if (arr[v2][v1] == 0) {
                st.push(v2);
            } else if (arr[v1][v2] == 0) {
                st.push(v1);
            }
        }
        if (st.size() == 0) {
            return -1;
        }
        int potential = st.pop();// but we don't know whether he is celebrity or not
        for (int j = 0; j < arr.length; j++) {// for column
            if (arr[potential][j] == 1) {
                return -1;
            }
        }
        for (int i = 0; i < arr.length; i++) {// for row
            if (i == potential) {
                continue; // for skipping middle value
            }
            if (arr[i][potential] == 0) {
                return -1;
            }
        }
        return potential;
    }

    public static int[] maxSlidingWin(int[] nums, int k) {
        int n = nums.length;
        // n-[k-1] = n-k+1
        int[] ans = new int[n - k + 1];
        int z = 0;
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[z++] = max;// size increase
        }
        // time complexity= O(k*(n-k+1))
        return ans;
    }

    public static int[] maxSlidingWindow(int nums[],int k){
        int ans[] = new int[nums.length-k+1];//condition because it can't be go  forward upto last 3rd element
        //? Next Grater Element
        Stack<Integer> st = new Stack<>();
        int nge[] = new int[nums.length];
        st.push(nums.length-1);
        nge[nums.length-1] = nums.length;//=-1
        for (int i =nums.length-2; i>=0 ;i--) {
            while (st.size()>0 && nums[i]>nums[st.peek()]) st.pop();
            if (st.size()==0) nge[i]=nums.length;//=-1
            else nge[i] = st.peek();
            st.push(i);
        }
        //? Sliding Window 
        int j=0;
        for (int i = 0; i < nums.length-k+1; i++) {//condition because it can't be go  forward upto last 3rd element
            if (j>=i+k) {
                j=i;
            }
            int max = nums[j];
            while (j<i+k) {
                max = nums[j];
                j=nge[j];//update j by next greatest element
            }
            ans[i] = max; 
        }
        return ans;
        
    }

    public static void main(String[] args) {
        // ! Quse : Celebrity Problem
        System.out.println("<============Celebrity Problem================>");
        int arr[][] = { { 0, 0, 1 }, { 1, 0, 1 }, { 0, 0, 0 } };
        System.out.println("The index number " + isCelebrity(arr) + " is celebrity");
        //Time complexity : O(n)
        
        //! Ques : Sliding Window
        System.out.println("<===========Sliding Window problem using using Loops==================>");
        int ar[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        //? Approch 1:
        int array[] = maxSlidingWin(ar, 3);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        //Time complexity is O(k*(n-k+1))===O(k*n)

        //? Approch 2:
        System.out.println();
        System.out.println("<==========Sliding Window problem using Next Greater Element==========>");
        int nums[]={1,3,-2,-3,5,3,6,7};
        int a[]=maxSlidingWindow(nums, 3);
        //Time Complexity is O(n)
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
