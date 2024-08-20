package D_LinkedList;

public class LinkedList_01 {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        } 
    }

    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void recusiveDisplay(Node head) {
        if (head == null)
            return;
        System.out.print(head.data + " ");
        recusiveDisplay(head.next);
    }

    public static void recRevDisplay(Node head) {
        if (head == null)
            return;
        recRevDisplay(head.next);
        System.out.print(head.data + " ");
    }

    public static int lengthLinkeList(Node head) {
        // if (head == null) {
        //     return count;
        // }
        // count++;
        // return lengthLinkeList(head.next, count);
        int count =0;
        while (head!=null) {
            count++;
            head=head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        // ? head point to start node
        // ? tail point to last node

        // ?new means new node create
        Node a = new Node(5);// here Node is like as datatype
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);
        a.next = b;// 5->3 9 8 16
        b.next = c;// 5->3->9 8 16
        c.next = d;// 5->3->9->8 16
        d.next = e;// 5->3->9->8->16
        // ? node(e) point to null by default
        System.out.println(a);
        System.out.println(a.next);

        // System.out.println(a.data);
        System.out.println(a.data);

        // System.out.println(b.data);
        System.out.println(a.next.data);

        // System.out.println(c.data);
        System.out.println(a.next.next.data);

        // System.out.println(d.data);
        System.out.println(a.next.next.next.data);

        // System.out.println(e.data);
        System.out.println(a.next.next.next.next.data);

        // ! Print data through pointing new node
        Node temp = a; // It does n't mean that here it create new node , it means temp node point to
                       // node a which consist data/address of node a
        System.out.println(a);// * address */
        System.out.println(temp);

        System.out.println(a.data);// * Data */
        System.out.println(temp.data);

        // *when we know about length of linked list
        // for (int i = 0; i <5; i++) {
        // System.out.print(temp.data+" ");
        // temp = temp.next;
        // }

        // *when we don't know about length of linked list
        System.out.println("<========= Print data throgh While loop(don't know about length ) =================>");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
        System.out.println("<========= Print data through Function call =================>");
        display(a);

        System.out.println();
        System.out.println("<========= Print data through Recursion =================>");
        recusiveDisplay(a);

        System.out.println();
        System.out.println("<========= Print data through Recursion reversly=================>");
        recRevDisplay(a);

        System.out.println();
        System.out.println("<========= Print length of linked list =================>");
        System.out.println(lengthLinkeList(a));

    }

}
