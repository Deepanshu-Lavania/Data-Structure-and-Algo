package ArrayList;

import java.util.*;

public class ArrayList_02 {
    static void Reverse(ArrayList<Integer> list) {
        int left = 0;
        for (int right = list.size() - 1; right > left; right--) {
            Integer temp = Integer.valueOf(list.get(right));
            list.set(right, list.get(left));
            list.set(left, temp);
            left++;
        }
        System.out.println(list);
    }
   
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        ArrayList<Integer> list = new ArrayList<>();
        l.add("Deepanshu");
        l.add(5);
        l.add(true);
        l.add(5);
        l.add(1);// add in last
        l.add(2);
        l.add(7);
        System.out.println(l);
        l.add(2, 100);
        l.set(3, 10);
        System.out.println("LastIndex of element is : " + l.lastIndexOf(5));

        System.out.println("The size of array is : " + l.size());
        System.out.println("Order of Elements of array are : ");
        System.out.println(l);
        System.out.println();
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + " ");
        }
        System.out.println();
        System.out.println("l.get(l.size()-1) : " + l.get(l.size() - 1));//give last value of arrayList

        list.add(5);
        list.add(1);// add in last
        list.add(2);
        list.add(5);
        list.add(1);// add in last
        list.add(2);
        list.add(7);
        list.add(2, 100);
        list.set(3, 10);
        System.out.println("ArrayList before reversing is  :" );
        System.out.println(list);
        System.out.println("Reverse arrayList is : ");
        Reverse(list);//function call

        //Inbuilt method for reverse 
        Collections.reverse(list);
        System.out.println("Reversed List is using Collections class : ");
        System.out.println(list);


        //Sort an arrayList 
        Collections.sort(list);
        System.out.println("Ascending Order : "+list );
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sorting in Descending Order : "+list);

        ArrayList<String> stringlist =new ArrayList<>();
        stringlist.add("Welcome");
        stringlist.add("To");
        stringlist.add("Adhyan");
        stringlist.add("Academy");

        Collections.sort(stringlist);
        System.out.println("Ascending Order for string is : "+ stringlist);
        Collections.sort(stringlist, Collections.reverseOrder());
        System.out.println("Sorting in Descending Order for string is : "+stringlist);
    }
}
