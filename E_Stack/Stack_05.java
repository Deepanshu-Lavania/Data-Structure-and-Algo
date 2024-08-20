package E_Stack;

import java.util.*;

class Approch2Class {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    void push(int val) {
        if (st.size() == 0) {
            st.push(val);
            minStack.push(val);
        } else {
            st.push(val);
            if (minStack.peek() < val)
                minStack.push(minStack.peek());
            else
                minStack.push(val);
        }
    }

    // Method to pop an element
    void pop() {
        if (!st.isEmpty()) {
            st.pop();
            minStack.pop();
        }
    }

    // Method to peek the top element
    int top() {
        return st.peek();
    }

    int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }
    void displayStack(){
        System.out.print("Stack is : ");
        System.out.println(st);
        System.out.print("min Stack is : ");
        System.out.println(minStack);
    }
}

class Approch3Class{
    Stack<Long> st = new Stack<>();
    long min=0;
    void push(int val){
        long x= (long)val;
        if (st.size()==0) {
            st.push(x);
            min=val;
        }
        else if (x>=min) {
            st.push(x);
        }
        else{
            st.push(2*x-min);
            min=x;
        }
    }
    void pop(){
        if (st.size()==0) return;
        else if (st.peek()>=min) {
            st.pop();
        }
        // (st.peek()<min)
        else  {
            long old =2*min-st.peek();
            min = old;
            st.pop();
        }
    }
    public int top(){
        if(st.size()==0) return -1;
        long q =st.peek();
        if(st.peek()>-min) return (int)q;
        else return (int)min;
    }
    public int getMin(){
        if (st.size()==0) {
            return -1;
        }
        return (int)min;
    }
    void displayStack(){
        System.out.println(st);
    }
}

public class Stack_05 {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int nextSmalEle(int arr[]) {
        Stack<Integer> st = new Stack<>();
        // ? Next Smallest Elements for each in the array
        int nseArr[] = new int[arr.length];
        nseArr[arr.length - 1] = arr.length;// write last index+1 instead of -1
        st.push(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nseArr[i] = st.isEmpty() ? arr.length : (st.peek());// -1 but when we find next in histogram chart then it
                                                                // will not show so we use total_Length(index+1) hence
                                                                // write arr.length(index+1) i.e 6

            st.push(i);
        }
        printArr(nseArr);

        // ? To empty the stack
        while (!st.isEmpty())
            st.pop();
        System.out.println(st);

        // ? Previos Smallest Element for each in the array
        int pseArr[] = new int[arr.length];
        pseArr[0] = -1;
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pseArr[i] = st.isEmpty() ? -1 : (st.peek());
            st.push(i);
        }
        printArr(pseArr);

        // ? maximum area of rectangle
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            int area = arr[i] * (nseArr[i] - pseArr[i] - 1);// Area(rectangle) = length * breadth
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        // ! Ques : Given an array of integer heights representing the histogram's bar
        // height where the with of each bar is 1, return the area of the largest
        // rectangle in the histogram
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println("The maximal rectangle : " + nextSmalEle(arr));

        // ! Quse : find min stack means you have to finding min value form the stack if
        // vlaue is pop then you have to findout the min value of the stack but the
        // problem is min when you pop the element from the stack then it may be
        // possible that you don't get the value of stored minimum into the stack so we
        // have two approches

        // ? Approch 1 : for finding min value of the stack then used traverse operation  to findout the minimum value from the stack but its time complexity will be: minimum value find function i.e O(n) + to push element
        // into original stack i.e O(n) === overall T.C: O(n^2)
        //* Time complexity : O(n^2)  and S.C : O(n^2)*/

        // ? Approch 2 :By using extra space make getmin() function which help to store the min value of the stack for each value level
        Approch2Class twoStack = new Approch2Class();
        twoStack.push(7);
        twoStack.push(9);
        twoStack.push(3);
        twoStack.push(5);
        twoStack.push(1);
        twoStack.push(4);
        twoStack.displayStack();
        //*  Time Complexity :O(1) and S.C: O(n)


        // ? Approh 3 : Without using extra Stack space

        Approch3Class OneStack = new Approch3Class();
        OneStack.push(7);
        OneStack.push(9);
        OneStack.push(3);
        OneStack.push(5);
        OneStack.push(1);
        OneStack.push(4);
        
        OneStack.pop();
        OneStack.pop();
        OneStack.top();
        OneStack.displayStack();
        System.out.println(OneStack.top());
        OneStack.getMin();
        System.out.println(OneStack.getMin());
         //*  Time Complexity :O(1) and S.C : O(1)
    }
}
