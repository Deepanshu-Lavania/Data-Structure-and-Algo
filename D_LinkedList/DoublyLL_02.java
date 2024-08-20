package D_LinkedList;

public class DoublyLL_02 {
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

    public static void maxMinDisCriticalPoint(Node head, Node tail) {
        Node temp = head.next;
        Node Ttemp = tail.prev;
        Node c1 = temp;
        Node c2 = temp;
        Node c3 = temp;
        while (temp != null) {
            if (temp.val > temp.prev.val && temp.val > temp.next.val) {
                c1 = temp;
                break;
            } else if (temp.val < temp.prev.val && temp.val < temp.next.val) {
                c1 = temp;
                break;
            }
            temp = temp.next;
        }
        while (Ttemp != null) {
            if (Ttemp.val > Ttemp.prev.val && Ttemp.val > Ttemp.next.val) {
                c2 = Ttemp;
                break;
            } else if (Ttemp.val < Ttemp.prev.val && Ttemp.val < Ttemp.next.val) {
                c2 = Ttemp;
                break;
            }
            Ttemp = Ttemp.prev;
        }

        System.out.println(c1.val + " : " + c2.val);
        int count = 0;
        while (c1 != c2) {
            count++;
            c1 = c1.next;
        }
        System.out.println("max distance between critical point  is : " + count);
       
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(5);
        Node d = new Node(3);
        Node e = new Node(2);
        Node f = new Node(7);
        Node g = new Node(8);
        Node h = new Node(9);
        Node i = new Node(1);
        Node j = new Node(10);
        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;
        e.next = f;
        f.prev = e;
        f.next = g;
        g.prev = f;
        g.next = h;
        h.prev = g;
        h.next = i;
        i.prev = h;
        i.next = j;
        j.prev = i;
        j.next = null;

        //! Quse : Find max and min  distance between critical points in linked list
        display(a);
        maxMinDisCriticalPoint(a, j);
    }

}