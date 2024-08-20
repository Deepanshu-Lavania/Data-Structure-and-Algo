package Recursion;

import java.util.Scanner;

public class Recursion_02 {
    static void printKmulN(int n , int k){
       
        if(k==1){
            System.out.print(n+" ");
            return;
        }
        printKmulN(n, k-1);//recursive work
        System.out.print(n*k +" ");   
    }
    static int printSumTerm(int n){
        if (n==0) {
            return n;
        }
        if(n%2==0){
            return printSumTerm(n-1)-n;
        }else{
            return printSumTerm(n-1)+n;
        }
    }
    public static void main(String[] args) {
        //! Ques : Print k multiples of num n
        System.out.println("Print k multiples of num n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number n : ");
        int n=sc.nextInt();
        System.out.println("Enter mulitle for k :");
        int k= sc.nextInt();
        printKmulN(n,k); 
        
        //! Ques : Print sum with alternate signs for number n
        System.out.println();
        System.out.println("Enter number of n :");
        int val = sc.nextInt();
        System.out.println(printSumTerm(val));
    }
}
