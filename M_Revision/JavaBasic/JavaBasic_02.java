
public class JavaBasic_02 {
    public static void main(String[] args) {
        System.out.println("Sout value of r & c : ");
        int r = 5;
        int c = 5;
        // ! Ques 1 :
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // ! Ques : 2
        System.out.println("Holow sphere : ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        // ! Ques :3
        System.out.println("right triangle from left side : ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i >= j) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println("right triangle from left side in number : ");
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i >= j) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
        // ! Ques ; 4
        System.out.println("Inverted right triangle upper to down: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("Inverted right triangle upper to down in number : ");
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        // ! Ques :5
        System.out.println("right triangle from right side : ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j >= c - i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //! Ques :6
        System.out.println("floyd's Triangle : ");
        int count = 1;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i >= j) {
                    System.out.print(count++);
                }
                System.out.print("  ");
            }
            System.out.println();
        }

        //! Ques : 7
        System.out.println("right traingle in form of 0/1");
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <=i; j++) {
                if((i+j)%2!=0){
                    System.out.print("0");
                }else{
                    System.out.print("1");
                }
            }
            System.out.println();
        }
        //! Ques :8 
        System.out.println("parallogram : ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j<c-i-1) {
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            for (int j = 0; j < c; j++) {
                if (j<=c-i-1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //! Ques : 9
        System.out.println("Pyramid of number : ");
        for (int i = 1; i <=r; i++) {
            for (int j = 1; j <= c; j++) {
                if (j<=c-i) {
                    System.out.print(" ");
                }else{
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
        //! Ques : 10
        System.out.println("pyramid with decreasing to increasing number after 1 : ");
        for (int i = 0; i < r; i++) {
            int val =5;
            for (int j = 0; j < c; j++) {
                if (j<c-i-1) {
                    System.out.print(" "+" ");
                }else{
                    System.out.print(val+" ");
                }
                val--;
            }
            val=2;
            for (int j = 0; j <=i-1; j++) {
                System.out.print(val++ +" ");
            }
            System.out.println();
        }

        //! Ques : 11 
        System.out.println("Butterfly Pattern : ");
        for (int i =1; i < r; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print("*");
            }
            int space = 2*(r-i);
            for (int j = 1; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=4; i >=1; i--) {
            for (int j = 1; j <=i; j++) {
                System.out.print("*");
            }
            int space = 2*(r-i);
            for (int j = 1; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // for (int i =1; i < r; i++) {
        //     for (int j = 1;j<=r-i; j++) {//to print reverse left right triangle
        //         System.out.print("*");
        //     }
        //     for (int j = 0; j<2*i-1; j++) {//to print spaces 
        //         System.out.print(" ");
        //     }
        //     for (int j =r; j>=i+1 ; j--) {//to print right right triangle
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        
    }
}
