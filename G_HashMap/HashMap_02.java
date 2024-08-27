package G_HashMap;
import java.util.*;

public class HashMap_02 {
    static class MyHashMap<K, V> {
        public static final int DEFAULT_CAPACITY =4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value= value;
            }
        }

        private int n;//the number of entries in map
        private LinkedList<Node>[] buckets;//intialize bucket array

        private void initBuckets(int N){
            buckets = new LinkedList[N];//initialization is at above
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] =new LinkedList<>();//at each slot, intialize empty Linked list
            }
        }
        //To initialize the hash table
        public MyHashMap(){//constructor which execute first
            initBuckets(DEFAULT_CAPACITY);//fucntion becuase we have to call it again for new bucket array
        }

        //Traverse the ll and looks for a node with key, if found it returns it's index otherwise it return null
        private int searchInBucket(LinkedList<Node> ll,K key){
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key==key) {
                    return i;
                }
            }
            return -1;
        }
        //convert key into hash key 
        private int HashFunc(K key){
            int hc = key.hashCode();//it can be -ve and greater in length
            return (Math.abs(hc))%buckets.length;
        }

        public int size(){//return the number of entries in map
            return n;
        }
        
        private void rehash(){
            LinkedList<Node>[] oldBuckets= buckets;//copy hash table array into another 
            n=0;//reset the size to 0 because we'll re-insert all nodes
            initBuckets(2*oldBuckets.length);
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> bucket =oldBuckets[i];
                for (int j = 0; j < bucket.size(); j++) {
                    Node node= bucket.get(j);
                    put(node.key, node.value);
                }
            }

        }

        public int capacity(){
            return buckets.length;
        }
        public void put(K key, V value){
            int bi = HashFunc(key);//claculate slot index for Key like 3
            LinkedList<Node>  currBucket = buckets[bi];//bukets[bi] means to reached at particular slot in hash table and access Linked list at currBucket   1-->2-->4--->3-->5 (bucket list )
            int ei = searchInBucket(currBucket, key);
            if (ei== -1) {//key doesn't exist, we have to insert a new node
                Node node= new Node(key,value);
                currBucket.add(node);
                n++;//increase size
            }else{//update case
                Node currNode = currBucket.get(ei);
                currNode.value=value;
            }

            //?Rehashing : For Optimization only
            if (n>= buckets.length*DEFAULT_LOAD_FACTOR) {
                rehash();
            }
        }
        public V get(K key){
            int bi=HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if (ei!=-1) {
                Node currNode  = currBucket.get(ei);
                return currNode.value;
            }else{
                return null;
            }
        }
        public V remove(K key){
            int bi=HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket, key);
            if (ei!=-1) {
                Node currNode  = currBucket.get(ei);
                V val =currNode.value;

                //for remove 
                currBucket.remove(ei);
                n--;
                return val;
            }else{
                return null;
            }
        }

    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> mp = new MyHashMap<>();
        System.out.println("Testing put");
        mp.put("a", 1);
        mp.put("b", 2);
        mp.put("c",3);
        mp.put("d",4);
        System.out.println("Testing size "+mp.size());
        System.out.println(mp.get("c"));
        mp.put("c", 30);
        System.out.println(mp.get("c"));
        mp.remove("b");
        System.out.println("Testing size "+mp.size());
        System.out.println(mp.get("d"));
        mp.remove("d");
        System.out.println("Testing size "+mp.size());
        System.out.println(mp.remove("College"));

        //? NOTE : If you add more value in hashMap then it leads to increase time complextiy so we use Rehashing concept for constant Time Complexity (for Optimization)

        System.out.println("CAPACITY "+mp.capacity());
    }
}
