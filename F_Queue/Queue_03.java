package F_Queue;

import java.util.*;

class implemStackByQpush{
    Queue<Integer> q = new LinkedList<>();
     void push(int x) {
        q.add(x);
    }
     int pop() {
        if(q.size()==0){
            return -1;
        }
        for(int i =0 ; i<q.size()-1;i++){
            q.add(q.remove());
        }
        return q.remove();
    }
     int top() {//peek
        if(q.size()==0){
            return -1;
        }
        for(int i =0 ; i<q.size()-1;i++){
            q.add(q.remove());
        }
        int x =q.peek();
        q.add(q.remove());
        return x;
    }
     boolean empty() {
        if(q.size()==0){
            return true;
        }return false;
    }
    //space complexity : O(1)
    //Time complexity : push--> O(1)
    //peek()---> O(n)
    //pop()--->O(n)
    //? that means push efficient in which push ---> O(1) , pop --->O(n)
    void display(){
        System.out.println(q);
    }
}
class implemStackByQpop{
    Queue<Integer> q = new LinkedList<>();
    void push(int x){
        if (q.size()==0) {
            q.add(x);
        }else{
            q.add(x);
            for (int i = 0; i <=q.size()-1; i++) {
                q.add(q.remove());
            }
        }
    }
    int pop(){
        if (q.size()==0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = q.remove();
        return val;
    }
    int top(){
        if (q.size()==0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = q.peek();
        return val;
    }
    boolean isEmpty(){
        if(q.size()==0){
            return true;
        }return false;
    }
    //space complexity : O(1)
    //Time complexity : push--> O(n)
    //peek()---> O(1)
    //pop()--->O(1)
    //? that means push efficient in which push ---> O(n) , pop --->O(1)
    void display(){
        System.out.println(q);
    }
}

public class Queue_03 {
    public static void main(String[] args) {
        Queue<Integer> q =new LinkedList<>();
        //! Quse : Reverse the q element
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        System.out.println("Queue is : "+q);
        Stack<Integer> st = new Stack<>();
        // while (q.size()!=0) {         
        //     st.push(q.remove());
        // }
        // System.out.println("Stack is :" +st);
        // while (st.size()!=0) {
        //     q.add(st.pop());
        // }
        // System.out.println("Reverse q is : "+q);
  
        //! Quse : Reverses kth element from  queue
        int k=4;
        int size=q.size();
        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }
        while (st.size()!=0) {
            q.add(st.pop());
        }
        for (int i = 0; i <size-k ; i++) {
            int x =q.remove();
            q.add(x);
            //q.add(q.remove());
        }
        System.out.println(q);

        //! Ques : Implement stack using Queues
        //?Approch1  : Push Efficient
        System.out.println("<==========Implement stack using Queues(Push Efficient)==========>");
        implemStackByQpush isqpush =new implemStackByQpush();
        isqpush.push(2);
        isqpush.push(3);
        isqpush.display();
        System.out.println("Top element of stack is : "+isqpush.top());
        isqpush.push(4);
        isqpush.push(5);
        System.out.println("Top element of stack is : "+isqpush.top());
        isqpush.display();

        //?Approch2 : Pop Efficient
         System.out.println("<==========Implement stack using Queues(Pop Efficient)==========>");
        implemStackByQpop isqpop =new implemStackByQpop();
        isqpop.push(1);
        isqpop.push(2);
        isqpop.push(3);
        isqpop.display();
        System.out.println("Peek element of stack is : "+isqpop.top());
        System.out.println("pop Element from queue as stack : "+ isqpop.pop());
        isqpop.push(4);
        isqpop.push(5);
        System.out.println("Peek element of stack is : "+isqpop.top());
        System.out.println("pop Element from queue as stack : "+ isqpop.pop());
        System.out.println("Peek element of stack is : "+isqpop.top());
        isqpop.display();

    }
}
