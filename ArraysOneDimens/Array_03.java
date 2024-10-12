package ArraysOneDimens;
// import java.util.*;

import java.util.Arrays;

class ArraysClass {
    // ! Ques : To find the greater value and assign into another array
    void GrtValIntoAnot(int arr[]) {
        int val = 2;
        int[] tempArray = new int[arr.length];
        int count = 0;

        System.out.print("origianl array size is : " + arr.length);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > val) {
                System.out.println(arr[i] + " ");
                tempArray[count++] = arr[i];// it performs two operation firstly assign value into temp array then
                                            // increase the count/index for next value
            }
        }
        System.out.println();

        int[] newarr = new int[count];
        for (int i = 0; i < count; i++) {
            newarr[i] = tempArray[i];
            System.out.print(newarr[i] + " ");
        }
        System.out.println();
        System.out.print("new array size is : " + newarr.length);
    }

    // ! Ques : To check wheather array is sorted or not
    void isSortArr() {
        int arr[] = { 1, 2, 2, 2, 3, 4, 5 };
        System.out.println();
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }
        /*
         * for (int i = 0; i < arr.length; i++) {
         * for (int j =i+1; j < arr.length; j++) {
         * System.out.println(arr[i] +" : "+arr[j]);
         * if(arr[i]>arr[j]){
         * isSorted=false;
         * break;
         * }
         * }
         * }
         */
        System.out.println("Array is sorted : " + isSorted);
    }

    //using Extra Space
    int[] deleteElement(int[] arr, int index) {
        // Check for valid index
        if (index < 0 || index >= arr.length) {
            System.out.println("Invalid index");
            return arr;
        }

        // Create a new array of size one less than the original array
        int[] newArray = new int[arr.length - 1];

        // Copy elements before the index
        for (int i = 0; i < index; i++) {
            newArray[i] = arr[i];
        }
        // Copy elements after the index
        for (int i = index; i < arr.length - 1; i++) {
            newArray[i] = arr[i + 1];
        }

        return newArray;
    }

    int[] deleteElement(int[] arr, int index, int currentLength) {
        // Check for a valid index
        if (index < 0 || index >= currentLength) {
            System.out.println("Invalid index");
            return arr;
        }

        // Shift elements to the left
        for (int i = index; i < currentLength - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Optionally, you can set the last element to a default value (like 0)
        arr[currentLength - 1] = 0; // Just for clarity; this is not necessary.

        return arr;
    }
}

public class Array_03 {
    // ! Ques : To sort the array and then return array which contains smallest and
    // largest value
    static int[] sortArr(int arr[]) {
        // int Arr[]={2,6,4,1};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // * Arrays.sort(arr); //to sort the array */
        int ans[] = { arr[1], arr[arr.length - 2] };
        return ans;
    }

    public static void main(String[] args) {// main is the static keyword so it can't access the non-static variables
                                            // when you call function without static
        ArraysClass arr = new ArraysClass();

        int array[] = { 1, 2, 3, 4, 5 };
        arr.GrtValIntoAnot(array);

        arr.isSortArr();

        // ! Delete element :
        // ? In Java, arrays have a fixed size, so you cannot directly delete an element from an array like you can in more dynamic data structures (e.g., ArrayList). However, You can create a new array and copy all elements except the one you want to remove.
        System.out.println("<====After Deletion Using Extra space : ====>");
        System.out.println(Arrays.toString(arr.deleteElement(array, 2)));
        System.out.println("<=====After Deletion Without Using Extra space : =====>");
        System.out.println(Arrays.toString(arr.deleteElement(array, 2, array.length)));

        int Arr[] = { 2, 6, 4, 1, 4, 7, 2, 6, 9 };
        sortArr(Arr);
        System.out.println();
        System.out.println("smallest element : " + Arr[0]);
        System.out.println("Largest element : " + Arr[Arr.length - 1]);
    }
}
