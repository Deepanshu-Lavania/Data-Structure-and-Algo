package A_JAVA.Java2;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        // ! Ques 1: hollow sphere
        /*
         * for(int i=1;i<=r;i++){
         * for(int j=1;j<=c;j++){
         * if((i==1 || j<2 || i==r || j==c)){
         * System.out.print("*");
         * }else{
         * System.out.print(" ");
         * }
         * }
         * System.out.println();
         * }
         */

        // ! Ques 2: half triangle
        /*
         * for (int i = 1; i <= r; i++) {
         * for (int j = 1; j <= i; j++) {
         * System.out.print("*");
         * }
         * System.out.println();
         * }
         */
        //! Ques 3: reverse triangle
        // for (int i = 1; i <= r; i++) {
        // for (int j = 1; j<=r+1-i; j++) {

        // System.out.print("*");

        // }
        // System.out.println();
        // }

        //! Ques 4: Pyramid
      /*   for (int i = 1; i <= r; i++) {
            // for (int j = 1; j <= c; j++) {
            //     if (j < r + 1 - i) {
            //         System.out.print(" ");
            //     }else{
            //         System.out.print("*");
            //     }
            // }
            // for(int j=1;j<=i-1;j++){
            //     System.out.print("*");
            // }

                     //? OR

            // for(int j=1;j<r-i;j++){//for spaces 
            //     System.out.print(" ");
            // }
            // for(int j=1;j<=2*i-1;j++){
            //     System.out.print("*");
            // }
            // System.out.println();
        }
            */

        //! Ques 5: Numerical Reactangular pattern
       /*  for(int i=1;i<=r;i++){
            for(int j=i;j<=r;j++){
                System.out.print(j);
            }
            for(int j=1;j<=i-1;j++){
                System.out.print(j);
            }
            System.out.println();
        } */

        //! Ques 6: print 1221 pattern
        /*  for(int i=1;i<=r;i++){
            for(int j=1; j<=c ;j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("2");
                }
            }
            System.out.println();
         } */

        //! Ques 7: print number pyramid
      /*   for(int i=1;i<=r;i++){
            for(int j=1;j<r-i;j++){
               System.out.print(" ");
            }
           for(int j=1;j<=i;j++){
            System.out.print(j);
           }
           for(int j=i-1;j>=1;j--){
            System.out.print(j);
           }
            System.out.println();
        } */

        //! Ques 8: print hollow triangle with number
       /*  for(int i=1;i<=r;i++){
            for(int j=1;j<=r-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                if(j==1  || i==1 || i==r ||j==2*i-1){
                    System.out.print(i+" ");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        } */

        //! Ques 9: print Butterfly pattern
        for(int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<2*(r-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=r;i++){
            for(int j=1;j<=r-i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*(i-1);j++){
                System.out.print(" ");
            }
            for(int j=0;j<r-i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
