package D_LinkedList;

public class LinkedList_07 {
    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next=null;
            this.random=null;
        }
    }

    public static void printNode(Node head) {
        Node temp = head;
        // Node temp2=head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            // System.out.println(temp.next);
           
            // System.out.print(temp2.random + " ");
            temp = temp.next;
            // temp2=temp2.next;
        }
        System.out.println();
    }

    public static void deepCopyRandomList(Node head){
        Node temp1=head;
        //? to make deep copy without pointing random pointer
        Node head2=new Node(0);//create new node for copying whole list
        Node temp2=head2;//temp2 point to node head2 which contain 0 value
        while (temp1!=null) {
            Node t=new Node(temp1.val);//create new node to store temp1 node value
            temp2.next=t;
            temp2=t;
            temp1=temp1.next;
        }
        head2=head2.next;
        temp2=head2;
       temp1=head;//now they reached to its previous locations
        //? make alternate connection
        Node temp = new Node(-1);
        while (temp1!=null) {
            temp.next=temp1;
            temp1=temp1.next;
            temp=temp.next;

            temp.next=temp2;
            temp2=temp2.next;
            temp=temp.next;
        }
        temp2=head2;
        temp1=head;//now they reached to its previous locations
        //? Assining random pointer
        while (temp1!=null && temp2!=null) {
            if (temp1.random==null) {
                temp2.random=null;
            }else{
                temp2.random=temp1.random.next;
            }
            temp1=temp2.next;
            if(temp1!=null){
                temp2=temp1.next;
            }
        }
        temp2=head2;
        temp1=head;//now they reached to its previous locations

        //?seperating the lists
        while (temp1!=null) {
            temp1.next=temp2.next;
            temp1=temp1.next;
            if (temp1==null) {
                break;
            }
            temp2.next=temp1.next;
            if (temp2.next==null) break;
            temp2=temp2.next;
        }
        printNode(head2);


    }
    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);

        // point next
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        // point random
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;
        printNode(a);
        //! Ques  : Copy list with random pointer . Construct a deep copy of a linked list where each node contains an additional random pointer , which could point to any node in the list or null. 

        deepCopyRandomList(a);
    }
}
