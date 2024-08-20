package D_LinkedList;

public class LinkedList_02 {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class Linkedlist {
        Node head = null;
        Node tail = null;

        void insertAtEnd(int val) {
            Node temp = new Node(val);// Node class/datatype and temp is a node
            if (head == null) {
                head = temp;
                // tail=temp;
            } else {
                tail.next = temp;
                // tail=temp;
            }
            tail = temp;// for shortcut
        }

        void insertAtbegin(int val) {
            Node temp = new Node(val);
            if (head != null) {
                temp.next = head;
                head = temp;// you can't write as temp = head;
            } else {
                head = temp;
                tail = temp;
            }
        }

        void insertAtIndex(int idx, int val) {
            Node newtemp = new Node(val);
            Node temp = head;

            // for insert at last and 0th position
            if (idx == size()) {
                insertAtEnd(val);
                return;
            } else if (idx == 0) {
                insertAtbegin(val);
                return;
            } else if (idx < 0 || idx > size()) {
                System.out.println("Wrong index");
                return;
            }
            // main logic for insert at index
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            newtemp.next = temp.next;
            temp.next = newtemp;
        }

        void display() {
            System.out.println();
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        int getAt(int idx) {
            Node temp = head;
            // int getvalue = 0;
            // for (int i = 0; i < idx; i++) {
            //     if (i == idx - 1) {
            //         getvalue = temp.data;
            //     }
            // }
            // return getvalue;
            if (idx < 0 || idx >= size()) {
                System.out.println("Index out of bounds");
                return -1; // or throw an exception
            }
          
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        int size() {
            Node temp = head;
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }
        void deleteAtindex(int idx){
            //for head if delete at begining
            if (idx==0) {
                head=head.next;
                return;
            }

            Node temp = head;
            for (int i = 0; i <idx; i++) {
                temp=temp.next;
            }
            temp.next=temp.next.next;

            //for tail if delete last element
            tail=temp;
        }
    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        // ! Implementation of Linked List without manually

        // ! InsertAtEnd method : T.C == O(1)
        ll.insertAtbegin(10);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.display();
        System.out.println();
        ll.insertAtEnd(12);
        ll.insertAtEnd(22);
        ll.display();
        // System.out.println(ll.size());

        // ! InsertAtEnd method : T.C == O(1)
        ll.insertAtbegin(3);
        ll.insertAtbegin(2);
        ll.display();
        // System.out.println(ll.size());

        // ! InsertAtIndex method : T.C == O(n)
        ll.insertAtIndex(2, 7);
        ll.display();
        // now this will be able to insert value at beigining and last position and you
        // can change it throgh print tail and last
        System.out.println();
        System.out.println(ll.tail.data);
        System.out.println(ll.head.data);

        ll.insertAtIndex(8, 9);
        ll.display();
        System.out.println();
        System.out.println(ll.tail.data);

        ll.insertAtIndex(0, 100);
        ll.display();
        System.out.println();
        System.out.println(ll.head.data);

        ll.insertAtIndex(15, 100);
        ll.insertAtIndex(-2, 0);

        System.out.println("your value is " + ll.getAt(3));

        //for deletion logic is : temp.next= temp.next.next
        ll.display();

        // ! deletionAtIndex method
        ll.deleteAtindex(3);
        ll.display();
    }
}
