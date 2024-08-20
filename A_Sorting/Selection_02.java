package A_Sorting;

public class Selection_02 {
    static void printarr(int arr[]) {
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

    static void selSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
        printarr(arr);
    }

    static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j>0; j--) {
                if (arr[j]<arr[j-1]) {
                    swap(arr, i, j);
                }
            }
            // int j =i;
            // while (j>0 && arr[j]>arr[j-1]) {
            //     swap(arr, i, j);
            //     j--;
            // }
        }
        printarr(arr);
    }

    public static void main(String[] args) {
        System.out.println("<=============== Selection sort =======================>");
        int arr[] = { 1, 2,3,46,9,77,7,7,7,8,66, 4, 5, 3 };
        selSort(arr);
        //? T.C : O(n^2)
        System.out.println("<=================Insertion sort =================>");
        System.out.println();
        insertionSort(arr);
        //? T.C : O(n^2)
    }
}
