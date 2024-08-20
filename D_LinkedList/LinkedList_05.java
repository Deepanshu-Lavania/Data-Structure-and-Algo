package D_LinkedList;

public class LinkedList_05 {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void printNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static int size(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void sepOddEvenVal(Node head) {
        Node temp = head;
        Node l1 = new Node(0);
        Node l2 = new Node(-1);
        Node tempe = l1;
        Node tempo = l2;
        while (temp != null) {
            if (temp.val % 2 == 0) {
                Node a = new Node(temp.val);
                tempe.next = a;
                tempe = a;// now temp made l1
                temp = temp.next;
            } else {
                Node a = new Node(temp.val);
                tempo.next = a;
                tempo = a;
                temp = temp.next;
            }
        }
        l1 = l1.next;
        l2 = l2.next;
        System.out.print("Even number list1 is : ");
        printNode(l1.next);
        System.out.print("Odd number list2 is : ");
        printNode(l2.next);
        System.out.print("Connection of both list is : ");
        tempe.next = l2;
        printNode(l1);
    }

    public static void sepOddEvenValMem(Node head) {
        if (head == null)
            return;
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;

        Node current = head;

        while (current != null) {
            int element = current.val;

            if (element % 2 == 0) { // If the element is even
                if (evenStart == null) {
                    evenStart = current; // Initialize the start of the even list
                    evenEnd = evenStart; // Initialize the end of the even list
                } else {
                    evenEnd.next = current; // Append to the even list
                    evenEnd = evenEnd.next; // Update the end of the even list
                }
            } else { // If the element is odd
                if (oddStart == null) {
                    oddStart = current; // Initialize the start of the odd list
                    oddEnd = oddStart; // Initialize the end of the odd list
                } else {
                    oddEnd.next = current; // Append to the odd list
                    oddEnd = oddEnd.next; // Update the end of the odd list
                }
            }
            current = current.next; // Move to the next node
        }

        // If there are no even nodes, only odd list will be available
        if (evenStart == null) {
            head = oddStart;
        } else {
            head = evenStart;
            evenEnd.next = oddStart; // Link even list to odd list
        }

        // Set the last node of odd list to null if it exists
        if (oddEnd != null) {
            oddEnd.next = null;
        }

        // Print the two resulting lists
        System.out.println("print list :");
        printNode(evenStart);

    }

    public static void remAdjDuplicat(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next == null)
                return;
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        printNode(head);
    }

    public static void displayRev(Node head) {
        Node temp = head;
        if (temp == null) {
            return;
        }
        // head.next.next=head;
        displayRev(head.next);
        System.out.print(head.val + " ");
    }

    public static Node reverseAdd(Node head) {
        if (head.next == null) {
            return head;
        }
        Node newhead = reverseAdd(head.next);
        head.next.next = head;// interchanging connection : 2->4->null ====>head is 2 so 2-><---4 now, 4 point
                              // to 2 and 2 also point to 4
        head.next = null;
        return newhead;
        // 3->5->1->2->4->null : 3->5->1->2<-4 and 2->null
        // 3->5->1->2<-4 and 2->null : 3->5->1<-2<-4 and 1->null
        // 3->5->1<-2<-4 and 1->null : 3->5<-1<-2<-4 and 5->null
        // 3->5<-1<-2<-4 and 5->null : 3<-5<-1<-2<-4 and 3->null
    }

    public static void revlinkedlist(Node head) {
        Node prev = null;
        Node curr = head;
        Node agla = null;
        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        printNode(prev);
    }
   

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(5);

        Node d = new Node(9);
        Node e = new Node(11);
        Node f = new Node(11);
        Node g = new Node(15);

        Node i = new Node(1);
        Node j = new Node(1);
        Node k = new Node(4);
        Node l = new Node(1);
        Node m = new Node(1);
        Node n = new Node(1);

        Node x =new Node(1);
        Node y=new Node(3);
        Node z =new Node(2);
        Node p=new Node(4);
        Node q =new Node(6);
        Node r=new Node(8);

        a.next = b;
        b.next = c;
        c.next = d;

        d.next = e;
        e.next = f;
        f.next = g;
        g.next = i;
        i.next = j;
        j.next = k;
        k.next = l;
        l.next = m;
        m.next = n;

        x.next = y;
        y.next = z;
        z.next = p;
        p.next = q;
        q.next = r;
        printNode(a);

        

        // ! Ques : Given a linked list , split it into two lists such that one contains
        // odd values, while the other contains even values.

        System.out.println("<======Split list into even or odd  using extra space=====>");
        sepOddEvenVal(a);
        System.out.println("<======Split list into even or odd without using extra space=====>");
        sepOddEvenValMem(a);

        // ! Quse : Remove "adjacent duplicate element" from the list
        printNode(a);
        System.out.println("<======= Remove 'adjacent duplicate element' from the list=======>");
        remAdjDuplicat(a);

        // ! Quse :Reverse a linked list and return its new head
        // ? Hint: you can reverse val by two pointer approch with size but we have to
        // link the node with reference to prvious node

        System.out.println("<====display reverse value without interchange the links===>");
        displayRev(a);
        System.out.println();
        Node revList = reverseAdd(a);
        System.out.println("<====display reverse value with interchange the links ===>");
        printNode(revList);
        // ? Time complexity : O(n) and space complexity :O(n) because extra memory used
        // in call stack memory
        // ! Ques : can we reverse a linked list without recursion and Are two pointers enough?

        System.out.println("<======we reverse a linked list without recursion=====>");
        revlinkedlist(x);
        
        // isPalindrome(x);
        
    }
}
