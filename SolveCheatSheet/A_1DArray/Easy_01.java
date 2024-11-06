package A_1DArray;

import java.util.*;

public class Easy_01 {

    public static int maxSubarray() {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int maxSum = arr[0];
        int curSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curSum = Math.max(curSum, curSum + arr[i]);
            maxSum = Math.max(curSum, maxSum);
            System.out.print(curSum + " ");
        }
        return maxSum;
    }

    public static void swaparr(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int choDispro() {
        int choarr[] = { 7, 3, 2, 4, 9, 12, 56 };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students to distribute chocolate : ");
        int m = sc.nextInt();
        if (m > choarr.length) {
            System.out.println("Number of students should be greater than chocolates for distribution ");
            return -1;
        }
        if (m < choarr.length) {
            // sort the array
            for (int i = 0; i < choarr.length; i++) {
                for (int j = i + 1; j < choarr.length; j++) {
                    if (choarr[i] > choarr[j]) {
                        swaparr(choarr, i, j);
                    }
                }
            }
        }
        int min_differnce = Integer.MAX_VALUE;
        // find min difference between students
        for (int i = 0; i + m - 1 < choarr.length; i++) {
            int diff = choarr[i + m - 1] - choarr[i];
            if (diff < min_differnce) {
                min_differnce = diff;
            }
        }
        return min_differnce;
    }

    public static int rotSortArr(int arr[], int target) {
        // int[] rotArr = {4, 5, 6, 7, 0, 1, 2};
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) { // Change condition to low <= high
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            }

            // Check which side is sorted
            if (arr[low] <= arr[mid]) { // Left side is sorted
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1; // Target is in the left half
                } else {
                    low = mid + 1; // Target is in the right half
                }
            } else { // Right side is sorted
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1; // Target is in the right half
                } else {
                    high = mid - 1; // Target is in the left half
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        // ! Ques : Max and Min number in array
        int maxN = Integer.MIN_VALUE;
        int minN = Integer.MAX_VALUE;
        int arr[] = { 4, 3, 6, 8, 1, 7, 9, 9 };
        // Approch1:
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minN) {
                minN = arr[i];
            } else if (arr[i] > maxN) {
                maxN = arr[i];
            }
        }
        System.out.println("min num : " + minN + " && max num : " + maxN);
        // ! Ques : maxSub array
        System.out.println("max Sub array sum is : " + maxSubarray());

        // ! Ques : Chocolate Distribution problem
        // You need to find a subset of m packets from the n packets such that the
        // difference between the maximum and minimum chocolates in the selected packets
        // is minimized.
        System.out.println("Max number of chocolate is : " + choDispro());
        // ! Ques : Search in rotated sorted array
        int[] rotArr = { 5, 6, 0, 1, 2, 3, 4 };
        int target = 5;
        int result = rotSortArr(rotArr, target);
        if (result != -1) {
            System.out.println("target value is present");
        } else {
            System.out.println("target value is not present ");
        }

    }
}
