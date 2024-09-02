package A_JAVA.Java2;

import java.util.Scanner;

public class NumOfQues {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        //! Ques 1 : Count the number of digits
       /*  System.out.print("Enter your number : ");
        long num = Sc.nextInt();
        int n = 0;
        System.out.println("your entered number  is : " + num);
        while (true) {
            num = num / 10;
            if (num != 0) {
                n++;
            } else {
                System.out.println("your entered number digit is : " + (n + 1));
                break;
            }
        } */

        // //! Ques 2 : Add the number of entered digits
/*         int sum = 0;
        System.out.print("Enter digit for sum of them : ");
        int number = Sc.nextInt();
        while (number > 0) {
            int origNum = number;
            number = number / 10;
            int r = origNum % 10;
            sum = sum + r;
        }
        System.out.println("the value of entered number is: " + sum); */

        // //! Ques 3 : Reverse the entered digit
       /*  System.out.print("Enter digit for reverse : ");
        int numbr = Sc.nextInt();
        int orNum = 0;
        while (numbr > 0) {
            int rem = numbr % 10;
            numbr = numbr / 10;
            orNum = orNum * 10 + rem;
        }
        System.out.println("your entered reverse number is : " + orNum); */

        //! Ques 4 : Find the sum of series like S= 1-2+3-4 ... n
        /* int ans = 0;
        System.out.print("Enter number for series : ");
        int numS = Sc.nextInt();
        int num=1;
        while(numS>=num){
            if(num%2==0){
                ans= ans-num;
            }else{
                ans = ans +num;
            }
            num++;
        }
        System.out.println("The sum of your series upto entered number is : "+ans); */

        //! Ques 5 : Find the factorial of a number
       /*  int fact=1;
        System.out.print("Enter number to find factorial : ");
        int factorial = Sc.nextInt();
        while(factorial!=0){
            fact = fact*(factorial);
            factorial--;
        }
        System.out.println("The factorial of your entered number is : "+fact); */

        //! Ques 6 : Find a raise to the power of b

       /*  int power =1;
        System.out.print("Enter number : ");
        int number = Sc.nextInt();
        System.out.print("Enter power number : ");
        int p = Sc.nextInt();
        int i=1;
       while (i<=p) {
          power = power * number;
          p--;
       }
       System.out.println(number +" raise to the power of " + i + " is : " + power);
        */

    }
}
