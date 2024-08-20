package E_Stack;
import java.util.*;

public class Stack_01 {
    public static void main(String[] args) {
        Stack<Integer> st= new Stack<>();
        // System.out.println(st);
        // System.out.println(st.isEmpty());
        // System.out.println(st.size());
        // st.push(3);
        // st.push(4);
        // st.push(7);
        // st.push(10);
        // st.push(1);
        // System.out.println(st);
        // System.out.println(st.peek());
        // System.out.println(st.pop());
        // System.out.println(st.peek());
        // while (st.size()>1) {
        //     st.pop();
        // }
        // System.out.println(st.peek());
        // System.out.println(st);
        // System.out.println(st.isEmpty());
        //? problem in stack :To see the first entered element then u have to pop all the elements above it in the stack

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in stack : ");
        int size = sc.nextInt();
        System.out.println("Enter the elements  : ");
        for (int i = 0; i <size; i++) {
            st.push(sc.nextInt());
        }
        System.out.println(st);
        Stack<Integer> gt =new Stack<>();
        while (st.size()>0) {
            // int x=st.peek();
            // gt.push(x);
            // st.pop();
            
            gt.push(st.pop());
        }
        gt.push(5);
        System.out.println("gt stack is : "+gt);
        Stack<Integer> rt = new Stack<>();
        while (gt.size()>0) {
            rt.push(gt.pop());
        }
        System.out.println("rt stack is : "+rt);

    }
}
