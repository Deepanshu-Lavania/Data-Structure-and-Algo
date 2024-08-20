package B_Searching;

public class Binary_03 {
    static boolean searchMatrixRowSort(int arr[][], int target) {
        int n = arr.length, m = arr[0].length;
        System.out.println(n+" , "+m);
        int si = 0, ei = n * m - 1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            int midEle = arr[mid / m][mid % m];//m is number of column
            if (target == midEle) {
                return true;
            }
            if (target < midEle) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return false;
    }
    static boolean searchMatRowColSort(int arr[][],int target){
        int n=arr.length,m=arr[0].length;//n=3,m=4
        int i=0,j=m-1;
        while (i<n && j>=0) {
            if (arr[i][j]==target) {
                return true;
            }
            if (arr[i][j]>target) {
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    static int mountainPeakEle(int arr[]){
        int si=0,ei=arr.length-1;
        int ans=-1;
        while (si<=ei) {
            int mid=si+(ei-si)/2;
            // if (arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) {
            //     return mid;
            // }
            // if (arr[si]<mid) {
            //     si=mid-1;
            // }else{
            //     ei=mid+1;
            // }
            if (arr[mid]<arr[mid+1]) {
                ans=mid+1;
                si=mid+1;
            }else{
                ei=mid-1;
            }

        }
        return ans;
    }
    static int findPeakEle(int arr[]){
        int si=0,ei=arr.length-1;
        int ans=-1;
        while (si<=ei) {
            int mid=si+(ei-si)/2;
            if ((mid==0||arr[mid-1]<arr[mid]) && (mid==ei-1||arr[mid]>arr[mid+1])) {
                return mid;
            }
            if (arr[mid]<arr[mid+1]) {// uphill/ascending
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {


       //? Point1 ===> Pattern Binary Search to find Peak Elements
       //? Point2 ====> Binary Search on 2D Matrix


        // ! Ques : Search element in 2D matrix  of dimension nXm and return true if found , elese return false.This matrix has following properties:
        //! 1. Integers in each row are sorted from left to Right
        //! 2. The first integer of each row is greater than the last integer of the previous row.
        System.out.println("<=========== Search value in 2D matrix & Each Row Sorted ===========>");
        int arr[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrixRowSort(arr, 60));

        //! Ques : Write an effincient alogorithm taht serarches for a value target in a mXn integer matrix matrix.This matrix has following properties:
        //! 1. Integers in each row are sorted from left to Right
        //! 2. Integers in each column are sorted in ascending from top to bottom
        System.out.println("<=========== Search value in 2D matrix & Each Row and Column Sorted ===========>");
        int arr1[][]={{2,4,6,8},{5,6,7,20},{7,11,13,25},{12,14,17,30}};
        System.out.println(searchMatRowColSort(arr1, 12));

        //! Ques : Fiven a mountains array 'a' of length greater than 3, return the index 'i' such that arr[0]<arr[l]<....<arr[i-l]<arr[i]>arr[i+l]>...>arr[arr.length-1].
        System.out.println("<=========== Mountain Peak Value in an array ===========>");
        int arr2[]= {1,2,3,4,5,3,1,0};
        System.out.println(mountainPeakEle(arr2));

        //! Ques : A peak element is an element that is strictily greater then its neighbors 
        //Given a --indexd integer array nums, find a peak element and retrun its index. If the array contains multiple peaks, return the indexto any of peaks.
        //You may imagine that nums[-1]=nums[n]=-infinty. In other words, an element's always considered to be strictly greater than a nerighbor that is outside the array and 
        //You must write an algorithm in O(logn) time.
        System.out.println("<========== Search Peak Value =============>");
        int arr3[]={1,2,3,1,3,5,6,4};
        System.out.println(findPeakEle(arr3));

    }
}
