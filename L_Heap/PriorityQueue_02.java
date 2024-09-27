package L_Heap;

import java.util.*;

public class PriorityQueue_02 {
    public static class Point {
        int x;
        int y;
        int distance;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = x * x + y * y;// calculate sqared distance from the origin
        }
    }

    public static class PointComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {//? compare of distace
            if (p1.distance < p2.distance)// Max-Heap: Larger distances should come first
                return 1;
            else if (p1.distance > p2.distance)
                return -1;
            else
                return 0;
        }
    }
    
    public static void kthclosestPoints(int x1[],int y1[]){
        PriorityQueue<Point> cordi = new PriorityQueue<>(new PointComparator());

        int kitem = 3; // Let's say we want the 3 closest points

        // Insert the first set of points into the heap
        for (int i = 0; i < x1.length; i++) {
            Point p = new Point(x1[i], y1[i]);
            System.out.println(p.x +"  "+ p.y +" : "+p.distance);
            cordi.offer(p);//add element into priorityQueue

            if (cordi.size() > kitem) {
                cordi.poll(); // Remove the point with the largest distance
            }
        }

        // Output the kitem closest points
        System.out.println("The " + kitem + " closest points to the origin are:");
        while (!cordi.isEmpty()) {
            Point p = cordi.poll();
            System.out.println("(" + p.x + ", " + p.y + ") with distance: " + p.distance);
        }

    }

    public static void returnLargestNum(int arry[],int kth){
        // Initialize PriorityQueue with elements from array
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        for (int i = 0; i < arry.length; i++) {// O(n log n) : O(n) for n elements and due to priorit o(logn)
            pque.add(arry[i]);
        }

        for (int i = 0; i < kth; i++) {//O(k*log n) :O(k) kth iteation and O(logn) for insertion & deletion 
            int f = pque.remove();
            int s =pque.remove();
            pque.add(f*s);
        }
        while (pque.size()!=1) {//O((n - 1) log n) : O(logn) for remove and O(n-1) for loop
            pque.remove();
        }
        System.out.println(pque);
        
    }//? Overall time complexity : O(nlogn) and Space Comple: O(1)

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();// don't change original array
        int k = 3;
        arr.add(2);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(5);
        arr.add(1);

        // ! Ques : Given an array integer nums and an integer k, return the kth largest
        // element in the array. Note that it is the kth largest element in the largest
        // element in the sorted order, not the kth distinct element.
        System.out.println("<====Find kth largest element==========>");
        // ? Brut Force method(Approch1)
        List<Integer> sortedArr = new ArrayList<>(arr);// SC : O(n)
        sortedArr.sort(Comparator.reverseOrder());// T.C : O(logn)
        System.out.println(sortedArr.get(2));// 0th based indexing and T.C:O(1)

        // ? Better/Optimized (Approch2)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.size(); i++) {
            // if top smallest, remove top and put largest
            if (pq.size() == k) {
                if (pq.peek() < arr.get(i)) {
                    pq.remove();
                    pq.add(arr.get(i));
                }
                continue;
            }
            // add ele
            pq.add(arr.get(i));
        }
        System.out.println(pq.peek());
        // ?Time complexity : O(nlogk), where n is the size of the array arr and k is
        // the size of the PriorityQueue and Space Complexity : O(k)

        // ! Ques : given a set of points in a XY plane . you need to find the kth closest points to the origin in which no 2 point distace is same from the origin
        // Points: (5,3), (1,2), (3,4), (5,6), (7,8), (9,10)
        System.out.println("<====== Find the kth closest points to the origin =====>");
        int x1[] = { 5, 1, 3, 5, 7, 9 };
        int y1[] = { 3, 2, 4, 6, 8, 10 };
        kthclosestPoints(x1,y1);

        //! Ques : remove two samllest element from array and multiply then add this result back into original array upto kth times and return largest element 

        System.out.println("<=====Return largest elem after multiply two smallest num=====>");
        int arry[]= {2,4,3,1,5};
        int kth =3;
        returnLargestNum(arry,kth);

    }
}
