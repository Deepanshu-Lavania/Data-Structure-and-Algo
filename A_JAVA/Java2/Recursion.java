package Java2;

import java.util.Scanner;

public class Recursion {
    public static boolean isPrime(int num){
        boolean flag_count =true;
        for(int i=2;i<num/2;i++){
            if(num%i==0){
                flag_count=false;
            }
        }
       return flag_count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       System.out.print("Enter number : ");
        int prime_num=sc.nextInt();
        boolean flag=true;
    
        for(int i=2;i<prime_num/2;i++){
            if(prime_num%i==0){
                flag=false;
            }
        }
        if(flag==true){
            System.out.println("Number is prime");
        }else{
            System.out.println("Number is not prime");
        }

        //! Recursion method
        System.out.print("This is by Recursion method : ");
        if(isPrime(prime_num)){
            System.out.println("Number is  prime");
        }else{
            System.out.println("Number is not prime");
        }
    }
}
