package F_Queue;

// class ArrayQueue{
// }
public class Queue_02 {
    public static class ArrayQueue{
        int f=-1;
        int r=-1;
        int size=0;
        int[] arr= new int[5];
        public void add(int val){
            if (r==arr.length-1) {
                System.out.println("Queue is full ");
                return;
            }
            if (f==-1) {
                f=r=0;
                arr[f]=val;
            }else{
                arr[r+1] =val;
                r++;
                //arr[++r] =val;
            }
            size++;
        }

        public int remove(){
            if (size==0) {
                System.out.println("Queue is Empty so you can't remove");
                return -1;
            }
            f++;
            size--;
            return arr[f-1];
        }
        public int peek(){
            if (size==0) {
                System.out.println("Queue is Empty so you can't remove");
                return -1;
            }
            return arr[f];
        }
        public boolean isEmpty(){
            if (size==0) {
                return true;
            }else return false;
        }
        public void display(){
            if (size==0) {
                System.out.println("Queue is Empty");
            }else{
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        //! Implementaion of Queue using Array
        ArrayQueue aq=new ArrayQueue();
       aq.add(1);
       aq.display();
        aq.add(2);
        aq.add(3);
        aq.add(4);
        aq.add(5);
       
        System.out.println("Delete element is : "+ aq.remove());
        System.out.println("Peek element is : "+aq.peek());
        System.out.println(aq.isEmpty());
        aq.display();

        
    }
}
