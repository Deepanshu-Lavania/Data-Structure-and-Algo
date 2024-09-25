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

    public static void push_down_in_Minheap(List<Integer> heap, int index) {
        int n = heap.size() - 1;
        if (index == n) {
            return;
        }
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;
        int smallest = index;
        if (leftChild <= n && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild <= n && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }
        if (smallest == index) {
            return;
        }
        swap(heap, index, smallest);
        push_down_in_Minheap(heap, smallest);
    }

    public static void delete_in_Minheap(List<Integer> heap) {
        // swap last with root so that easily delete
        swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        // Heapify the tree array
        push_down_in_Minheap(heap, 0);
    }

    public static void push_down_in_Maxheap(List<Integer> heap, int index) {
        int n = heap.size() - 1;
        if (index == n) {
            return;
        }
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;
        int largest = index;
        if (leftChild <= n && heap.get(leftChild) > heap.get(largest)) {
            largest = leftChild;
        }
        if (rightChild <= n && heap.get(rightChild) > heap.get(largest)) {
            largest = rightChild;
        }
        if (largest == index) {
            return;
        }
        swap(heap, index, largest);
        push_down_in_Maxheap(heap, largest);
    }

    public static void delete_in_Maxheap(List<Integer> heap) {
        // swap last with root so that easily delete
        swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        // Heapify the tree array
        push_down_in_Maxheap(heap, 0);
    }
    /*
     * public static void delete_in_Maxheap(List<Integer> heap, List<Integer>
     * sortList) {
     * while (heap.size() > 0) {
     * int n = heap.size();
     * 
     * // Swap last element with the root so that we can delete the max (root)
     * element
     * swap(heap, 0, n - 1);
     * 
     * // Remove the max element (last element now)
     * int maxAtLast = heap.remove(n - 1);
     * 
     * // Add the removed max element to sortList
     * 
     * sortList.add(maxAtLast);
     * 
     * // Maintain the max-heap property after removing the root
     * if (heap.size() > 0) {
     * push_down_in_Maxheap(heap, 0);
     * }
     * }
     * 
     * }
     */

    public static void buildMinHeapify(List<Integer> heap, int lastNonleaf) {
        int n = heap.size() - 1; // last valid index
        int leftChild = (2 * lastNonleaf) + 1;
        int rightChild = (2 * lastNonleaf) + 2;
        int smallest = lastNonleaf;

        // Check if left child exists and is smaller than the current smallest
        if (leftChild <= n && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }

        // Check if right child exists and is smaller than the current smallest
        if (rightChild <= n && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }
        
        if (smallest==lastNonleaf) {
            return;
        }

        // If the smallest is not the parent, swap and recurse
        if (smallest != lastNonleaf) {
            swap(heap, lastNonleaf, smallest);
            buildMinHeapify(heap, smallest); // Recursive call to push down
        }
    }

    public static void heapify(List<Integer> heap) {
        int first_non_leaf = (heap.size() - 1) / 2; // last element's parent
        for (int i = first_non_leaf; i >= 0; i--) {
            //first iteration for right child of root
            //second iteration fro left child of root 
            //third iteration for root itself for build min heap using heapify
            buildMinHeapify(heap, i);
        }
    }

    public static void buildMaxHeap(List<Integer> heap, int parent_idx, int last_idx) {
        int n = last_idx;
        int leftChild = (2 * parent_idx) + 1;
        int rightChild = (2 * parent_idx) + 2;
        int largest = parent_idx;

        if (leftChild <= n && heap.get(leftChild) > heap.get(largest)) {
            largest = leftChild;
        }
        if (rightChild <= n && heap.get(rightChild) > heap.get(largest)) {
            largest = rightChild;
        }
        if (largest != parent_idx) {
            swap(heap, parent_idx, largest);
            // Recursively push down the larger element
            buildMaxHeap(heap, largest, last_idx);
        }
    }

    public static void heapifyMaxHeap(List<Integer> heap) {
        int first_non_leaf = (heap.size() - 1) / 2;
        for (int i = first_non_leaf; i >= 0; i--) {
            buildMaxHeap(heap, i, heap.size() - 1);
        }
    }

    public static void heapSort(List<Integer> arr) {
        // Convert to Max-Heap
        heapifyMaxHeap(arr);

        int n = arr.size() - 1;
        for (int i = n; i > 0; i--) {
            // Swap the root of the Max-Heap with the last element
            swap(arr, 0, i);
            // Rebuild the Max-Heap on the reduced array
            buildMaxHeap(arr, 0, i - 1);
        }
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
        // List<Integer> sortList = new ArrayList<>();
        delete_in_Maxheap(heap);
        /*
         * delete_in_Maxheap(heap, sortList);
         * System.out.println(sortList);
         */

        System.out.println(heap);
        System.out.println("<====using Heapify the maxHeap(turning a Max-Heap into a Min-Heap)=====>");
        heapify(heap);
        System.out.println(heap);
        /*
         * If each node took O(log n) to heapify, then the total complexity would indeed
         * be O(n log n). However, because most nodes take much less than O(log n) time
         * to heapify (since they are near the bottom of the tree), the overall
         * complexity reduces to O(n) because most nodes are at lower levels and require
         * much less work.
         */
        // ? Overall time complexity is O(n)
        System.out.println("<====Heap Sort after heapify=====>");
        heapSort(heap);
        System.out.println(heap);
    }
}
