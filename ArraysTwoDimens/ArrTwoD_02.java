package ArraysTwoDimens;

import java.util.Scanner;

public class ArrTwoD_02 {
    static void printArr(int arr[][]) {
        System.out.println(" output is : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static void spiralMatrx(int arr[][], int r, int c) {
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalElement = 0;
        while (totalElement < r * c) {
            for (int j = leftCol; j <= rightCol && totalElement < r * c; j++) {
                System.out.print(arr[topRow][j] + " ");
                totalElement++;
            }
            topRow++;
            for (int i = topRow; i <= bottomRow && totalElement < r * c; i++) {
                System.out.print(arr[i][rightCol] + " ");
                totalElement++;
            }
            rightCol--;
            for (int j = rightCol; j >= leftCol && totalElement < r * c; j--) {
                System.out.print(arr[bottomRow][j] + " ");
                totalElement++;
            }
            bottomRow--;
            for (int i = bottomRow; i >= topRow && totalElement < r * c; i--) {
                System.out.print(arr[i][leftCol] + " ");
                totalElement++;
            }
            leftCol++;
        }

        // for (int i = 0; i < r; i++) {
        // for (int j = 0; j < c; j++) {
        // if ((i == 0 || j == r - 1)) {
        // System.out.print(arr[i][j]+" ");
        // }
        // }
        // }
        // for (int i = 0; i <r; i++) {
        // for (int j = c - 1; j >= 0; j--) {
        // if (i==r-1 && j!=i) {
        // System.out.print(arr[i][j]+" ");
        // }
        // }
        // }
        // for (int i = r-1; i >0; i--) {
        // for (int j = 0;j<c; j++) {
        // if(i<r-1 && j==0){
        // System.out.print(arr[i][j]+" ");
        // }
        // }
        // }
    }

    static void spiralMatrixSize(int n) {
        int r = n, c = n;
        int arr[][] = new int[r][c];
        int count = 1;
        int totalElement = 0;
        int topRow = 0, bottomRow = r - 1, rightCol = c - 1, leftCol = 0;
        while (totalElement < r * c) {
            for (int j = leftCol; j <= rightCol && totalElement < r * c; j++) {
                arr[topRow][j] = count;
                count++;
                totalElement++;
            }
            topRow++;

            for (int i = topRow; i <= bottomRow && totalElement < r * c; i++) {
                arr[i][rightCol] = count;
                count++;
                totalElement++;
            }
            rightCol--;
            for (int j = rightCol; j >= leftCol && totalElement < r * c; j--) {
                arr[bottomRow][j] = count;
                count++;
                totalElement++;
            }
            bottomRow--;

            for (int i = bottomRow; i >= topRow && totalElement < r * c; i--) {
                arr[i][leftCol] = count;
                count++;
                totalElement++;
            }
            leftCol++;
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

        System.out.println("Matrix 1 :");
        printArr(arr);

        // ! Ques : To print the spiral matrix
        // spiralMatrx(arr, r1, c1);
        // ! Ques : To print spiral matrix with input n X n matrix
        System.out.println("Enter number for print matrix n X n : ");
        int n = sc.nextInt();
        spiralMatrixSize(n);
    }
}
