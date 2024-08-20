package E_Stack;

public class Stack_03 {
    public static class ArrayStack {
        int arr[] = new int[9];
        int idx = 0;

        void push(int x) {
            if (isFull()) {
                System.out.println("Stack is full ");
                return;
            }
            arr[idx] = x;
            idx++;
        }

        void peek() {
            if (idx == 0) {
                System.out.println(" Stack is empty ");
                return;
            }
            System.out.println("Peek element of stack is : " + arr[idx - 1]);
        }

        void pop() {
            if (idx == 0) {
                System.out.println(" Stack is empty ");
                return;
            }
            int top = arr[idx - 1];
            arr[idx - 1] = 0;
            idx--;
            System.out.println("Pop element of stack is : " + top);

        }

        void display() {
            for (int i = 0; i <= idx - 1; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        int size() {
            return idx;
        }

        boolean isEmpty() {
            if (idx == 0) {
                return true;
            }
            return false;
        }

        boolean isFull() {
            if (idx >= arr.length) {
                return true;
            }
            return false;
        }

    }

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            // this.next=null;
        }
    }
    public static class LinkedListStack {
        Node head = null;
        // Node tail = null;
        int size = 0;

        void push(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = temp;
            } else {
                temp.next = head;
                head = temp;
            }
            size++;
            // temp=head;
        }

        void pop() {
            if (head==null) {
                System.out.println("Stack is empty");
                return;
            }
            int x=head.val;
            System.out.println("The Pop value is  : " +x);
            head = head.next;
            size--;
        }

        int peek() {
            return head.val;
        }
        void displayRec(Node head){
            if (head==null) {
                return;
            }
            displayRec(head.next);
            System.out.print(head.val+" ");
        }
        void display(){
            displayRec(head);
            System.out.println();
        }

        void displayRev() {
            Node temp = head;
            // System.out.println(temp);
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
            System.out.println("The size of stack is : "+size);
        }
        boolean isEmpty(){
            if (head==null) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ArrayStack st = new ArrayStack();
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(12);
        st.push(31);
       

        st.peek();
        st.pop();
        System.out.println("The size of stack is : " + st.size());

        System.out.println(st.isEmpty());
        System.out.println(st.isFull());
        st.push(44);
        st.push(55);
        st.push(44);
        st.push(66);
        st.push(16);
        st.display();

        // ! Implementaion of stack using LinkedList
        LinkedListStack lst = new LinkedListStack();
        System.out.println();
        System.out.println("<=======Implementaion of stack using LinkedList ============> ");
        lst.push(3);
        lst.push(4);
        lst.push(5);
        lst.push(6);
        lst.push(12);
        lst.push(31);
        lst.push(200);
        lst.push(100);
        lst.display();
        lst.pop();
        lst.display();
        System.out.println("The top of stack is : " + lst.peek());
        System.out.println(lst.isEmpty());

    }
}
