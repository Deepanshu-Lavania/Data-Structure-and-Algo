package A_1DArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Med_03 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to use two-pointer technique

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicates

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    ans.add(list);

                    // Skip duplicates for the 'left' and 'right' elements
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }

    public static int maxAreaWater() {
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int lp = 0;
        int rp = height.length - 1;
        int maxWater = Integer.MIN_VALUE;
        while (lp < rp) {
            int wd = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int currWater = wd * ht;
            maxWater = Math.max(maxWater, currWater);

            if (height[lp] < height[rp]) {// you have to move that container which height is samller because we have to
                                          // require most water
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static List<int[]> mergedIntervals(int[][] intervals) {
        /*
         * for (int i = 0; i < intervals.length; i++) {
         * for (int j = 0; j < intervals[0].length; j++) {
         * System.out.print(intervals[i][j]+" ");
         * }
         * System.out.println();
         * }
         */
        // ! Sort intervals by their start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]); // Sort by start time
            }
        });
        /*
         * Arrays.sort() is the function that triggers the sorting operation.
         * The comparator provides the custom logic for how to sort those intervals
         * based on their start times.
         * Without Arrays.sort(), the comparator alone wouldn't do anything; it merely
         * defines how comparisons are made. You need to use Arrays.sort() to actually
         * sort the intervals using that logic.
         */

        // Print sorted intervals
        System.out.println("Sorted Intervals by start time for each array : ");
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "], ");
        }
        System.out.println();
        System.out.print("Now merge Overlap intervals : ");
        List<int[]> mergedlist = new ArrayList<>();// list of integer array
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                mergedlist.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergedlist.add(currentInterval);
        return mergedlist;
    }

    public static int  mergOperPali(int arr[]) {
        // int[] numbers; // Declared but not initialized, defaults to null
        if (arr == null || arr.length <= 1) {
            return 0; // No merge operations needed
        }
        int count = 0;
        // int left = 0;
        // int right = arr.length - 1;
        // while (left < right) {
        // }
        for(int left=0, right=arr.length-1;left<right;){
            if (arr[left] < arr[right]) {
               left++;
               arr[left] +=arr[left-1];
               count++;
                
            } else if(arr[left]>arr[right]){
                right--;
                arr[right]+=arr[right+1];
            }else{
                left++;
                right--;
            }
        }
        return count;
    }

    public static String largetNumber(){
        int num[]={10,2,9,39,5};
        String[] strNums = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strNums[i]=String.valueOf(num[i]);
        }
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a , String b){
                return (b+a).compareTo(a+b);
            }
        });
        System.out.println(Arrays.toString(strNums));
        /* //? Sort the array using a custom comparator in javascript
        strNums.sort((a, b) => (b + a).localeCompare(a + b)); */
        // Handle case where the largest number is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }
        StringBuilder largestNum = new StringBuilder();
        for (int i = 0; i < strNums.length; i++) {
            largestNum.append(strNums[i]);
        }
        // System.out.println("largestNum builder "+ largestNum);
        return largestNum.toString();
    }
    public static void main(String[] args) {
        int nums[] = { -1, 1, 0, -1, 2, -4 };
        List<List<Integer>> ans = threeSum(nums);
        System.out.println(ans);
        System.out.println("<=====Most Water Container======>");
        System.out.println("Maximum Area to Store Water : " + maxAreaWater());
        System.out.println("<=======Sort the overlap Intervals =========>");
        System.out.println("Merged Overlap Interval");
        int[][] intervals = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 }
        };
        List<int[]> mergedIntervals = mergedIntervals(intervals);
        System.out.println();
        for (int i = 0; i < mergedIntervals.size(); i++) {
            int arr[] = mergedIntervals.get(i);
            System.out.print("[ ");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.print("]" + " ");
        }
        System.out.println();
        System.out.println("<======Number of merge operation to make an array palindrome=======>");
        // int arr[] = { 11,14,15,99};
        // int arr[]={1,4,5,1};
        int arr[]={2,1,5,6,2};
        System.out.println("Merge operations will be : "+mergOperPali(arr));
        System.out.println("<======arrage the numbers in array to form the biggest number=======>");
        
        System.out.println("largest number : "+largetNumber());
    }
}
