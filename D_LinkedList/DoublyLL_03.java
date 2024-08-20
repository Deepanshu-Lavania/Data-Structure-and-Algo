package D_LinkedList;

public class DoublyLL_03 {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

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

    public static Node flatten(Node head) {
        if (head == null) return head;

        Node temp = head;
        while (temp != null) {
            if (temp.child != null) {
                Node t = temp.next;
                
                // Flatten the child list
                Node childHead = flatten(temp.child);
                
                // Connect temp with the child
                temp.next = childHead;
                childHead.prev = temp;
                
                // Find the tail of the flattened child list
                Node childListTail = childHead;
                while (childListTail.next != null) {
                    childListTail = childListTail.next;
                }
                
                // Connect the tail of the child list with the original next node
                childListTail.next = t;
                if (t != null) {
                    t.prev = childListTail;
                }
                
                // Unset the child pointer
                temp.child = null;//Imp point to remember becuase in doubly linkedlist there is no child connection so each node will be null for child
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        Node j = new Node(10);
        Node k = new Node(11);
        Node L = new Node(12);

        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        c.child = g;
        d.prev = c;
        d.next = e;
        e.prev = d;
        e.next = f;
        f.prev = e;
        f.next = null;

        g.next = h;
        h.prev = g;
        h.next = i;
        h.child = j;
        i.prev = h;
        i.next = null;

        j.next = k;
        k.prev = j;
        k.next = L;
        L.prev=k;
        L.next=null;

        System.out.println("Original List:");
        display(a);

        System.out.println("Flattened List:");
        Node flattenedHead = flatten(a);
        display(flattenedHead);
    }
}
