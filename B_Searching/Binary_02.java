package B_Searching;

public class Binary_02 {
    static int rotateIdx(int arr[]) {
        int si = 0;
        int ans = -1;
        int ei = arr.length - 1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] <= arr[ei]) {
                ans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return ans;
    }

    static int findEleRotated(int arr[], int target) {
        int si = 0;
        int ei = arr.length - 1;

        while (si < ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < arr[ei]) {
                if (target >= arr[mid] && target <= arr[ei]) {//we don't check equal in mid because mid handle target which is check in if-block condition
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            } else {
                if (target >= arr[si] && target < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
        }
        return -1;

    }

    static int eleRotateDuplicate(int arr[], int target) {
        int si = 0;
        int ei = arr.length - 1;
    
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid] == target) {
                return mid;
            }
    
            // When we encounter duplicates, we just move the pointers inward
            if (arr[si] == arr[mid] && arr[mid] == arr[ei]) {
                si++;
                ei--;
            } else if (arr[mid] <= arr[ei]) { // Right side is sorted
                if (target > arr[mid] && target <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            } else { // Left side is sorted
                if (target >= arr[si] && target < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
        }
        return -1;
    }
    

    public static void main(String[] args) {
        // ? Pattern Searching in "Rotated Sorted Array"
        // ! Quse : A rotated sorted array is a sorted array on which rotation operation
        // has been performed some number of times . Given a rotated sorted array, find
        // the index of the minimum element in the array follow 0-based indexing.

        int arr[] = { 5, 1, 2, 3, 4 };
        // for (int i = 1; i < arr.length; i++) {
        // if(arr[i]<arr[i-1]){
        // System.out.print(i+" ");
        // break;
        // }
        // }time complexity is linear so we use another way to find optimized solution
        //
        System.out.println("<======== Rotate array Element occurance start is at =========>");
        System.out.println(rotateIdx(arr));

        // ? Properties of Rotated sorted Arrays
        // step1 : i> x to mid --> sorted and mid to y ---> sorted
        // ii> One of them will be sorted & other will be unsorted
        // step2 : if value present unique in sorted rotated array then x to y will be
        // sorted
        // ! Ques : Given the roated sorted array of integers, which "contains distinct elements", and an integer, return the index of target if it is in the array, Otherwise return -1
        // * Approch 1: Using above question find min number then apply two times binary
        // search on each seperated sorted element , it will takes three binary search
        // but we have to calculate it in one binary search
        System.out.println("<============== Element is at index ==============>");
        int eleRotate[] = { 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(findEleRotated(eleRotate, 12));

        // ! Ques : Given the roated sorted array of integers, which "does not contain distinct elements", and an integer, return the index of target if it is in the array, Otherwise return -1
        int eleRotateDup[] = { 1,2,1,1,1,1,1,1,1,1};
        System.out.println(eleRotateDuplicate(eleRotateDup,2));
    }
}
