package ArraysOneDimens;

import java.util.Scanner;

class ArrayObj {
    void SZeroOnes(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (count > 0) {
                arr[i] = 0;
                count--;
            } else {
                arr[i] = 1;
            }
        }

    }
}

public class Array_06 {
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

    // * Functions Call
    static void ZeroOnesPointer(int arr[], int left, int right) {
        System.out.println();
        while (left < right) {
            if (arr[left] == 1 && arr[right] == 0) {
                swaparr(arr, left, right);
                left++;
                right--;
            } else if (arr[left] == 0) {
                left++;
            } else if (arr[right] == 1) {
                right--;
            } else {
                break;
            }
        }
        printarr(arr);
    }

    static void EvenOdd(int arr[], int left, int right) {
        System.out.println();
        while (left < right) {
            if (arr[left] % 2 == 1 && arr[right] % 2 == 0) {
                swaparr(arr, left, right);
                left++;
                right--;
            }
            if (arr[left] % 2 == 0) {
                left++;
            }
            if (arr[right] % 2 != 0) {
                right--;
            }
        }
        printarr(arr);
    }

    static int[] NonDecSortArr(int arr[], int left, int right) {
        System.out.println();
        int ans[] = new int[arr.length];
        // while(left< right){
        // arr[left]*=arr[left];
        // arr[right]*=arr[right];
        // left++;
        // right--;
        // }
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = i+1; j < arr.length; j++) {
        // if(arr[i]>arr[j]){
        // swaparr(arr, i, j);
        // }
        // }
        // }
        int k = 0;
        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                ans[k++] = arr[left] * arr[left];
                left++;
            } else {
                ans[k++] = arr[right] * arr[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        //! Two array Pointers 

        ArrayObj arrObj = new ArrayObj();

        // ! Ques : Sort an Array consisting of only 0s and 1s.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // ? Approch Ist this is not optimized due to using two loops/Traversing
        arrObj.SZeroOnes(arr);
        printarr(arr);

        // ? Approch IInd, this is using pointers with single traverse
        ZeroOnesPointer(arr, 0, arr.length - 1);

        // ! Ques: Given an array of integers 'a' move all athe even integers at the
        // begining
        // of the array folleowed by all the odd integers. The relative order of odd or
        // even integers does not matter.
        int arrEvenOdd[] = { 1, 2, 3, 4, 5, 6, 7 };
        EvenOdd(arrEvenOdd, 0, arrEvenOdd.length - 1);

        // ! Ques: Given an integer array 'a' sorted in non-decreasing(can be repeated
        // value) order, return an array of the squares of each number sorted in
        // non-decreasing order.
        // int NonDecSortArr[] = { -10, -3, -2, 4, 11, 5 };
        int NonDecSortArr[]={-10,-3,-2,4,11,5};
        int[] NonDArry = NonDecSortArr(NonDecSortArr, 0, NonDecSortArr.length - 1);
        printarr(NonDArry);
    }
}
