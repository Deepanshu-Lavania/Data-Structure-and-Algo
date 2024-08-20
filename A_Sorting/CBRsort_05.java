package A_Sorting;
import java.util.*;

public class CBRsort_05 {
    static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int findmax(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countSort(int arr[]) {
        // find max number
        int max = findmax(arr);

        int frqArr[] = new int[max + 1];
        // ? to find frequency for each element
        for (int i = 0; i < arr.length; i++) {
            frqArr[arr[i]]++;
        }
        // ?Stability is not maintain so we use another way
        // int k=0;//for original array
        // for (int i = 0; i < frqArr.length; i++) {
        // for (int j = 0; j < frqArr[i]; j++) {
        // arr[k++]=i;
        // }
        // }
        // printarr(arr);

        // ? find prefix sum
        for (int i = 1; i < frqArr.length; i++) {
            frqArr[i] = frqArr[i] + frqArr[i - 1];
        }
        // printarr(frqArr);
        // ?find the index of each element in the original array and put it in output
        // array
        int output[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = frqArr[arr[i]] - 1;
            output[idx] = arr[i];
            frqArr[arr[i]]--;
        }
        // copy all elements of frqArr to arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
        printarr(arr);
    }

    static void redixcountSort(int arr[], int place) {
        int freq[] = new int[10];
        // make frequency array
        for (int i = 0; i < arr.length; i++) {
            freq[(arr[i] / place) % 10]++;
        }
        // Make prefix sum array of count array
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }
    
        //find the index of each element in the original array and put it in output array
        int output[]= new int[arr.length];
        for (int i=arr.length-1;i>=0;i--) {
            int idx = freq[(arr[i]/place)%10]-1;
            output[idx] = arr[i];
            freq[(arr[i]/place)%10]--;
        }
        //copy all elements of output to arr
        for (int i = 0; i < output.length; i++) {
            arr[i]=output[i];
        }
        printarr(arr);

    }

    static void redixSort(int arr[]) {
        int max = findmax(arr);
        // apply counting sort to elements based on place value
        for (int place = 1; max / place > 0; place *= 10) {
            redixcountSort(arr, place);
        }
    }


    static void bucketSort(float arr[]){
        //Buckets 
        ArrayList<Float>[] buckets= new ArrayList[arr.length];
        //?create empty Buckets
        for (int i = 0; i < arr.length; i++) {
            buckets[i]=new ArrayList<Float>();
        }
        //?Add elements into our buckets
        
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (int) (arr[i]*arr.length);
            System.out.println("buketIndex : "+bucketIndex);
            buckets[bucketIndex].add(arr[i]);
        }
        //?Sort each bucket elements individaully
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);//each i consist array list 
        }
        for (int i = 0; i < buckets.length; i++) {
            System.out.println(i+" number bucket: "+buckets[i]);
        }
        //? Merge all buckets to get final sorted array
        int index= 0;
        for (int i = 0; i < buckets.length; i++) {
            ArrayList<Float> currBucket =buckets[i];
            for (int j = 0; j < currBucket.size(); j++) {
                arr[index++]=currBucket.get(j);
             
            }
        }
        //print array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
    public static void main(String[] args) {
        int arr[] = { 4, 3, 1, 5, 3, 1, 3, 5 };
        // ! Ques : Count Sort
        System.out.println("Count Sort : ");
        countSort(arr);
        System.out.println();
        System.out.println("Redix Sort : ");
        //? Time Complexity : O(n+k) where k is the range
        
        // ! Ques : Redix Sort :- it is similar to count sort
        int redArr[] = { 43, 453, 626, 894, 8, 3 };
        redixSort(redArr);
        //? Time Complexity : d(n+k) where k is 10 so d*n ===> O(d*n)
        
        // ! Ques : Bucket Sort 
        System.out.println();
        System.out.println("<================= Buckets array ================>");
        float bucArr[] = {0.3f,0.4f,0.3f,0.2f,0.1f,0.8f };
        bucketSort(bucArr);
        
    }
}
