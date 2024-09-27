package L_Heap;
import java.util.*;
public class PriorityQueue_03 {
    
    public static void insert(PriorityQueue<Integer> leftpq,PriorityQueue<Integer> rightpq ,int element){
        if (leftpq.isEmpty()) {
            leftpq.add(element);
            return;
        }
        //size can be equal of both or leftpq size can be greater by 1 than rightpq
        if (element<leftpq.peek()) {
            if (leftpq.size()==rightpq.size()) {
                leftpq.add(element);
            }else{
                rightpq.add(leftpq.remove());
                leftpq.add(element);
            }
        }else{
            if (leftpq.size()==rightpq.size()) {
                leftpq.add(rightpq.remove());
                rightpq.add(element);
            }else{
                rightpq.add(element);
            }
        }
    }

    public static double findmedian(PriorityQueue<Integer> leftpq,PriorityQueue<Integer> rightpq){
        if (leftpq.isEmpty()) {
            return -1;
        }
        else if (leftpq.size()>rightpq.size()) {
            return leftpq.peek();
        }else{
            return (double)(leftpq.peek()+rightpq.peek())/2;
        }
    }

    public static void main(String[] args) {
        //! Ques : Given a stream of integers , find the median of the stream
        PriorityQueue<Integer> leftpq =new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightpq =new PriorityQueue<>();
        insert(leftpq, rightpq, 15);
        System.out.println(findmedian(leftpq, rightpq));
        insert(leftpq, rightpq, 10);
        insert(leftpq, rightpq, 5);
        System.out.println(findmedian(leftpq, rightpq));
        insert(leftpq, rightpq, 20);
        System.out.println(findmedian(leftpq, rightpq));
        insert(leftpq, rightpq, 25);
        System.out.println(findmedian(leftpq, rightpq));
    }
}
