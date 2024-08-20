package RecursionArray;
import java.util.*;
import java.util.Scanner;

public class RecArr_02 {
    static boolean printExistEle(int arr[], int idx, int val) {
        if (idx == arr.length) {
            return false;
        }
        if (arr[idx] == val) {
            return true;
        } else {
            return printExistEle(arr, idx + 1, val);
        }
    }

    static int printExistEleInx(int arr[], int idx, int val) {
        if (idx == arr.length) {
            return -1;
        }
        if (arr[idx] == val) {
            return idx;
        } else {
            return printExistEleInx(arr, idx + 1, val);
        }
    }

    static void printExistEleMulInx(int arr[], int idx, int val) {
        if (idx == arr.length) {
            return;
        }
        if (arr[idx] == val) {
            System.out.print(idx + " ");
        }
        printExistEleMulInx(arr, idx + 1, val);

    }
    static ArrayList<Integer> ExistEleIdxArrList(int arr[], int idx , int val){
        if(idx==arr.length){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ans =new ArrayList<>();
        //self work
        if(arr[idx]==val){
            ans.add(idx); 
        }
        //Recursive work
        ArrayList<Integer> smallans = ExistEleIdxArrList(arr,idx+1,val);
        ans.addAll(smallans);
        return ans;
    }

    static int checkSortedArr(int arr[],int idx,int check){
        if(idx>=arr.length){
            return check;//it is important to return the check in stack
        }
        if(arr[idx]<arr[idx-1]){
            check=1;
            return check;
        }
       return checkSortedArr(arr, idx+1,check);
     
    }

    public static void main(String[] args) {
        int arr[] = {  1,2,3,4,7,9,7,8,9};
        int idx = 0;
        // ! Ques :Check element exists or not
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value to check in array : ");
        int val = sc.nextInt();

        if (printExistEle(arr, idx, val)) {
            System.out.println("Element " + val + "  exists in the array");
        } else {
            System.out.println("Element " + val + " does not exist in the array");
        }
        // ! Ques : Check element exists or not if exist then return its first index
        if (printExistEleInx(arr, idx, val) > -1) {
            System.out.println(
                    "Element " + val + " exists in the array at index number " + printExistEleInx(arr, idx, val));
        } else {
            System.out.println("Element " + val + " does not  exists in the array");
        }
        // ! Ques : Check element exists or not if exist then return its index
        System.out.print(val + " exists at these index : ");
        printExistEleMulInx(arr, idx, val);
        // ! Ques : Check element exists or not if exist then return its index in arrayList 

        ArrayList<Integer> ans=ExistEleIdxArrList(arr, idx, val);
        System.out.println();
        // System.out.println(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }

        //! Ques :Check whether aray is sorted or not
        System.out.println();
        int check= 0;
        if ( checkSortedArr(arr,1,check)==0) {
            System.out.println("array is sorted");
        }else{
            System.out.println("Array element is not sorted");
        }
       
    }
}
