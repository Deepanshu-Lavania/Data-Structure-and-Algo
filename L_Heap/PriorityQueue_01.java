package L_Heap;
import java.util.*;

public class PriorityQueue_01 {
    public static class Student {
        String name;
        String dob;
        int roolno;
        int marks;
    }
    //comparator<Type> : inbuilt class
    public static class StudentComparator implements Comparator<Student>{
        //overriding
        public int compare(Student s1, Student s2){
            if (s1.marks>s2.marks) {
                return 1;
            }else if (s1.marks<s2.marks) {
                return -1;
            }else{
                if (s1.roolno>s2.roolno) {
                    return 1;
                }else if (s1.roolno<s2.roolno) {
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());//? by default in ascending order

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(11);
        pq.add(15);
        pq.add(2);
        pq.add(50);
        System.out.println(pq);
        System.out.println("Before Remove ====> ");
        System.out.println("Peek Elem : "+pq.peek());
        System.out.println(pq);
        System.out.println("After Remove ====> ");
        pq.remove();
        System.out.println("Peek Elem : "+pq.peek());
        System.out.println(pq); 

        PriorityQueue<Student> studentpq = new PriorityQueue<>(new StudentComparator());//when we have sns string data to compare then we have to use comparator so that we compare the value of String 
        //it is compare throgh our own make logic

        Student harsh = new Student();
        harsh.name="harsh";
        harsh.dob="12-01-2004";
        harsh.marks=99;
        harsh.roolno=123;

        Student raghav = new Student();
        raghav.name="raghav";
        raghav.dob="22-01-2006";
        raghav.marks=89;
        raghav.roolno=223;

        studentpq.add(harsh);
        studentpq.add(raghav);

        System.out.println(studentpq.peek().name);
        System.out.println(studentpq.peek().roolno);
        System.out.println(studentpq.peek().dob);
    }
}
