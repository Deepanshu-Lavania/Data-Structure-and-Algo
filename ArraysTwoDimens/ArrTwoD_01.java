package ArraysTwoDimens;

import java.util.Scanner;

public class ArrTwoD_01 {

    static int[][] InputArry() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numebr of rows : ");
        int r = sc.nextInt();
        System.out.println("Enter number of column : ");
        int c = sc.nextInt();
        int arr[][] = new int[r][c];
        System.out.println("Enter " + r * c + " elements : ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;// it return 2D array
    }

    static void printArr(int arr[][]) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static void AddTwoDArray(int a[][], int r1, int c1, int b[][], int r2, int c2) {
        if (r1 != r2 || c1 != c2) {
            System.out.println("Wrong Dimension  - Addition not possible ");
            return;
        } else {
            int newArr[][] = new int[r1][c1];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    newArr[i][j] = a[i][j] + b[i][j];
                }
                System.out.println();
            }
            printArr(newArr);
        }
    }

    static void MultiplyTwoArray(int arr[][], int r1, int c1, int arr2[][], int r2, int c2) {
        if (c1 != r2) {
            System.out.println("Wrong Dimension  - Addition not possible ");
            return;
        } else {
            int MulArr[][] = new int[r1][c2];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    for (int k = 0; k < MulArr.length; k++) {
                        MulArr[i][j] += (arr[i][k] * arr2[k][j]);
                    }
                }
            }
            printArr(MulArr);
        }
    }

    static void TransposeArry(int arr[][], int r, int c) {
        int TraArry[][] = new int[c][r];// size matter in transpose
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                TraArry[j][i] = arr[i][j];
            }
        }
        System.out.println("Transpose of a Matrix is : ");
        printArr(TraArry);
    }

    // ? NOTE: For non-square matrices, you cannot transpose the matrix in place
    // since the resulting matrix would have different dimensions. Instead, you need
    // to create a new matrix to hold the transposed values.
    static void TransposeArryMemo(int arr[][], int r, int c) {
        for (int i = 0; i < r; i++) {// size matter

            // for (int j = i; j < c; j++) {
            // int temp = arr[i][j];
            // arr[i][j] = arr[j][i];
            // arr[j][i] = temp;
            // }

            for (int j = 0; j < c; j++) {
                if (i < j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }

        System.out.println("Transpose of a Matrix is : ");
        printArr(arr);
    }

    static int[] reverseArry(int arr[]) {
        int left = 0, right = arr.length - 1;
        for (int i = right; i > 0; i--) {
            if (left < right) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
        return arr;
    }

    static void TransposeReverseArry(int arr[][], int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i < j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {//i for each row in transpose matrix
            reverseArry(arr[i]);
        }
        printArr(arr);
    }

    static void PascalsTriangle(int arr[][],int r,int c){
        // int val= 2;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <=i; j++) {
                if(j==0 || j==i){
                    arr[i][j]=1;
                }else{
                    // arr[i][j]=val;
                    // val++;
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                }
            }
        }
        printArr(arr);
    }
    static void Pascal(int n){
        int arr[][]=new int[n][];
        for (int i = 0; i <n; i++) {
            //ith row has i+1 columns
            // arr[0]=new int[1];  //space for column at 0 row
            // arr[1]=new int[2];
            arr[i] = new int[i+1];//size manually declare for column
            arr[i][0] = arr[i][i]=1;

            for (int j = 1; j <i; j++) {
                arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
            }
        }
        printArr(arr);
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

        // System.out.println("Enter MATRIX B's Data ==> ");
        // System.out.println("Enter the numebr of rows : ");
        // int r2 = sc.nextInt();
        // System.out.println("Enter number of column : ");
        // int c2 = sc.nextInt();
        // int arr2[][] = new int[r2][c2];
        // System.out.println("Enter "+r2*c2 + " elements : ");
        // for (int i = 0; i < r2; i++) {
        // for (int j = 0; j <c2; j++) {
        // arr2[i][j] =sc.nextInt();
        // }
        // }
        // System.out.println("Matrix 1 :");
        // printArr(arr);
        // System.out.println("Matrix 2 :");
        // printArr(arr2);
        // ! Ques : Addition of two matrix
        // AddTwoDArray(arr, r1,c1,arr2,r2,c2);

        // ! Ques : Multiplication of two matrix
        // MultiplyTwoArray(arr,r1,c1,arr2,r2,c2);

        // ! Ques : Transpose of a matrix using extra space
        // TransposeArry(arr, r1, c1);

        // ! Ques : Transpose of a matrix without using extra space means transpse at in
        // place
        // TransposeArryMemo(arr, r1, c1);

        // ! Ques : Rotate of two matrix without using extra space at 90deg =====>HINT : Transpose of matrix + reverse each row
        // TransposeReverseArry(arr, r1, c1);

        // ! Ques : Print Pascal's triangle
        // int ary[][] = new int[r1][c1];
        // PascalsTriangle(ary,r1,c1);
        int n=sc.nextInt();
        Pascal(n);
    }
}
