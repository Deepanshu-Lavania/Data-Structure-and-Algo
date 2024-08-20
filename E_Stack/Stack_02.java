package E_Stack;

import java.util.*;

public class Stack_02 {
    // ! Pass by Reference : it means when we pass an argument for recursion then it changes in the similar stack i.e doesn't make copy
    // ! Pass by Value : it means when we pass an argument for recursion then it changes in the similar stack i.e it makes the copy.
    public static void displayRec(Stack<Integer> s) {// ! Stack is pass by reference beacuse changes done in similar stack st.
        if (s.size()==0  || s.isEmpty()) {
            return;
        }
        // System.out.print(s.size()+" ");
        int top = s.pop();
        displayRec(s);
        System.out.print(top + " ");
        s.push(top);

    }
    public static void pushRec(Stack<Integer> s,int idx, int val){
        if (s.isEmpty()) {
            return;
        }
        if (idx>s.size()) {
            return;
        }
        if (s.size()==idx) {
            s.push(val);
            return;
        }
        int top=s.pop();
        pushRec(s,idx,val);
        System.out.println(top+" ");
      
        s.push(top);
    }
    //?  Time & space  complexity in stack is O(n) for both when this using recursion due iteration & call stack (consume space ) 

    public static void removeEndBottom(Stack<Integer> st){
        Stack<Integer> rt = new Stack<>(); 
        while (st.size()>1) {
            rt.push(st.pop());
        }
        int popEle=st.pop();
        while (rt.size()>0) {
            st.push(rt.pop());
        }
        System.out.println(st);
        System.out.println("delete element is : "+popEle);
    }
    public static void removeIndexBottom(Stack<Integer> st, int idx){
        Stack<Integer> rt = new Stack<>(); 
        while (st.size()!=idx) {
            rt.push(st.pop());
        }
        int popEle=st.pop();
        while (rt.size()>0) {
            st.push(rt.pop());
        }
        System.out.println(st);
        System.out.println("delete element is : "+popEle);
    }
    public static void pushAtBottom(Stack<Integer> st,int x){
        System.out.println("value is"+x);
        if (st.size()==0) {
            st.push(x);
            return;
        }
        int top= st.pop();
        pushAtBottom(st, x);
        st.push(top);
        
    }
    public static void reverseStack(Stack<Integer> st){
        if (st.size()==1) {
            return;
        }
        int top = st.pop();
        // System.out.println(st);
        reverseStack(st);
        // System.out.println("top value is "+top);
        pushAtBottom(st , top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        // ! Insert Element at location
        // Stack<Integer> rt =new Stack<>();
        // int idx =2;
        // int x=7;
        // while (st.size()>idx) {
        // rt.push(st.pop());
        // }
        // System.out.println(st);
        // st.push(x);
        // System.out.println(st);
        // while (rt.size()>0) {
        // st.push(rt.pop());
        // }
        // System.out.println(st);

        // ! To print the element bottom to top
        // ?Approch 1:
        // while (st.size()>0) {
        // rt.push(st.pop());
        // }
        // while (rt.size()>0) {
        // int x=rt.pop();
        // System.out.print(x+" ");
        // st.push(x);
        // }
        // ?Approch 2: To print the stack element bottom to top by using array
        int n = st.size();
        int arr[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        System.out.println(st);
        System.out.print("put element into array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            st.push(arr[i]);
        }
        System.out.println();
        System.out.println(st);
        // ? Approch 3: To print the stack element bottom to top by using Recursion
        System.out.println("<======Using Recursion========>");
        displayRec(st);
        System.out.println();
        System.out.println(st);
        
        //! Push element from bottom
        System.out.println("<======Push at bottom Using Recursion========>");
        pushRec(st,4,34);

        System.out.println(st);
        System.out.println(st.peek());
        //! remove element from bottom at the end
        System.out.println("<======Remove element from the bottom end Using Recursion========>");
        removeEndBottom(st);
        System.out.println("<======Remove element from the bottom at any index Using Recursion========>");
        st.push(10);
        st.push(20);
        st.push(40);
        removeIndexBottom(st,7);

 
        //! Reverse Stack using Recursion
        System.out.println("<====== Reverse Stack using Recursion ========>");
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);



        //? Stack Overflow and Stack UnderFlowx
    }
}
