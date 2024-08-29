package H_HashSet;
import java.util.*;

public class HashSet_01 {
    public static void main(String[] args) {
        //!  HashSet : This is similar to the hashmap but it contains only one attribute either key or value
        //? Time Complexity of HashSet is Constant as similar to Hashmap except containsValue property
        //? Hashset maintains uniqueness 
        HashSet<String> st = new HashSet<>();
        st.add("James");
        st.add("Scott");
        System.out.println(st);
        st.add("James");
        System.out.println("maintains uniqueness : "+st);
        System.out.println(st.size());
        st.remove("James");
        System.out.println(st.contains("James"));
        System.out.println(st.size());
        st.add("Deepak");
        System.out.println(st);
        for (String s : st) {
            System.out.print(s+" ");
        }

    }
}
