package ArrayList;
import java.util.*;
public class ArrayList_01 {
    public static void main(String[] args) {
        //!why we use  ArrayList instead of array :
       /*   ArrayList is favored in many situations for its flexibility, built-in methods, and ease of use, making it suitable for dynamic data handling and integration with Java's Collections Framework. Arrays, however, might still be used for fixed-size data or when performance is critical. */
        ArrayList<Integer> li=new ArrayList<>();
        
        li.add(1);//add in last
        li.add(2);
        li.add(7);
        li.add(2, 100);
        li.set(3, 10);
        li.add(2);
        li.remove(1);//for removing element according to index
        li.remove(Integer.valueOf(2));//it can't remove the duplicate value when multiple value exist in array
        System.out.println(li.contains(Integer.valueOf(14)));
        // li.add("Deepnashu");//This give error because you already declare the datatype of array
        
        for (int i = 0; i < li.size(); i++) {
            System.out.print(li.get(i)+" ");
        }
        System.out.println();
        // or 
        System.out.println(li);


        //! Integer.valueof(element) takes an object not an value so you have to use Integer.valueOf , when the value is integer so u can covert it into object of integer
    }
}
