package D_LinkedList;

public class LinkedList_04 {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void printNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
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

    public static int getIntersectionNode(Node head1, Node head2) {

        System.out.println(size(head1));
        System.out.print(size(head2));
        System.out.println();
        int increBigLength;
        if (size(head1) > size(head2)) {
            increBigLength = size(head1) - size(head2);
            Node temp = head1;
            for (int i = 1; i <= increBigLength; i++) {
                temp = temp.next;
            }
            while (temp.next != head2.next) {// if length is same
                temp = temp.next;
                head2 = head2.next;
            }
            return temp.next.data;
        } else {
            increBigLength = size(head2) - size(head1);
            Node temp = head2;
            for (int i = 1; i <= increBigLength; i++) {
                temp = temp.next;
            }
            while (temp.next != head1.next) {// if length is same
                temp = temp.next;
                head1 = head1.next;
            }
            return temp.next.data;
        }

    }

    public static void findMidOneTravers(Node head) {
        Node slow = head;
        Node fast = head;
        /*
         * while (fast != null && fast.next != null) {//even or odd case
         * slow = slow.next;
         * fast = fast.next.next;// fast=2*slow
         * }
         */
        /*
         * //for deletion this is for copying element but we have to delete whole node
         * so
         * slow.data=slow.next.data;
         * slow.next=slow.next.next;
         */
        // return slow.data;

        // ? now this will delete the whole node
        if (head.next == null) {
            return;
        }
        while (fast.next.next != null && fast.next.next.next != null) {
            // while ( fast.next.next.next!=null && fast.next.next!=null ) {//don't write
            // as;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
    }

    public static boolean findCyclePoint(Node head) {
        if (head == null)
            return false;
        if (head.next == null)
            return false;
        Node slow = head;
        Node fast = head;
        while (fast != null) {
            if (slow == null)
                return false;
            slow = slow.next;
            if (fast.next == null)
                return false;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static int findCycleIdx(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                break;
        }
        Node temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public static void mergeTwoList(Node list1, Node list2) {
        Node temp1 = list1;
        Node temp2 = list2;
        Node head = new Node(100);
        Node temp = head;
        // ! IMP:
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                Node a = new Node(temp1.data);
                temp.next = a;
                temp = a;
                temp1 = temp1.next;
            } else {
                Node a = new Node(temp2.data);
                temp.next = a;
                temp = a;
                temp2 = temp2.next;
            }
            if (temp1 == null) {
                temp.next = temp2;
            } else {
                temp.next = temp1;
            }
        }
        printNode(head.next);
    }

    public static void mergeTwoListMem(Node head1,Node head2){
        Node t1=head1;
        Node t2=head2;
        Node h = new Node(100);
        Node t = h;
        while (t1!=null && t2!=null) {
            if (t1.data<t2.data) {
                t.next=t1;
                t=t1;
                t1=t1.next;
            }else{
                t.next=t2;
                t=t2;
                t2=t2.next;
            }
        }
        if (t1==null) {
            t.next=t2;
        }else{
            t.next=t1;
        }
        printNode(h.next);
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(7);
        Node p = new Node(2);
        Node q = new Node(4);
        Node r = new Node(6);
        Node s = new Node(8);

        Node d = new Node(9);
        Node e = new Node(11);
        Node f = new Node(19);
        Node g = new Node(15);

        Node x = new Node(1);
        Node y = new Node(2);
        Node z = new Node(3);
        Node t = new Node(4);
        Node u = new Node(5);

        Node i = new Node(1);
        Node j = new Node(2);
        Node k = new Node(4);
        Node l = new Node(6);
        Node m = new Node(9);
        Node n = new Node(10);

        a.next = b;
        b.next = c;
        c.next = d;
        p.next = q;
        q.next = r;
        r.next = s;
        s.next = d;

        d.next = e;
        e.next = f;
        f.next = g;

        x.next = y;
        y.next = z;
        z.next = t;
        t.next = u;
        u.next = y;

        i.next = j;
        j.next = k;
        k.next = l;
        l.next = m;
        m.next = n;

        // ! Quse : find Intersection element of two list
        System.out.println("<============Intersection element of two list==============>");
        // Hint1 : Find length of both list
        // Hint2 : Find difference and then increment the bigger list by (m-n) steps;
        printNode(a);
        printNode(p);
        System.out.print(getIntersectionNode(a, p));
        System.out.println();

        // ! Ques : find middle element in one traversal and delete it
        System.out.println("<============Middle element in one traversal==============>");
        // System.out.println(findMidOneTravers(a));
        // System.out.println(findMidOneTravers(p));
        findMidOneTravers(a);
        findMidOneTravers(p);
        printNode(a);
        printNode(p);

        // ! Ques : find cycle presence
        System.out.println("<============ find cycle presence ==============>");
        if (findCyclePoint(x)) {
            System.out.println("Cycle is present");
        } else {
            System.out.println("Cycle is not present");
        }
        // ! Ques : find cycle start Element (it is based on rounds/cycle )
        // ? LeetCode : LL Cycle 2
        System.out.println("<============ find cycle start Element ==============>");
        System.out.println(findCycleIdx(x));

        //! Ques : merge two sorted linked list with using extra space

        System.out.print("list a is : ");
        printNode(a);
        System.out.print("list i is : ");
        printNode(i);
        System.out.println("<===========merge two sorted linked list with using extra space==============>");
        mergeTwoList(a, i);
 
        //! Ques : merge two sorted linked list without using extra space
        System.out.println("<===========merge two sorted linked list without using extra space==============>");
        mergeTwoListMem(a,i);

    }

}

// ! Binary Serach :- Bimary Search is not feasible to implementin a linked list
// ?Linar search , merge sort and insertion sort are feasible