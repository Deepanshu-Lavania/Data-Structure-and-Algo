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
                while (st.contains(currNum + 1)) {//* it will not affect to for loop n times, this runs only when it contains next greateer element so this time complexity is O(1) beacuse while loop not touch the smaller element from start num in for loop therefore T.C is O(1O(n)
                    currLen++;
                    currNum++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;//O(n)
    }

    public static void main(String[] args) {
        int arr[] = { 99, 1, 100, 4, 200, 1, 2, 2, 3 };
        System.out.println("Max length of consequtive number is : " + longestConsecutive(arr));
        //? Time Complexity : O(n)
    }
}
