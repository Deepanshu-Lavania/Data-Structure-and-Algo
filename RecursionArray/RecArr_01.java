package RecursionArray;

import java.util.Scanner;

public class RecArr_01 {

    static void printArrIncVal(int arr[], int idx) {
        if (idx == arr.length) {
            return;
        } else {
            System.out.print(arr[idx] + " ");
            printArrIncVal(arr, idx + 1);
        }
    }

    static void printArrDecVal(int arr[], int idx) {
        if (idx < 0) {
            return;
        } else {
            System.out.print(arr[idx] + " ");
            printArrDecVal(arr, idx - 1);
        }
    }

    static int printMaxValArr(int arr[], int idx, int maxVal) {
        if (idx == arr.length) {
            return maxVal;
        }
        // if (arr[idx] > arr[idx - 1]) {
        if(arr[idx]>maxVal){
            maxVal = arr[idx];
        }
        // Recursive call: check the next element and return the max value found
        return printMaxValArr(arr, idx + 1,maxVal);
    }
   
    static int printMinValArr(int arr[], int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }
        //Recursive work
        int smallAns = printMinValArr(arr, idx+1);
        //arr[idx] : Self work
        return Math.min(smallAns,arr[idx]);
    }
    
    static int printSumArry(int arr[],int idx){
        if(idx==arr.length){
            return 0;
        }else{
            return arr[idx]+printSumArry(arr, idx+1);
            //Self work + Recursive work
        }
    }
    
 
    
    public static void main(String[] args) {
        int arr[] = { 3, 10, 3, 2, 5 };
        // ! Ques : Print all values in increasing index order of array
        int indx = 0;
        printArrIncVal(arr, indx);

        System.out.println();
        // ! Ques : Print all values in Decreasing index order of array
        int idx = arr.length - 1;
        printArrDecVal(arr, idx);

        // ! Ques : Print the max vlaue of the Array
        System.out.println();
        int index=0;
        int maxVal = 0;
        System.out.println("The max value in array is : " + printMaxValArr(arr, index, maxVal));
        //? Time Complexity : O(n)


        // ! Ques : Print the min vlaue of the Array
        System.out.println();
        System.out.println("The min value in array is : " + printMinValArr(arr, index));
        //? Time Complexity : O(n)
//! Ques : Print the sum of value in array
        System.out.println();
        System.out.println("The sum of array element is :"+printSumArry(arr,index));

        
       
        
    }
}
