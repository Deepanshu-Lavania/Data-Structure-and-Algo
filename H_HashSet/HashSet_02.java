package H_HashSet;

import java.util.*;

public class HashSet_02 {
    public static int longestConsecutive(int nums[]) {
        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            st.add(nums[i]);
        }
        System.out.println(st);
        int maxLen = 0;
        for (Integer num : st) {
            if (!st.contains(num - 1)) {// num sis starting point of sequence
                int currNum = num;
                int currLen = 1;
                while (st.contains(currNum + 1)) {//* it will not affect to for loop n times, this runs only when it contains next greateer element so this time complexity is O(k) beacuse while loop not touch the smaller element from start num in for loop therefore T.C is O(k) which is too smaller than o(n) so we can neglect it or assume it to o(1).
                    currLen++;
                    currNum++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;//O(n)
    }
    public static int maxNumberOnTable(int arr[]){
        HashSet<Integer> table = new HashSet<>();
        int max =0;
        for (int i = 0; i < arr.length; i++) {
            if (table.contains(arr[i])) {
                table.remove(arr[i]);
            }else{
                table.add(arr[i]);
                max=Math.max(max,table.size());
            }
        }
        // System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        //! Ques : Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence. You must write an algorithm that runs in O(n) time

        int arr[] = { 99, 1, 100, 4, 200, 1, 2, 2, 3 };
        System.out.println("Max length of consequtive number is : " + longestConsecutive(arr));
        //? Time Complexity : O(n)

        //! Ques : find max number of present at table after removing the pair element from the bag(array)
        int nums[]= {2,1,1,3,2,3};
        System.out.println(maxNumberOnTable(nums));
    }
}
