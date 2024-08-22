package F_Queue;

// class ArrayQueue{
// }

public class Queue_02 {
    public static class ArrayQueue {
        int f = -1;
        int r = -1;
        int size = 0;
        int[] arr = new int[5];

        public void add(int val) {
            if (r == arr.length - 1) {
                System.out.println("Queue is full ");
                return;
            }
            if (f == -1) {
                f = r = 0;
                arr[f] = val;
            } else {
                arr[r + 1] = val;
                r++;
                // arr[++r] =val;
            }
            size++;
        }

        public int remove() {
            if (size == 0) {
                System.out.println("Queue is Empty so you can't remove");
                return -1;
            }
            f++;
            size--;
            return arr[f - 1];
        }

        public int peek() {
            if (size == 0) {
                System.out.println("Queue is Empty so you can't remove");
                return -1;
            }
            return arr[f];
        }

        public boolean isEmpty() {
            if (size == 0) {
                return true;
            } else
                return false;
        }

        public void display() {
            if (size == 0) {
                System.out.println("Queue is Empty");
            } else {
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

    }

    public static class Node{
        int val;
        Node next;

        Node(int val){//constructer
            this.val=val;
        }
    }
    
    public static class LinkedQueue {
        Node head = null;
        Node tail =null;
        int size =0;

        void add(int val){
            Node temp  = new Node(val);//used costructer 
            if (size==0) {
                head=temp;
                tail=temp;
            }else{
                tail.next =temp;
                tail=temp;
            }size++;
        }
        void remove(){
            if (size==0) {
                System.out.println("Queue is Empty");
            }else{
                head=head.next;
            }
        }
        int peek(){
            if (size==0) {
                System.out.println("Queue is Empty");
                return -1;
            }
            else{
                return head.val;
            }
        }
        boolean isEmpty(){
            if(size==0){
                return true;
            }else{
                return false;
            }
        }
        void display(){
            Node temp=head;
            while (temp!=null) {
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
        }
    
    }

    public static class CircularArrayQueue{
        int f=-1;
        int r=-1;
        int arr[] = new int[8];
        int size=0;
        
        public void add(int val) throws Exception{
            if(size==arr.length){
                throw new Exception("Queue is full");
            }

             else if (size==0) {
                f=r=0;
                arr[0]=val;
            }
            
            // if(r==f){ //? don't care about cross of rear and front due to size
            //     System.out.println("Queue is full");
            //     return;
            // }
            else if(r<arr.length-1){
                // arr[++r]=val;
                arr[r+1]=val;
                r++;
            }else if(r == arr.length-1){
                r=0;
                arr[0]=val;
            }
            size++;
        }
        public int remove() throws Exception{
            if(size==0){
                throw new Exception("Queue is Empty");
            }
            else{
                int x=arr[f];
                if(f==arr.length-1) f=0;
                else f++;
                size--;
                return x;
            }
        }
        public boolean isEmpty(){
            if (size==0) {
                System.out.println("Queue is Empty");
                return true;
            }else return false;
        }
        public  int peek(){
            if (size==0) {
                System.out.println("Queue is Empty");
                return -1;
            }else{
                int x=arr[f];
                return x;
            }
        }
        public void display(){
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }
            if(f<=r){
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i]+" ");
                }
            }
            else{
                for (int i = 0; i <=r; i++) {
                    System.out.print(arr[i]+" ");
                }
                for (int i = f; i < arr.length; i++) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }

    }

    public static class crNode{
        int val;
        crNode next;

        crNode(int val){
            this.val=val;
        }
    }
    public static class LinkedCircularQueue{

        crNode head =null;
        crNode tail=null;
        int size=0;
        void add(int val) {
            crNode temp = new crNode(val);
            if (size == 0) {
                head = temp;
                tail = temp;
                tail.next = head; // Circular linking
            } else {
                tail.next = temp;
                tail = temp;
                tail.next = head; // Maintain circular nature
            }
            size++;
        }
        void remove(){
            if (size==0) {
                System.out.println("Queue is Empty");
                return;
            } else if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            size--;
        }
        int peek(){
            if (size==0) {
                System.out.println("Queue is Empty");
                return -1;
            }
            else{
                return head.val;
            }
        }
        boolean isEmpty(){
            if(size==0){
                return true;
            }else{
                return false;
            }
        }
        void display(){
            crNode temp=head;
            while (temp.next!=head) {
                System.out.print(temp.val+" ");
                temp=temp.next;
            }
            System.out.print(temp.val);
        }
        
    }

    public static void main(String[] args) throws Exception{
        // ! Implementaion of Queue using Array
        ArrayQueue aq = new ArrayQueue();
        System.out.println("<=========== Implementaion of Queue using Array=============>");
        aq.add(1);
        aq.display();
        aq.add(2);
        aq.add(3);
        aq.add(4);
        aq.add(5);

        System.out.println("Delete element is : " + aq.remove());
        System.out.println("Peek element is : " + aq.peek());
        System.out.println(aq.isEmpty());
        aq.display();

        //! Implementation of Queue using LinkedList 
        LinkedQueue lq=new LinkedQueue();
        System.out.println("<===========Implementation of Queue using LinkedList===========>");
        System.out.println(lq.isEmpty());
        lq.remove();
        lq.add(1);
        lq.add(2);
        lq.add(3);
        System.out.println(lq.peek());
        lq.add(4);
        lq.remove();
        lq.remove();
        System.out.println(lq.isEmpty());
        lq.add(5);
        lq.add(6);
        lq.display();
        System.out.println();

        //! CIRCULAR QUEUE

        //? Implementation of CIRCULAR QUEUE using array
        CircularArrayQueue caq=new CircularArrayQueue();
        System.out.println("<===========Implementation of CIRCULAR Queue using Array===========>");
        caq.add(10);
        caq.add(11);
        caq.add(12);
        caq.add(13);
        caq.add(14);
        caq.add(15);
        caq.add(16);
        caq.add(17);
        caq.remove();
        caq.remove();
        caq.remove();
        caq.isEmpty();
        caq.peek();
        caq.display();

        caq.add(18);
        caq.add(19);
        caq.add(20);
        caq.display();

System.out.println();
        //? Implementation of CIRCULAR QUEUE using LinkedList
        LinkedCircularQueue clq=new LinkedCircularQueue();
        System.out.println("<===========Implementation of Circular Queue using LinkedList===========>");
        System.out.println(clq.isEmpty());
        clq.remove();
        clq.add(100);
        clq.add(102);
        clq.add(103);
        System.out.println(clq.peek());
        clq.add(104);
        clq.remove();
        clq.remove();
        System.out.println(clq.isEmpty());
        clq.add(105);
        clq.add(106);
        clq.add(107);
        clq.add(108);
        clq.display();
        System.out.println();
    }
}
