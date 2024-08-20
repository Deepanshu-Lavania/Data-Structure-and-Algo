package A_Sorting;

public class MergeQuick_04 {

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void conquereArr(int arr[], int si, int mid, int ei) {
        int mergedArr[] = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;
        while (idx1 <= mid && idx2 <= ei) {// if size are equal of both divide arrays
            if (arr[idx1] <= arr[idx2]) {
                mergedArr[x++] = arr[idx1++];
            } else {
                mergedArr[x++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {// if arr1 size are greater than another arr2
            mergedArr[x++] = arr[idx1++];
        }
        while (idx2 <= ei) {// if arr2 size are greater than another arr1
            mergedArr[x++] = arr[idx2++];
        }

        for (int i = 0, j = si; i < mergedArr.length; i++, j++) {
            arr[j] = mergedArr[i];
        }
    }

    static void divedeArr(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        divedeArr(arr, si, mid);
        divedeArr(arr, mid + 1, ei);
        conquereArr(arr, si, mid, ei);
    }

    // static int partitionEle(int arr[], int si, int ei) {
    //     int pivot = arr[si];
    //     int count = 0;
    //     for (int i = si + 1; i <= ei; i++) {
    //         if (arr[i] <= pivot) {
    //             count++;
    //         }
    //     }
    //     int pivotIndex = si + count;
    //     swap(arr, si, pivotIndex);
    //     int i = si;
    //     int j = ei;
    //     // element lesser or equal left of pivotIndex, greater --> right side of
    //     // pivotIndex
    //     while (i < pivotIndex && j > pivotIndex) {
    //         while (arr[i] <= pivot)
    //             i++;
    //         while (arr[j] > pivot)
    //             j--;
    //         if (i < pivotIndex && j > pivotIndex) {
    //             swap(arr, i, j);
    //             i++;
    //             j--;
    //         }
    //     }
    //     return pivotIndex;
    // }

    static int partitionEle(int arr[],int si, int ei){
        int pivot = arr[si];
        int i=si;
        for (int j = si+1; j <=ei ; j++) {
            if(arr[j]<=pivot){
                i++;
                swap(arr, i, j);
            }
        }
        // swap(arr, pivot, i); //===> arr, arr[arr[si]],i
        swap(arr, si, i);
        return i;
        
       //? Yes, the partitioning step of QuickSort has linear time complexity,O(n)
    }
    static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivot = partitionEle(arr, si, ei);
        quickSort(arr, si, pivot - 1);
        quickSort(arr, pivot + 1, ei);
    }

    public static void main(String[] args) {
        int arr[] = { 7, 13, 8, 5, 10, 2, 4 };
        divedeArr(arr, 0, arr.length - 1);
        printarr(arr);

        System.out.println();
        int quickArr[] = { 7, 13, 3, 1, 4, 7, 8 };

        quickSort(quickArr, 0, quickArr.length - 1);
        printarr(quickArr);

    }
}
