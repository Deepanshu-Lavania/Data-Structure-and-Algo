package B_Searching;

import java.util.Scanner;

public class Binary_01 {
    static boolean binSea(int arr[], int si, int ei, int target) {

        //! Using Iteration
        // while (si <= ei) {
        // int mid = si + (ei - si) / 2;
        // if (target == arr[mid]) {
        // return true;
        // } else if (target < arr[mid]) {
        // ei = mid - 1;
        // } else {
        // si = mid + 1;
        // }
        // }
        // return false;


        //! Using Recursion
        if (si > ei) {
            return false;
        }
        int mid = si + (ei - si) / 2;
        if (arr[mid] < target) {
            return binSea(arr, mid + 1, ei, target);
        } else if (arr[mid] > target) {
            return binSea(arr, si, mid - 1, target);
        } else {
            return true;
        }
    }

    static int QuesArr(int arr[],int si,int ei,int target){
        int fo=-1;
        while (si<=ei) {
            int mid = si + (ei - si) / 2;
            if(target==arr[mid]){
                fo=mid;
                // ei=mid-1;  //For first occurance 
                si=mid+1;
            }else if (target>arr[mid]) {
                // si=mid+1;
                ei=mid-1;
            }else{
                ei=mid-1;
            }
        }
        return fo;
    }
    static int findSqrt(int x){
        int si=0;
        int val=-1;
        int ei=x; 
        while (si<ei) {
            int mid=si+(ei-si)/2;
            if (mid*mid>x) {
                val=mid;
                ei=mid-1;
            }else if(mid*mid<x){
                val=mid;
                si=mid+1;
            }else{
                val=mid;
                return val;
            }
        }
        return val;
    }
    static int findRangeSqrt(int x){
        if (x>0) {
            return x*x;
        }
        return 0;
    }
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 6, 7, 9, 10 };
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        // while (target!=10) {
        // System.out.printf("%d exists in arr : %b ",target ,binSea(arr,0,
        // arr.length-1, target));
        // target++;
        // System.out.println();
        // }
        System.out.println(binSea(arr, 0, arr.length - 1, target));
        //? Time Complexity :n,n/2,n/4,n/8 ........ ,n/2^k ===> O(logn)
        
        //! NOTE :
        // * Binary search is efficient for sorted data or when you have multiple search queries on the same dataset, making the initial sorting worthwhile.
        // * Linear search is simpler and can be more efficient for a small number of search queries on unsorted data.

        //! Ques : Find the first occurance of a given element x, given that the fiven array is sorted If no occurance of x is found then return -1..
        int val=2;
        int Qarr[]={1,2,2,5,9,8,7,6,6};
        System.out.println( QuesArr(Qarr,0,Qarr.length-1,val));

        //! Ques : Find the UnderRoot and after it Calculate sqrt for given range
        int x=25;
        int sqrt = findSqrt(x);
        System.out.println(sqrt);
        System.out.println("Enter range to calculate sqrt forward ");
        int range = sc.nextInt();
        int rangeUpto= sqrt+range;
        for (int i = sqrt+1; i <= rangeUpto; i++) {
            System.out.print(findRangeSqrt(i)+" ");     
        }
    }
}