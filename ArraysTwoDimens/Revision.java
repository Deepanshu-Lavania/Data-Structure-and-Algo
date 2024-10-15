package ArraysTwoDimens;

import java.util.Scanner;

public class Revision {
    static void printarr(int arr[][]) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void reverseEachRow(int arr[]) {
        int i = 0;
        for (int j = arr.length - 1; j > i; j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
    }

    /*
     * public static void PascalsTriangle(int arr[][]){
     * int r=arr.length;
     * int c=arr[0].length;
     * if (r!=c) {
     * System.out.println("matrix shold be squared ");
     * return;
     * }
     * for (int i = 0; i < r; i++) {
     * for (int j = 0; j < c; j++) {
     * if (i==j || j==0) {
     * arr[i][j]=1;
     * }
     * else if (i<j) {
     * arr[i][j]=0;
     * }
     * else{
     * arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
     * }
     * }
     * }
     * }
     */
    public static int[][] PascalsTriangle(int n) {
        int ans[][] = new int[n][];// coumn is not fixed so we don't initialize the column due to dynamic column at
                                   // each row
        for (int i = 0; i < n; i++) {
            ans[i] = new int[i + 1];// 1 D array for each row
            ans[i][0] = ans[i][i] = 1;
            for (int j = 1; j < i; j++) {
                ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
            }
        }
        return ans;

    }

    public static void printSpiralmatrix(int arr[][]) {
        int r = arr.length;
        int c = arr[0].length;
        int totalElement = 0;
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        while (totalElement < r * c) {
            // top row-> leftcol to rightcol
            for (int j = leftCol; j <= rightCol && totalElement < r * c; j++) {
                System.out.print(arr[topRow][j] + " ");
                totalElement++;
            }
            topRow++;
            // rightcol->topRow to BottomRow
            for (int i = topRow; i <= bottomRow && totalElement < r * c; i++) {
                System.out.print(arr[i][rightCol] + " ");
                totalElement++;
            }
            rightCol--;
            // bottomRow -> rightCol to leftCol
            for (int j = rightCol; j >= leftCol && totalElement < r * c; j--) {
                System.out.print(arr[bottomRow][j] + " ");
                totalElement++;
            }
            bottomRow--;
            // leftCol -> bottomRow to toprow
            for (int i = bottomRow; i >= topRow && totalElement < r * c; i--) {
                System.out.print(arr[i][leftCol] + " ");
                totalElement++;
            }
            leftCol++;
        }
    }

    public static void printNumSpiralmtrx(int n) {
        int r = n;
        int c = n;
        int arr[][] = new int[n][n];
        int count = 1;
        int totalElement = 0;
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        while (totalElement < r * c) {
            // top row-> leftcol to rightcol
            for (int j = leftCol; j <= rightCol && totalElement < r * c; j++) {
                arr[topRow][j] = count++;
                totalElement++;
            }
            topRow++;
            // rightcol->topRow to BottomRow
            for (int i = topRow; i <= bottomRow && totalElement < r * c; i++) {
                arr[i][rightCol] = count++;
                totalElement++;
            }
            rightCol--;
            // bottomRow -> rightCol to leftCol
            for (int j = rightCol; j >= leftCol && totalElement < r * c; j--) {
                arr[bottomRow][j] = count++;
                totalElement++;
            }
            bottomRow--;
            // leftCol -> bottomRow to toprow
            for (int i = bottomRow; i >= topRow && totalElement < r * c; i--) {
                arr[i][leftCol] = count++;
                totalElement++;
            }
            leftCol++;
        }
        printarr(arr);

    }
    public static void findPrefixSum2DMtrx(int arr[][]){
        int r =arr.length;
        int c=arr[0].length;
        
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                arr[i][j] +=arr[i][j-1];
            }
        }
    }
    public static int findSum(int arr[][], int l1, int r1, int l2,int r2){
        int sum =0;
        findPrefixSum2DMtrx(arr);
        for (int i = l1; i <= l2; i++) {
            //r1 to r2  sum for row i
            if (r1>=1) { 
                sum+=arr[i][r2] - arr[i][r1-1];
            }else{//whene r1==0
                sum+=arr[i][r2];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column");
        int r = sc.nextInt();
        int c = sc.nextInt();
        // Ques1:
        int arr[][] = new int[r][c];
        System.out.println("Enter " + r * c + " elements : ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("matrix is :  ");
        printarr(arr);
        /*
         * //Ques2:
         * System.out.println("TransPose of the matrix : ");
         * int traArr[][] = new int[r][c];
         * for (int i = 0; i < r; i++) {
         * for (int j = 0; j < c; j++) {
         * traArr[j][i] = arr[i][j];
         * }
         * }
         * //Ques3:
         * for (int i = 0; i < r; i++) {// for each row
         * reverseEachRow(traArr[i]);
         * }
         * printarr(traArr);
         * //Ques4;
         * System.out.println("Enter row size for pascal's array : ");
         * int rowSize = sc.nextInt();
         * int ans[][] = PascalsTriangle(rowSize);
         * printarr(ans);
         */

        /* // Ques5:
        System.out.println(" Spiral matrix ");
        printSpiralmatrix(arr);
        Ques6: 
        System.out.println("Enter number of row for spiral matrix : ");
        int n = sc.nextInt();
        printNumSpiralmtrx(n); */
        //Ques 7: 
        System.out.println("find prefixSum in 2D matrix with given l to r");
        int l1 =sc.nextInt();
        int r1=sc.nextInt();
        int l2 =sc.nextInt();
        int r2=sc.nextInt();
        
        System.out.println("sum of rectangle is  : "+findSum(arr, l1, r1, l2,r2));


    }
}
