package ArrayList;
import java.util.*;

public class Revision {
    public static void reverseList(ArrayList<Integer> list){
        int j=0;
        for (int i = list.size()-1; i>j;i--) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j,temp);
            j++;
      }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(5);
        list.add(1);// add in last
        list.add(2);
        list.add(5);
        list.add(1);// add in last
        list.add(2);
        list.add(7);
        list.add(2, 100);
        list.set(3, 10);
        System.out.println(list);
        reverseList(list);
        System.out.println(list);
    }
}
