package A_JAVA.Java2;

import java.util.Scanner;

public class NumSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //! Ques 1 : Binary digit to decimal number
/*         int binary_num=sc.nextInt();
        int num=binary_num;
        int ans=0;
        int pw=1;//pwoer of 2 
        while(binary_num>0){
            int unit_digit= binary_num%10;
            ans =ans +(unit_digit*pw);
            binary_num = binary_num/10;
            pw = pw*2;
        }
        System.out.println("The decimal number of binary number " + num +" is : "+ ans); */
   
        //! Ques 2: decimal number to binary number 
        System.out.print("Enter decimal number : ");
        int deci_num = sc.nextInt();
        int n=deci_num;
        int ans =0 ;
        int pw=1;//power of 10
        while (deci_num>0) {
            int parity = deci_num%2;
            ans =(parity*pw) +ans;
            deci_num = deci_num/2;
            pw = pw*10; 
        }
        System.out.println("The binary number of decimal number " + n +" is : "+ ans);

    }
}