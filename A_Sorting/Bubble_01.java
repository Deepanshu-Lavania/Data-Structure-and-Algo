package A_Sorting;

public class Bubble_01 {
    static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];

        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void BubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;// for optimization if array already sorted then no need to iterate for i
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {// have any swap happened
                break;
            }
        }
        printarr(arr);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        BubbleSort(arr);

        // ! Stable and Unstable sort :
        // example : 2,4,3,5,3*,8
        // Stable Sort : In which , Order of appearance of duplicate element is same as
        // given in an array
        // i.e., 2,3,3*,4,5,8
        // Unstable Sort : In which , Order of appearance of duplicate element does not
        // same as given in an array
        // i.e., 2,3*,3,4,5,8
        // ! In-place algorithm: Those algo in which no need to extra memory for sorting

        // ! Note:
        // ?Bubble Sort is the Stable sorting algo
        // ? Bubble Sort is In-place algo
    }
}
