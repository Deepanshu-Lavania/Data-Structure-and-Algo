package D_LinkedList;

public class LinkedList_03 {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class LinkedList {
        Node head = null;
        Node tail = null;

        void deleteGivenNode() {

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

    public static void deleteGivnNode(Node node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException(" 'Node to be deleted cannot be null or the last node'.");
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void deleteFromLast(Node head, int idx) {
        int m = size(head);
        int nthNode = m - idx + 1;
        Node temp = head;// temp =a means index 1
        for (int i = 1; i < nthNode - 1; i++) {
            temp = temp.next;// it run till index 4
            // means index 1 +4 =5
            // loop will run upto index 4 i.e data =13 so loop should start with 1 for delte
            // last index 2
        }
        System.out.println("temp is : " + temp.data);
        temp.next = temp.next.next;
    }

    public static Node FindNthNode(Node head, int idx) {
        Node slow = head;
        Node fast = head;
        for (int i = 1; i <= idx; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        // ?for traversal
        // while (fast!=null) {
        // slow=slow.next;
        // fast=fast.next;
        // }
        // return slow.data;
        // slow.data = slow.next.data;
        // slow.next=slow.next.next;
        // ?for deletion
        while (fast.next != null) {// ? remember it if fast --> null then fast.next can't point to null , it will
                                   // give error
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.deleteGivenNode();

        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(7);
        Node d = new Node(9);
        Node e = new Node(11);
        Node f = new Node(13);
        Node g = new Node(15);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        printNode(a);
        // ! Ques : Can we delete a node given the node itself as parameter, Is there
        // any efficient way, provided that the given node is not the last node ?
        // *Yes, you can delete a node in a singly linked list given only a reference to
        // that node, provided the node is not the last node in the list. The idea is to
        // copy the data from the next node into the current node, and then delete the
        // next node. This method is efficient as it "doesn't require traversal of the
        // list".

        // delete complete node by given node
        deleteGivnNode(c);
        // deleteGivnNode(e);
        printNode(a);
        System.out.println(size(a));

        // ! Quse :Finding Nth node from the end of Linked list and delete it
        // delete node at start is easy
        // delete node at end is calculated by the Ap formula
        // *nth form last = (m-n+1) ,where m=>size of LL , n=last node index
        deleteFromLast(a, 2);
        printNode(a);
        // ?time complexity : O(n)

        // ! IMP Ques :Finding Nth node from the end of Linked list "in One traversal"
        // using two pointer

        // ?time complexity : O(n) but in one traversal
        // FindNthNode(a,2); //it will give erro for deletio of first node
        a = FindNthNode(a, 5);// we change the head node so that first node will delete
        printNode(a);


    }
}
