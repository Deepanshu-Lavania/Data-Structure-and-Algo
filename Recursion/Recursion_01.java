package Recursion;

import java.util.Scanner;

public class Recursion_01 {
    static void printIncreasing(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        } else {
            // recursive work
            printIncreasing(n - 1);
            // self work
            System.out.println(n);
        }
    }

    static void printDecreasing(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        } else {
            // self work
            System.out.println(n);
            // recursive work
            printDecreasing(n - 1);
        }
    }

    static int printFactorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * printFactorial(n - 1);//Reccurence relation
        }
    }

    static int printFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return printFibonacci(n - 1) + printFibonacci(n - 2);//Reccurence relation
        }
    }

    static int printSumDigit(int n) {
        if (n >= 0 && n <= 9) {
            return n;
        } else {
            return printSumDigit(n / 10) + n % 10;//Reccurence relation
        }
    };
    static int printCountDigit(int n){
        if(n>=0 && n<=9){
            return 1;
        }else{
            return printCountDigit(n/10)+1;//Reccurence relation
        }
    }

    static int printpPOWq(int p , int q){
        // if(q==0){
        //     return 1;
        // }else{
        //     return printpPOWq(p, q-1)*p;//Reccurence relation
        // }
        //? or
        if(q==0){
            return 1;
        }
        int smallPow = printpPOWq(p,q/2);
        if(q%2==0){
           return smallPow*smallPow;//Reccurence relation
        }
        return p*smallPow*smallPow;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value for n : ");
        int n = sc.nextInt();
        //! Ques : Print vlaue for increasing order 
        System.out.println("Print value for Icreasing order : ");
        printIncreasing(n);
        //! Ques : Print vlaue for Decreasing order
        System.out.println("Print value for Decreasing order : ");
        printDecreasing(n);
        //! Ques : Print factorial for input n
        System.out.println("Print factorial : ");
        System.out.println(printFactorial(n));
        //! Ques : Print value at specific term and also print  Fibbonacci series 
        System.out.println("Print Fibbonacci series : ");
        for (int i = 0; i <= 6; i++) {
            System.out.print(printFibonacci(i) + " ");
        }
        System.out.println();
        System.out.println("Enter vlaue for finding sum of digit : ");
        int val = sc.nextInt();
        //! Quse : find the sum of digits 
        System.out.println("Print sum of digits : ");
        System.out.println(printSumDigit(val));
        //! Ques : Print number of digit
        System.out.println("Print count of digits : ");
        System.out.println(printCountDigit(val));

        //! Ques : find the power(p,q)
        System.out.println("Enter value for p and q : ");
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println("Print p ^ q  i.e., "+p+" ^ "+q+" : ");
        System.out.println(printpPOWq(p,q));
        //? NOTE: Recurrence relation is the relation between smaller and bigger problem (recursive call + self work)
    }
}
