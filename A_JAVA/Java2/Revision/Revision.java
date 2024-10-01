package A_JAVA.Java2.Revision;

import java.util.Scanner;

public class Revision {
    public static void main(String[] args) {
        //! Ques : convert binary to decimal number 
        // int binary_num = 101;
        // int n =binary_num;
        // int ans = 0;
        // int pow=1;
        // while (binary_num>0) {
        //     int unit_digit = binary_num%10;
        //     ans = ans +(unit_digit*pow);
        //     binary_num = binary_num/10;
        //     pow=pow*2;
        // }
        // System.out.println("Binary number "+n+" is "+ans+" in decimal number ");

        int deci_num  =11;
        int n=deci_num;
        int ans  =0;
        int pw  = 1; //power of 10
        while (deci_num>0) {
            int parity = deci_num%2;//fid rem
            ans  =ans+(parity*pw);
            pw*=10;
            deci_num/=2;
        }
        System.out.println("Decimal number "+n+" is "+ans+" in Binary number ");
    }
}
