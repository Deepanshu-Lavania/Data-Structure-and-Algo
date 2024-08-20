package ArraysOneDimens;

import java.util.Arrays;

public class Array_00 {

    public static int[] insertElement(int[] originalArray, int index, int newElement) {
        int[] newArray = new int[originalArray.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = originalArray[i];
        }

        newArray[index] = newElement;

        for (int i = index; i < originalArray.length; i++) {
            newArray[i + 1] = originalArray[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 5, 6 };
        int index = 1;
        int newElement = 3;

        int[] newArray = insertElement(array, index, newElement);

        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("New array: " + Arrays.toString(newArray));
    }
}



/* 

The time complexity of the insertElement method in the given code is O(n), where 𝑛
n is the number of elements in the original array.

Here's the detailed analysis:

Creating a New Array: Creating a new array of size 𝑛+1
n+1 takes constant time 
𝑂(1)
O(1), but the overall complexity is dominated by the subsequent operations.
Copy Elements Before Index: The loop copies elements from the start of the original array to the new array up to the specified index. This takes 
𝑂(𝑘)
O(k) time, where 
𝑘
k is the index at which the new element is inserted.

Insert New Element: Inserting the new element at the specified index takes constant time 
𝑂(1)
O(1).

Copy Remaining Elements: The loop copies the remaining elements from the original array to the new array. This takes 
𝑂(𝑛−𝑘)
O(n−k) time, where 𝑛
n is the length of the original array and 𝑘
k is the index.

Since both loops together iterate over all elements of the array exactly once, the total time complexity is 𝑂(𝑛)
O(n). */