package ArraysOneDimens;

import java.util.Arrays;
import java.util.Scanner;

//! Array reference in Java
class CloneArray {
    void orgArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    void clonArray(int arr2[]) {
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    void CountValue(int arr[]) {
        System.out.print("Search value for finding number of occurances : ");
        Scanner sc = new Scanner(System.in);
        int val =sc.nextInt();
        int count = 0;
        int idx=-1;
        //! Ques : Find number of occurances of an element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("There is no element "+val+" so it has 0 occurances occur in the array ");
        } else {
            System.out.println("Number of occurances of " + val + " is " + count);
        }
        //! Ques : Find last occurance index of element
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==val){
                idx = i;
            }
        }if(idx==-1){
         System.out.println("There is no  element so there is no any last index occurance");
        }else{
            System.out.println("The last occurance of " +val +" is at index number "+ idx);
        }
    }
    //! Ques : Count the number of elment strictly greater than value x.
    void GreaterValue(int arr[]){
        int val =20;
        int notval=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>val){
                System.out.print(arr[i]+" ");
                notval++;
            }
        }
        if(notval==-1){
            System.out.println("There is no element so we can't count number greater than value");
        }else{
           return;
        }
       
    }
}

public class Array_02 {
    public static void main(String[] args) {
        CloneArray Array = new CloneArray();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter  size of array : ");
        int size = sc.nextInt();
        int number[] = new int[size];
        System.out.println("Enter " + size + " elements");
        for (int i = 0; i < size; i++) {
            number[i] = sc.nextInt();
        }
        for (int i = 0; i < number.length; i++) {
            System.out.println("the value of array is : " + number[i] + " at index " + i);
        }

        int arr[] = { 5, 6, 7, 8, 9 };
        System.out.println("Original array : ");
        Array.orgArr(arr);
        System.out.println();
        // *trying to copy new array
        int arr2[] = arr;
        System.out.println("Clone array : ");
        Array.clonArray(arr2);
        arr2[0] = 0;
        arr2[1] = 0;
        System.out.println();
        System.out.println("Original array after initialization : ");
        Array.orgArr(arr);
        System.out.println();
        System.out.println("Clone array after initialization : ");
        Array.orgArr(arr2);

        int array[] = { 5, 6, 5, 1, 5,4 };
        Array.CountValue(array);
        Array.GreaterValue(array);
    }
}
