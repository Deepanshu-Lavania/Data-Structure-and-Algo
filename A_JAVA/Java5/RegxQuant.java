package A_JAVA.Java5;

import java.util.Scanner;
import java.util.regex.*;

public class RegxQuant {
    public static void main(String[] args) {
        boolean isMathed1 = Pattern.matches("[0-9]?", "68");
        // boolean isMathed1 = Pattern.matches("[0-9]?","9999");
        // boolean isMathed1 = Pattern.matches("[0-9]?","9");
        System.out.println(isMathed1);
        boolean isMathed2 = Pattern.matches("[0-9]+", "99999");
        System.out.println(isMathed2);
        boolean isMathed3 = Pattern.matches("[0-9]*", "");
        System.out.println(isMathed3);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter phone number : ");
        String mob = sc.nextLine();
        boolean isPhone = Pattern.matches("[6-9][0-9]{9,}", mob);
        System.out.println(isPhone);
        System.out.print("Enter email : ");
        String mail = sc.nextLine();
        boolean isEmail = Pattern.matches("[a-z][a-z0-9._]*[a-z0-9]+@[a-z]+[\\.][a-z]{2,3}", mail);
        System.out.println("Entered email is : " + isEmail);
    }
}
