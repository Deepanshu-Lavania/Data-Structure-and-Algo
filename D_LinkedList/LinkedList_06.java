package D_LinkedList;

public class LinkedList_06 {
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

    public static Node reverse(Node head) {
        Node prev = null;
        Node agla = null;
        Node curr = head;

        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head) {
        // ? to find middle
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // ? to reverse list after mid point
        Node temp = reverse(slow.next);
        slow.next = temp;
        Node p1 = head;
        Node p2 = slow.next;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;

        }
        return true;
    }

    public static int maxTwinSum(Node head) {
        // ? to find middle
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // ? to reverse list after mid point
        Node p1 = head;
        Node p2 = slow.next;
        int max=0;
        int firstsum =  p1.val+p2.val;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2!=null && p1!=null) {  
                int sum = p1.val+p2.val;
                max=Integer.max(firstsum, sum);
                firstsum=sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
       

        Node x = new Node(1);
        Node y = new Node(13);
        Node z = new Node(13);
        Node p = new Node(6);
        Node q = new Node(7);
        Node r = new Node(2);

        

        x.next = y;
        y.next = z;
        z.next = p;
        p.next = q;
        q.next = r;
        printNode(x);

        // ! Quse : check whether the list is palindrome or not
        System.out.println("<======list is palindrome or not=======>");
        // ? Approch 1
        // You can solve this question by making an copy but time complexity will
        // increse due traversal three times
        // 1s for copy ,2s for reverse with links , and last 3rd for comparison of
        // original list with reverse list
        // ? Approch 2
        // find left middle + reverse remaining list with links + pointer p1 and p2
        // comparision
        System.out.println(isPalindrome(x));

        // ! Quse : Find the maximum twin sum of a linked list of "even length" . Twin
        // of any node at (i)th index in the node at (n-i-1)th index. "Twin sum" is the
        // sum of values of a node and its twin.
      
        System.out.println("<======the maximum twin sum is=======>");
        System.out.println(maxTwinSum(x));


    }
}
