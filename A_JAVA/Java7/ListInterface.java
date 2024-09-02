package A_JAVA.Java7;

import java.util.*;

public class ListInterface {
    public static void ArrayListExample() {
        ArrayList<Integer> arrl = new ArrayList<>();
        // LinkedList<Integer> arrl = new LinkedList<>();
        arrl.add(1);
        arrl.add(3);
        arrl.add(5);
        System.out.println(arrl.get(2));
        System.out.println(arrl.contains(3));
        arrl.set(1, 30);
        System.out.println(arrl.get(1));

        
        // Find out the type of arrl
        System.out.println("The type of arrl is: " + arrl.getClass().getName());

        // Checking the type using instanceof
        if (arrl instanceof ArrayList) {
            System.out.println("arrl is an instance of List");
        } else if (arrl instanceof List) {
            System.out.println("arrl is an instance of ArrayList");
        } else {
            System.out.println("arrl is an instance of " + arrl.getClass().getName());
        }
       
    }

    public static void main(String[] args) {
        ArrayListExample();
    }
}
