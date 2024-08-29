package H_HashSet;
import java.util.*;

public class HashSet_02 {
    public static int longestConsecutive(int nums[]){
        HashSet<Integer> st =new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            st.add(nums[i]);
        }
        System.out.println(st);
        int maxLen =0;
        for (Integer num : st) {
            if (!st.contains(num-1)) {//num sis starting point of sequence
                int currNum  = num;
                int currLen =1;
                while (st.contains(currNum+1)) {
                    currLen++;
                    currNum++;
                }
                maxLen =Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[]={99,1,100,4,200,1,2,2,3};
        System.out.println("Max length of consequtive number is : "+        longestConsecutive(arr)        );
    }
}
