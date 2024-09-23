package L_Heap;

import java.util.*;

public class Heap_01 {
    public static void swap(List<Integer> heap, int parent, int i) {
        // swapping
        // *we can't do like that because value will not be replce due to ArrayList
        /*
         * int temp=heap.get(parent);
         * heap.get(parent) =heap.get(i);
         * heap.get(i)=temp;
         */

        int temp = heap.get(parent);
        heap.set(parent, heap.get(i));
        heap.set(i, temp);
    }

    public static void push_up_in_minheap(List<Integer> heap, int i) {
        int parent = (i - 1) / 2;

        // until root reached or correct position reached
        if (i == 0 || heap.get(parent) < heap.get(i)) {
            return;
        }
        swap(heap, parent, i);
        push_up_in_minheap(heap, parent);
    }
    public static void insert_in_Minheap(List<Integer> heap, int ele) {
        heap.add(ele);// add in last

        int index = heap.size() - 1;
        push_up_in_minheap(heap, index);
    }
    
    public static void push_up_in_maxheap(List<Integer> heap, int i) {
        int parent = (i - 1) / 2;

        // until root reached or correct position reached
        if (i == 0 || heap.get(parent) > heap.get(i)) {
            return;
        }
        swap(heap, parent, i);
        push_up_in_maxheap(heap, parent);
    }
    public static void insert_in_Maxheap(List<Integer> heap, int ele) {
        heap.add(ele);// add in last

        int index = heap.size() - 1;
        push_up_in_maxheap(heap, index);
    }
    
    public static void push_down_in_Minheap(List<Integer> heap, int index){
        int n = heap.size()-1;
        if(index==n){
            return;
        }
        int leftChild = (2*index)+1;
        int rightChild=(2*index)+2;
        int smallest =index;
        if(leftChild<=n && heap.get(leftChild)<heap.get(smallest)){
            smallest = leftChild;
        }
        if(rightChild<=n && heap.get(rightChild)<heap.get(smallest)){
            smallest = rightChild;
        }
        if(smallest==index){
            return;
        }
        swap(heap, index, smallest);
        push_down_in_Minheap(heap,smallest);
    }
    public static void delete_in_Minheap(List<Integer> heap){
        //swap last with root so that easily delete
        swap(heap, 0, heap.size()-1);
        heap.remove(heap.size()-1);
        //Heapify the tree array
        push_down_in_Minheap(heap, 0);
    }
    
    public static void push_down_in_Maxheap(List<Integer> heap, int index){
        int n = heap.size()-1;
        if(index==n){
            return;
        }
        int leftChild = (2*index)+1;
        int rightChild=(2*index)+2;
        int largest =index;
        if(leftChild<=n && heap.get(leftChild)>heap.get(largest)){
            largest= leftChild;
        }
        if(rightChild<=n && heap.get(rightChild)>heap.get(largest)){
            largest = rightChild;
        }
        if(largest==index){
            return;
        }
        swap(heap, index, largest);
        push_down_in_Maxheap(heap,largest);
    }
    
    public static void delete_in_Maxheap(List<Integer> heap){
        //swap last with root so that easily delete
        swap(heap, 0, heap.size()-1);
        heap.remove(heap.size()-1);
        //Heapify the tree array
        push_down_in_Maxheap(heap, 0);
    }
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        // heap.add(10);
        // heap.add(20);
        // heap.add(30);
        // heap.add(40);
        // heap.add(50);
        // System.out.println(heap);
        // System.out.println("<=========Min Heap Insertion=========>");
        // insert_in_Minheap(heap, 5);
        // System.out.println(heap);
        // System.out.println("<=======Max Heap Insertion==========>");
        // insert_in_Maxheap(heap,100);
        // System.out.println(heap);

        // heap.add(5);
        // heap.add(20);
        // heap.add(10);
        // heap.add(40);
        // heap.add(50);
        // heap.add(30);
        // heap.add(60);
        // System.out.println(heap);
        // System.out.println("<=========Min Heap Deletion=========>");
        // delete_in_Minheap(heap);
        
        heap.add(100);
        heap.add(40);
        heap.add(50);
        heap.add(20);
        heap.add(30);
        heap.add(10);
        heap.add(15);
        System.out.println(heap);
        System.out.println("<=========Max Heap Deletion=========>");
        delete_in_Maxheap(heap);
        System.out.println(heap);
    }
}
