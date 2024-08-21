package F_Queue;
 import java.util.*;
public class Queue_01 {
    public static void equeueSize(Queue<Integer> eq){
        if (eq.size()==0) {
            return ;
        }
        int x =eq.remove();
        equeueSize(eq);
        System.out.print(x+" ");
        eq.add(x);
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();

        System.out.println(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(6);
        q.add(4);
        q.add(5);
        System.out.println(q.size());
        System.out.println(q);
        //!front{Dequeuw(Deletion)} <------------- rear{Enqueue(Insersion)}
        q.remove(); //? folow FIFO/LILO Rule
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
        System.out.println(q.size());
        q.poll();
        System.out.println(q);

        //! Ques : Print all the elements present in queue only using queue operations using extra queue
        q.add(7);
        q.add(8);
        

        System.out.println(q);
        System.out.println(q.size());
        Queue<Integer> eq = new LinkedList<>();
        while (q.size()!=0) {
            int x=q.remove();
            eq.add(x);
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("new queue is : "+eq);

        //! Quse : print Revere queue 
        System.out.println("Print reverse Queue using recursion :");
        equeueSize(eq);
        System.out.println();
        System.out.println("eq is: "+eq);
        
        while(eq.size()>0){
            q.add(eq.poll());
        }
        System.out.print("q is : "+q);
    }
}
