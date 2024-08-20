package D_LinkedList;

public class DoublyLL_01 {
    public static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void displayTail(Node tail) {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
        System.out.println();
        // ? it is efficient reverse as compare to singly linked list recursion to print
        // reverse because of call stack memory
    }

    public static void displayRecTail(Node tail) {
        Node temp = tail;
        if (temp == null) {
            return;
        }
        displayRecTail(temp.prev);
        System.out.print(temp.val + " ");
    }

    public static void display2(Node random) {
        // displayRecTail(random);

        // Node temp2=random.next;
        // while (temp2!=null) {
        // System.out.print(temp2.val+" ");
        // temp2=temp2.next;
        // }
        Node temp = random;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static void checkSumTarget(Node head, Node tail, int target) {
        Node h = head;
        Node t = tail;
        System.out.println(h.val);
        System.out.println(t.val);
        while (h.val < t.val) {// list is sorted in incresing order
            if (h.val + t.val == target) {
                System.out.println(h.val + " + " + t.val + " == " + target);
                break;
            } else if (h.val + t.val < target) {
                h = h.next;
            } else {
                t = t.prev;
            }

        }

    }

    // ! Make doubly Linked List according to data structure
    public static class DLinkedList {
        Node head = null;
        Node tail = null;

        // public static void insertAtbegin(int val){ //?Cannot make a static reference
        // to the non-static field head
        void insertAtbegin(int val) {
            Node temp = new Node(val);
            if (head != null) {
                head.prev = temp;
                temp.next = head;
                head = temp;
            } else {
                head = temp;
                tail = temp;
            }
        }

        void insertAtEnd(int val) {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node newNode = new Node(val);
            if (temp.next == null) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        void insertAtIndex(int idx, int val) {
            Node temp = head;
            for (int i = 1; i <= idx - 1; i++) {
                temp = temp.next;
            }

            Node newNode = new Node(val);

            temp.next.prev = newNode;
            newNode.next = temp.next;

            temp.next = newNode;
            newNode.prev = temp;
        }

        void deleteAtIndex(int idx) {
            Node temp = head;
            for (int i = 1; i <= idx - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.next.prev = temp;
        }

        boolean isPalindrom() {
            Node h = head;
            Node t = tail;
            while (h != t) {
                if (h.val != t.val) {
                    return false;
                } else {
                    h = h.next;
                    t = t.prev;
                }
            }
            return true;
        }

        void display() {
            System.out.println();
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(8);
        Node d = new Node(13);
        Node e = new Node(100);

        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;
        e.next = null;

        display(a);
        displayTail(e);
        displayRecTail(e);
        System.out.println();
        System.out.println("<=====Display value if random node is given =====>");
        display2(c);

        DLinkedList dll = new DLinkedList();
        // ! Make Doubly linked list through adding data
        System.out.println("<=======Insertion at begining in DoublyLinkedList======>");
        dll.insertAtbegin(0);
        dll.insertAtbegin(1);
        dll.insertAtbegin(2);
        dll.insertAtbegin(3);
        dll.insertAtbegin(4);
        dll.insertAtbegin(5);
        dll.insertAtbegin(6);
        dll.display();
        System.out.println("<=======Insertion at End in DoublyLinkedList======>");
        dll.insertAtEnd(1);
        dll.display();
        System.out.println("<=======Insertion at Index in DoublyLinkedList======>");
        dll.insertAtIndex(3, 40);
        dll.insertAtIndex(3, 39);
        dll.display();
        System.out.println("<=======Deletion at Index in DoublyLinkedList======>");
        dll.deleteAtIndex(3);
        dll.deleteAtIndex(4);
        dll.display();

        System.out.println("<========Check DLL is palindrome or not=========>");
        System.out.println(dll.isPalindrom());
        // ! Ques : Sorted list in non-decreasing order, check two sum is equal to
        // target
        System.out.println("<=======check two sum is equal to target=========>");
        display(a);
        checkSumTarget(a, e, 13);

        // ! Note : can we create a doubly linked list using one pointer with every node
        // ? => yes possible, By storing XOR of addresses of previous and next nodes
    }
}
