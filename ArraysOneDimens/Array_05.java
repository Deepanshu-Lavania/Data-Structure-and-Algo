package ArraysOneDimens;

import java.util.Arrays;
import java.util.Scanner;

class ArrayClasses {

    void revArray() {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 4, 4, 6, 6, 7, 4, 3, 2 };
        int temp[] = new int[arr.length];
        int count = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            temp[count++] = arr[j];
        }
        // put reverse array into another array
        for (int i = 0; i < count; i++) {
            System.out.print(temp[i] + " ");// reverse array
        }
    }

    void revSameArr() {
        System.out.println();
        System.out.println();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 4, 4, 6, 6, 7, 4, 3, 2 };
        int j = 0;
        System.out.println();
        for (int i = arr.length - 1; i > j; i--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            // arr[i] = arr[j]; // ?you can't write this line here
            j++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    void rotateEle() {
        System.out.println();
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(arr));//? To print array using inbuilt function in java
        int newarr[] = new int[arr.length];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for rotation with extra space: ");
        int val = sc.nextInt();
        int count = 0;

        val = val % arr.length;
        for (int i = arr.length - val; i < arr.length; i++) {
            newarr[count++] = arr[i];
        }
        for (int i = 0; i <= (arr.length - val - 1); i++) {
            newarr[count++] = arr[i];
        }

        for (int i = 0; i < newarr.length; i++) {
            System.out.print(newarr[i] + " ");
        }
    }

    void FreqArr() {
        System.out.println();
        System.out.println("Freq arr : ");
        int powr = (int) (Math.pow(10, 3));
        System.out.println("powr " + powr);
        
        int arrEle[] = { 5, 34, 400, 1000, 560 };
        int arr[] = { 5, 6, 5, 400, 560, 1000, 400 };
        
        // Frequency array to store frequencies of elements in arr[]
        int Freqarry[] = new int[powr + 1];
        System.out.println("Size of Freqarry is: " + Freqarry.length);
    
        // Fill Freqarry[] by counting occurrences in arr[]
        for (int i = 0; i < arr.length; i++) {
            Freqarry[arr[i]]++;  // Increment count for each element in arr[]
        }
    
        // Now, for each element in arrEle[], print how many times it occurred in arr[]
        for (int i = 0; i < arrEle.length; i++) {
            // int ele= arrEle[i];
            System.out.println(arrEle[i] + " element occurs: " + Freqarry[arrEle[i]] + " time(s)");
        }
    }//? T.C : O(n + NumEle);
    

    void arry() {
        Scanner sc = new Scanner(System.in);
        int powr = (int) (Math.pow(10, 3));
        System.out.println("powr " + powr);
        // int NumEle ={5, 34, 400, 1000, 560};
        int arr[] = { 5, 6, 5, 400, 560, 1000, 400 };
        int Freqarry[] = new int[powr + 1];
        // ? NOTeImp : if you does not enter value into array then it automatically fill
        // 0 value at each location

        // * to fill the value at index */
        for (int i = 0; i < arr.length; i++) {
            Freqarry[arr[i]]++;
            // Freqarry[arr[i]] = Freqarry[arr[i]] + 1;
            //Freqarry[arr[i]] +=1;
        }
        // System.out.println(Arrays.toString(Freqarry));

        System.out.print("Enter number of elements to be searched : ");
        int NumEle = sc.nextInt();
        System.out.println();
        while (NumEle > 0) {
            System.out.println("Enter number to be searched ");
            int x = sc.nextInt();
            if (Freqarry[x] > 0) {
                System.out.println("YES" + " ");
            } else {
                System.out.println("NO" + " ");
            }
            NumEle--;
        }

    }//? T.C: O(n)

}

public class Array_05 {
    static void revSameArr2(int aray[], int i, int j) {
        while (j > i) {
            int temp = aray[j];
            aray[j] = aray[i];
            aray[i] = temp;
            i++;
            j--;
        }

    }

    static void printarr(int aray[]) {
        System.out.println();
        for (int j2 = 0; j2 < aray.length; j2++) {
            System.out.print(aray[j2] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayClasses arr = new ArrayClasses();
        // ! Ques : Reverse array by using another array memory
        arr.revArray();

        // ! Ques : Reverse array by using same array memory
        arr.revSameArr();

        int aray[] = { 1, 2, 3, 4, 5 };
        int i = 0, j = aray.length - 1;
        revSameArr2(aray, i, j);
        printarr(aray);
        // ! Ques: Rotate the given array 'a' by k steps, where k is non-negative where
        // k can be greater than n as well
        arr.rotateEle();

        // ! Ques: Rotate the given array 'a' by k steps, where k is non-negative
        // without using extra space where k can be greater than n as well

        int array[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(array));
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for rotation without extra space: ");
        int val = sc.nextInt();
        int n = array.length;
        val = val % n;
        revSameArr2(array, 0, n - val - 1);
        revSameArr2(array, n - val, n - 1);
        revSameArr2(array, 0, n - 1);
        printarr(array);

        // ! Ques : how much times element occur of one array into another array ===>
        // (optional)
        arr.FreqArr();

        // ! Ques : Given q queries, check if the given number is present in the array
        // or not .
        // Note : Value of all the elements in the array is less than 10 to the power 5.
        arr.arry();
    }
}
