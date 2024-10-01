package A_JAVA.Java1;
import java.util.*;

public class Revision {
    public static void main(String[] args) {
       /*  System.out.println("Hello world");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int num = sc.nextInt();
        System.out.println("Enter the word ");
        String word = sc.next();
        System.out.println("Enter the line ");
        sc.nextLine();
        String name = sc.nextLine();  // Read the entire line of input
        System.out.println("You entered: " + name);
        System.out.println(num);
        System.out.println(word); */

        /* int number = new Scanner(System.in).nextInt();
        System.out.println(number); */

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a sentence:");
        String firstWord = sc.next();  // Reads the first word
        System.out.println("You entered the first word: " + firstWord);
        
        // If you want to read the rest of the line
        sc.nextLine();  // Clear the newline character
    }

}
