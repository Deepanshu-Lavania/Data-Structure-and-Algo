package ArraysOneDimens;

import java.util.Scanner;

public class Array_07 {
    static int[] inputarry() {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        // System.out.println();
        System.out.print("Enter value in array : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swaparr(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void PrefixSum() {
        int arr[] = { 5, 4, 1, 3, 2, 5 };

        // BrutForse Method :
        // int j = 0;
        // int sum = 0;
        // for (int i = 0; i < arr.length; i++) {
        // sum = arr[i] + sum;
        // System.out.print(" sum is : " + sum + " ");
        // if (i == j) {
        // arr[j] = sum;
        // System.out.println(arr[i]);
        // }
        // j++;
        // }

        // ? Optimized method
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];// ? This is optimized code because it does not traverse array again and again
                                         // for sum
        }
        printarr(arr);
    }

    static void SuffixSum() {
        System.out.println();
        int arr[] = { 5, 4, 1, 3, 2 };
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                arr[i] = arr[i];
            } else {
                arr[i] = arr[i + 1] + arr[i];
            }
        }
        System.out.print("Suffix array is : ");
        printarr(arr);
    }

    static void ElePrefixSum() {
        int arr[] = { 2, 4, 1, 3, 6 };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of l and r : ");
        int StartIndex = sc.nextInt() - 1;// converted it into 1-based indexing
        int r = sc.nextInt() - 1;
        int sum = 0;

        if (StartIndex < 0 || r >= arr.length || StartIndex > r) {
            System.out.println("Invalid indices.");
            return;
        }
        // ? Brutforce Method
        // for (int i =StartIndex; i <= r; i++) {
        // sum = sum + arr[i];
        // }
        // System.out.println("The sum is : " + sum);

        // ? Optimized Method
        for (int i = 1; i < arr.length; i++) {// Find Prefix sum
            arr[i] = arr[i - 1] + arr[i];
        }
        for (int i = StartIndex; i <=r; i++) {// Calculate sum from range l to r through prefixSum array
            sum = arr[r] - arr[StartIndex - 1];
            
        }
        System.out.print("The sum is : " + sum);
    }

    static boolean SubarryPreSuffSum(int arr[]) {
        System.out.println();
        // for (int i = arr.length; i >0; i--) {
        // arr[i] =arr[i+1]+arr[i];
        // }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        int count = 0;
        int TotalSum = arr[arr.length - 1];
        System.out.println(TotalSum);
        for (int i = 0; i < arr.length; i++) {
            int prefixSum = arr[i];
            int SuffixSum = TotalSum - prefixSum;
            System.out.println(prefixSum + " : " + SuffixSum);
            if (SuffixSum == prefixSum) {
                count++;
                break;
            }
        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        // ! Ques : Given an integer array 'a' return the prefix sum/running sum in the
        // same array without creating a new array.
        PrefixSum();
        // SuffixSum(inputarry());
        /*
         * Example: Given an array arr = [1, 2, 3, 4], the suffix sum array would be:
         * suffix[3] = 4
         * suffix[2] = 3 + 4 = 7
         * suffix[1] = 2 + 3 + 4 = 9
         * suffix[0] = 1 + 2 + 3 + 4 = 10
         * The resulting suffix sum array would be: suffix = [10, 9, 7, 4].
         */
        SuffixSum();

        // ! Ques : Given an array of integersof size n. Answer q queries where you need
        // to print the sum of values in a given range of indices from l to r(both
        // included). Note: The values of l and r in queries follow 1-based indexing.
        ElePrefixSum();

        // ! Ques : Check if we can partition the array into subarrays with equal sum.
        // More formally, check that the prefix sum of a part of the array is equal to
        // the suffix sum of rest of the array.
        System.out.println("Equal Partition possible : " + SubarryPreSuffSum(inputarry()));
    }
}
