package Recursion;

import java.util.Scanner;

import javax.lang.model.util.Elements.Origin;

public class Recursion_03 {
    static int igcd(int n, int m) {
        while (n % m != 0) {
            int rem = n % m;
            n = m;
            m = rem;
        }
        return m;
    }

    static int printGCD(int x, int y){
        if(y==0){
            return x;
        }else{
            return printGCD(y, x%y);
        }
    }



    static void printArmstrong(int n){
        int originalNumber =n;
        int numberofDigits = String.valueOf(n).length();
        int sum=0;
        while (n!=0) {
            int digit = n%10;
            sum=sum+(int)Math.pow(digit,numberofDigits);
            n=n/10;
        }
        if(sum==originalNumber){
            System.out.println("Number is Armstrong");
        }else{
            System.out.println("Number is not Armstrong ");
        }
    }
    


    static int countDigit(int n){
        if(n==0){
            return 0;
        }else{
            return countDigit(n/10)+1;
        }
    }
    static int power(int digit, int numberofDigit){
        if(numberofDigit==1){
            return digit;
        }else{
            return power(digit, numberofDigit-1)*digit;
        }
    }
    static int sumofDigits(int n,int numberofDigit){
        if(n==0){
            return 0;
        }else{
            int digit = n%10;
            return power(digit,numberofDigit)+sumofDigits(n/10,numberofDigit);
        }
    }
    static boolean printArmsRec(int n){
        int numberofDigit =countDigit(n);
        return n==sumofDigits(n,numberofDigit);
    }
    public static void main(String[] args) {
        // ! Ques : find GCD for (x,y)
        System.out.println("Enter value for n & m : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // ? Brut force approch
        // int minNum = Integer.min(n, m);
        // for (int i = minNum; i > 0; i--) {
        // if (n % i == 0 && m % i == 0) {
        // System.out.println("GCD of (" + n + " , " + m + ") is " + i);
        // return;
        // }
        // }

        System.out.println("output is : ");
        // System.out.println(igcd(n,m));p
        // ? Through Recursion
        System.out.println(printGCD(n,m));


        //! Ques : Check Armstrong number 
        System.out.println("Enter number to check whether it is Armstrong number or not : ");
        int num=sc.nextInt();
        printArmstrong(num);

         //! Ques : Check Armstrong number using recursion 
         if(printArmsRec(num)){
            System.out.println("Number is Armstrong using recursion ");
         }else{
            System.out.println("Number is not Armstrong using recursion");
         }

    }
}
