package A_Sorting;

public class Problems_06 {
    static void printarr(int arr[]) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortSwapedTwoEle(int arr[]) {
        int x = -1;
        int y = -1;
        // ? Corner case, edge case
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                if (x == -1) {
                    x = i - 1;
                    y = i;
                } else {
                    y = i;
                }
            }
        }
        swap(arr, x, y);
    }

    static void seprateEle(int arr[], int l, int r) {

        while (l < r) {
            while (arr[l] < 0) {
                l++;
            }
            while (arr[r] >= 0) {
                r--;
            }
            if (l < r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        printarr(arr);
    }

    static void countTwoPass(int arr[]) {
        int count_0 = 0, count_1 = 0, count_2 = 0;
        // first pass
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count_0++;
            } else if (arr[i] == 1) {
                count_1++;
            } else {
                count_2++;
            }
        }
        System.out.print(count_0 + " , " + count_1 + " , " + count_2);
        // second pass
        int k = 0;
        while (count_0 > 0) {
            arr[k++] = 0;
            count_0--;
        }
        while (count_1 > 0) {
            arr[k++] = 1;
            count_1--;
        }
        while (count_2 > 0) {
            arr[k++] = 2;
            count_2--;
        }
        printarr(arr);

    }

    static void countOnePass(int arr[]) {
        int low = 0, mid = 0;
        int hi = arr.length - 1;
        while (mid <= hi) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, hi);
                hi--;
            } else {
                mid++;
            }
        }
        printarr(arr);
    }

    public static void main(String[] args) {
        // ! Ques : Given an array where all its elements are sorted in increasing order
        // except two swapped elements, sort it in linear time. Assume there are no
        // duplicates in the array
        // ? Explain: Array is sorted but there are two value swapped (two conflicts
        // present ) due to which sorted array is disturbed so now you have to find
        // those conflicts and correct the sorting
        int arr[] = { 10, 5, 6, 7, 8, 9, 3 };
        sortSwapedTwoEle(arr);
        printarr(arr);
        // ?sorting in linear time : O(n)

        // ! Ques : Given an array of +ve & -ve integers, segregate them in linear them
        // in linaer time and constant space. The output should print all -ve numberms,
        // followed by all +ve numbers.
        int segArr[] = { 19, -20, 7, -4, -13, 11, -5, 3 };
        seprateEle(segArr, 0, segArr.length - 1);

        // ! Ques : Given an array of size N containing only 0s, 1s, and 2s ; sort the array in ascending order
        // NOTE: Think for optimized solution/way
        // step 1 : Brutforce approch ==> Bubble, insertion , selection ==> O(n^2)
        // step 2: optimized way ===> merge and Quick ===> O(nlogn)
        // step 3 : Linear time complexity sorting ===> Count, Redix , Bucket ==> O(n)
        // think about these step and select suitable algo ; Count sort is used when
        // range is given and here rangle is (0-2) so countsort is best for this but
        // In count sort consist two pass i> for count number of occurance ii> sort it
        // according to index hence there time complity will become O(n+n) = O(2n) =
        // O(n) means it took two passes so we can also optimized it by reducing number
        // of passes

        // ? According to two passes
        int countArr[] = { 0, 2, 1, 2, 0, 0 };
        System.out.println("<========================= CountTwoPass =======================>");
        countTwoPass(countArr);
        //! Imp concept "Dutch National Flag problem"
        System.out.println("<=== CountOwoPass(Dutch National Flag problem (Using three pointer with UnKnown region)) ===>");
        countOnePass(countArr);
        //? time complexity : Linear i.e., O(n) and space : constant 



        
        //! "Dutch National Flag problem" 
        //? It is a classic computer science problem proposed by Edsger Dijkstra. The problem is named after the three-colored Dutch national flag and involves sorting an array with three distinct values.

        //? Problem Statement
        // You are given an array of N elements, each of which can be one of three colors: red, white, or blue. The goal is to rearrange the elements in such a way that all the red elements come before the white elements, which come before the blue elements. The solution should be done in-place with a single pass through the array

    }
}
