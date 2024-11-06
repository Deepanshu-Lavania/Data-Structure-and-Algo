package A_1DArray;
import java.util.Arrays;

public class Med_01 {
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        int start = i + 1;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
        return nums;
    }// O(n)

    public static int buyShellStock(int prices[]) {
        // find minimum price
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            //Update minimum price encountered
            if (prices[i]<minPrice) {
                minPrice=prices[i];
            }
            //calculate profit with the current price 
            int profit = prices[i]-minPrice;
            if (profit>maxProfit) {
                maxProfit=profit;
            }
        }
        return maxProfit;//profit Rs.5 ====> Buy at Rs.1 and sell at Rs.6
        
    }
/*     public static int buyShellStock(int arr[]) {
        int newarr[] = new int[arr.length];
        int count = 0;
        // find minimum price
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minPrice) {
                minPrice = arr[i];
            }
        }
        if (arr.length == 1) {
            newarr[count] = 0;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    newarr[count++] = 0;
                } else {
                    newarr[count++] = arr[i] - minPrice;
                }
            }
        }
        System.out.println(Arrays.toString(newarr));
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < newarr.length; i++) {
            if (newarr[i]>maxProfit) {
                maxProfit=newarr[i];
            }
        }
        return maxProfit;
    }
 */
    
 
 public static void missRepeatNum() {
    int arr[] = {3,4,1,4,2};  // Input array
    int n = arr.length;
    int repeatedNum = -1;
    int missingNum = -1;

    // Step 1: Traverse the array and mark visited elements
    for (int i = 0; i < n; i++) {
        int absVal = Math.abs(arr[i]);  // Get absolute value to handle previously marked elements

        // If the value at index absVal-1 is already negative, it's the repeated number
        if (arr[absVal - 1] < 0) {
            repeatedNum = absVal;
        } else {
            // Otherwise, mark the value at index absVal-1 as visited by making it negative
            arr[absVal - 1] = -arr[absVal - 1];
        }
    }

    // Step 2: Traverse the array again to find the missing number
    for (int i = 0; i < n; i++) {
        // The index with a positive value corresponds to the missing number
        if (arr[i] > 0) {
            missingNum = i + 1;
            break;
        }
    }

    // Step 3: Print the result
    System.out.println("Repeated Num : " + repeatedNum);
    System.out.println("Missing Num : " + missingNum);
}
 
 public static void main(String[] args) {
        // ! Ques : next permutaion
        int arr[] = { 2, 4, 3, 1 };
        int ans[] = nextPermutation(arr);
        System.out.println(Arrays.toString(ans));
        // ! Ques : Best time to buy and shell stock
        int arrStock[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("max profit is  : "+ buyShellStock(arrStock));

        //! Ques : find missing and repeating number 
        missRepeatNum();
    }
}
