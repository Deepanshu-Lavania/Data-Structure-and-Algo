package A_Sorting;

public class Problems_03 {
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

    static void BubLastEle(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                // if(arr[j]>arr[j+1]){
                //     swap(arr, j,j+1);
                // }
                if(arr[j]==0 && arr[j+1]!=0){
                    swap(arr, j, j+1);
                }
            }
        }
        printarr(arr);
    }
    static String[] selStrSort(String arr[]){
        for (int i = 0; i < arr.length; i++) {
            int min_idx=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[min_idx])<0){
                    min_idx=j;
                }
            }
            String temp = arr[i];
            arr[i]=arr[min_idx];
            arr[min_idx]=temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[]={0,5,0,3,4,2};
        //! Ques : Given an integer array arr, move all 0's to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.
        //? Bubble Sort in which we tends elements to last side
        BubLastEle(arr);
System.out.println();
        //! Quse : Given an array of names of the fruits, you arre supposed to sort it in lexicographical order using the selection sort 
        //? Note:  lexicographical order is known as dictionary order 
        String arrStr[] = {"papaya","lime","watermelon","apple","mango","kiwi"};
        selStrSort(arrStr);
        for (int i = 0; i < arrStr.length; i++) {
            System.out.print(arrStr[i]+" ");
        }
        //? compareTo ===> This method is used in string to compare two string elements in array
       /*  if s1.compareTo(s2)<0 then it return -ve value
        if s1.compareTo(s2)>0 then it return +ve value
        if s1.compareTo(s2)==0 then it return 0 */

    }
}
