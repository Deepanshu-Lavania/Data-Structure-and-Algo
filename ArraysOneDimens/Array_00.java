package ArraysOneDimens;

import java.util.Arrays;

public class Array_00 {

    public static int[] insertElement(int[] arr, int idx, int ele) {
        int[] newArray = new int[arr.length + 1];
        for (int i = 0; i < idx; i++) {
            newArray[i] = arr[i];
        }
        newArray[idx] = ele;
        for (int i = idx; i < arr.length; i++) {
            newArray[i + 1] = arr[i];
        }
        return newArray;
    }

    public static int[] insertElementInPlace(int arr[],int idx, int ele, int curLength){
        if ( idx>=curLength || arr.length==curLength) {
            System.out.println(" Array size is not enough to insert element ");
            return arr;
        }
        for (int i=curLength; i>=idx;i--) {
            arr[i+1]=arr[i];
        }
        arr[idx]=ele;

        return arr;
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 5, 6 };
        int index = 1;
        int newElement = 3;

        System.out.println("<===========Using Extra Space==========>");
        int[] newArray = insertElement(array, index, newElement);

        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("New array: " + Arrays.toString(newArray));

        System.out.println("<==========Without using Extra space==========>");
        int[] arr = new int[10]; // Allocated array of size 10
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        int currentLength = 4; // Current used length
        // Insert 10 at index 2
        int[] newArr = insertElementInPlace(arr, 2, 10, currentLength);
        System.out.println("New array: " + Arrays.toString(newArr));
    }
}

/*
 * 
 * The time complexity of the insertElement method in the given code is O(n),
 * where 𝑛
 * n is the number of elements in the original array.
 * 
 * Here's the detailed analysis:
 * 
 * Creating a New Array: Creating a new array of size 𝑛+1
 * n+1 takes constant time
 * 𝑂(1)
 * O(1), but the overall complexity is dominated by the subsequent operations.
 * Copy Elements Before Index: The loop copies elements from the start of the
 * original array to the new array up to the specified index. This takes
 * 𝑂(𝑘)
 * O(k) time, where
 * 𝑘
 * k is the index at which the new element is inserted.
 * 
 * Insert New Element: Inserting the new element at the specified index takes
 * constant time
 * 𝑂(1)
 * O(1).
 * 
 * Copy Remaining Elements: The loop copies the remaining elements from the
 * original array to the new array. This takes
 * 𝑂(𝑛−𝑘)
 * O(n−k) time, where 𝑛
 * n is the length of the original array and 𝑘
 * k is the index.
 * 
 * Since both loops together iterate over all elements of the array exactly
 * once, the total time complexity is 𝑂(𝑛)
 * O(n).
 */