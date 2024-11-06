package A_1DArray;

import java.util.Arrays;

public class Med_02 {
    public static int trapedWater(int towerHeight[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        int leftmax[] = new int[towerHeight.length];
        int rightmax[] = new int[towerHeight.length];
        for (int i = 0; i < towerHeight.length; i++) {
            // find leftmax
            max = Math.max(max, towerHeight[i]);
            leftmax[i] = max;
        }
        for (int i = towerHeight.length - 1; i >= 0; i--) {
            min = Math.max(min, towerHeight[i]);
            rightmax[i] = min;
        }
        System.out.println(Arrays.toString(leftmax));
        System.out.println(Arrays.toString(rightmax));
        // Calculate trapped water
        int water = 0;
        for (int i = 0; i < towerHeight.length; i++) {
            int waterLevel = Math.min(leftmax[i], rightmax[i]);
            water += Math.max(0, waterLevel - towerHeight[i]);
        }
        return water;
    }

    public static void multiplyArry() {
        int arr[] = { 1, 2, 3, 4 };
        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            ans = ans * arr[i];
        }
        for (int i = 0; i < arr.length; i++) {

            arr[i] = ans / arr[i];
        }
        System.out.println(Arrays.toString(arr));
        // ? T.C : O(n)
    }

    public static int[] multiplyArryII() {
        int arr[] = { 1, 2, 3, 4 };
        int output[] = new int[arr.length];
        int leftproduct = 1;
        for (int i = 0; i < arr.length; i++) {
            output[i] = leftproduct;
            leftproduct *= arr[i];
        }
        int rightproduct = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            output[i] *= rightproduct;
            rightproduct *= arr[i];
        }
        return output;
        // ? T.C : O(n) and S.C: O(n)
    }

    public static int maxProdSubary() {
        int arr[] = { 2, 3, -2, 4 };
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxProduct;
                maxProduct=minProduct;
                minProduct=temp;
            }
            maxProduct = Math.max(arr[i], maxProduct * arr[i]);
            minProduct = Math.min(arr[i], minProduct * arr[i]);
            result = Math.max(result, maxProduct);
        }
        return result;
    }

    public static int minValRotArry(){
        int nums[]={4,5,6,7,-5,-4,-3,1,2};
        int left = 0;
        int right = nums.length - 1;
        if(left==right){
            return nums[left];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
    public static void sortRotArr() {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int target_sum = 16;
        int n = arr.length;
    
        // Step 1: Find the pivot point (largest element in the array)
        int largest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                largest = i;
                break;
            }
        }
        int smallest = (largest + 1) % n; // Index of the smallest element
        // Step 2: Initialize two pointers
        int left = smallest; // Smallest element index
        int right = largest; // Largest element index
    
        // Step 3: Find the pair
        while (left != right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target_sum) {
                System.out.println("Pair is: " + arr[left] + " , " + arr[right]);
                return;
            }
            // Move the pointers
            if (currentSum < target_sum) {
                left = (left + 1) % n; // Move right (next higher value)
            } else {
                right = (right - 1 + n) % n; // Move left (next lower value)
            }
        }
    
        System.out.println("No pair found with the given sum.");
    }
    
    public static void main(String[] args) {
        System.out.println("<=======trap rain Water=========>");
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trapedWater(height));
        System.out.println("<========Using Devision Method but not applicable for zero =========>");
        multiplyArry();
        System.out.println("<========Using Non-Devision Method==========>");
        int ans[]=multiplyArryII();
        System.out.println(Arrays.toString(ans));
        System.out.println("<============Max product of subarray============>");
        System.out.println(maxProdSubary());
        System.out.println("<==========Find min value from rotated array==========>");
        System.out.println("MinVAl from rotated Array : "+ minValRotArry());
        System.out.println("<==========Find pair sum in sorted and rotated array==============>");
        sortRotArr();
    }
}
