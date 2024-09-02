package Java1;

import java.util.Scanner;

public class Second {
    public static void main(String args[]){
        System.out.println("Hello Depanshu");
        for(int i=0;i<10;i++){
            System.out.println("I Love You");
        }
        byte i=127; 
        char a='@';

        System.out.println("byte : "+i +" char : "+ a);
        Scanner Sc = new Scanner(System.in);
        // System.out.println("Enter value");
        // String f=Sc.nextLine();
        // Sc.nextLine();
        // Float f2 = Sc.nextFloat();
        // System.out.println(f + " : "+f2);
        System.out.println((int)(Math.random()*34));
        int d=10;
        int e=12;
        if(d>5 & e>5){
          System.out.println(d +" : "+ e);
          System.out.println(Math.min(61, 8));
        }
        System.out.println("SWICH STATEMENT Start: ");
         int button = Sc.nextInt();
         switch (button) {
            case 1:
                System.out.println("button1");
                break;
         
            case 2:
                System.out.println("button2");
                break;
         
            case 3:
                System.out.println("button3");
                break;
         
            case 4:
                System.out.println("button4");
                break;
         
            default:
                break;
         }
    }
}
