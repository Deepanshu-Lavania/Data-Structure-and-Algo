package ArraysTwoDimens;

import java.util.Scanner;

public class ArrTwoD_03 {
    static void printArr(int arr[][]) {
        System.out.println(" output is : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static int[][] findPrefixRowsumMatrix(int arr[][]){
        int r=arr.length;
        int c=arr[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                arr[i][j]=arr[i][j-1]+arr[i][j];
            }
        }
        return arr;
    }
    static int[][] findPrefixColsumMatrix(int arr[][]){
        int r= arr.length;
        int c = arr[0].length;
        for (int j = 0; j < c; j++) {//outer column for column
            for (int i = 1; i < r; i++) {//onner row 
                arr[i][j]=arr[i][j]+arr[i-1][j];
            }
        }
        return arr;
    }
    static void CorSumMatrx(int arr[][], int r, int c) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row coordinate elements l1 & m1 : ");
        int l1 = sc.nextInt();
        int m1 = sc.nextInt();
        System.out.println("Enter column coordinate elements l2 & m2 : ");
        int l2 = sc.nextInt();
        int m2 = sc.nextInt();

        //! Method 1 : using double iteraion in array to calculate rectangle sum 
        int sumMe = 0;
        System.out.println("By using Brut force method without using optimization method : ");
        for (int i = l1; i <= l2; i++) {
            for (int j = m1; j <= m2; j++) {
                sumMe = sumMe + arr[i][j];
            }
        }
        System.out.println("The sum of rectangle is : " + sumMe);
        System.out.println();

//! Method 2 : Prefix sum over rows to calculate rectangle sum
        System.out.println("By using optmized technique : ");
        // //? To find preffixSum
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                arr[i][j] = arr[i][j] + arr[i][j - 1];
            }
        }
        System.out.println("After Calculating prefix sum for each row : ");
        printArr(arr);
        // //? To find sum
        System.out.println("The sum of rectangle  according to rectangle : ");
        for (int i = l1; i <= l2; i++) {
            if (i >= l1 && m1 >= 1) {
                sum += arr[i][m2] - arr[i][m1 - 1];
            } else {
                sum += arr[i][m2];
            }
        }
        System.out.println("The sum of rectangle is : " + sum);


        //! Method 3 : Prefix sum Over columns and Rows both

        // System.out.println("Prefix sum Over Rows arr : ");
        // findPrefixRowsumMatrix(arr);
        System.out.println("Prefix sum Over Columns arr : ");
        findPrefixColsumMatrix(arr);
        
        printArr(arr);
        int ans = 0,summation=0,up=0,left=0,leftup=0;

        summation=arr[l2][m2];

        if(l1>=1){
            up=arr[l1-1][m2];
        }

        if(m1>=1){
            left=arr[l2][m1-1];
        }
        if(l1>=1 && m1>=1){
            leftup=arr[l1-1][m1-1];
        }
        ans = summation - up -left + leftup;
       
        System.out.println();
        System.out.print("The sum for method 3 is : "+ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter MATRIX A's Data ==> ");
        System.out.println("Enter the numebr of rows : ");
        int r1 = sc.nextInt();
        System.out.println("Enter number of column : ");
        int c1 = sc.nextInt();
        int arr[][] = new int[r1][c1];
        System.out.println("Enter " + r1 * c1 + " elements : ");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix 1 :");
        printArr(arr);
        //! Ques : Gicen a matrix 'a' of dimension r X c and 2 coordinates(l1,r1) and (l2,r2) ,Return the sum of the rectangle from (l1,m1) to (l2,m2).
        //? Sum of rectangle using  i>Brut force method. ii> Pre-Calculating the horizontal sum for each row. iii> Prefix sum over both rows and columns 
        //? HINT : l2>=l1 , m2>=m1 , 0<= l1,l2<r, 0<=m1,m2<c
        CorSumMatrx(arr, r1, c1);

        
    }
}
