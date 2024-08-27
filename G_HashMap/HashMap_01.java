package G_HashMap;

import java.util.*;

public class HashMap_01 {
    public static void maxRepEle(){
        int arr[] = {1,3,0,9,2,1,2,2,3,3,3,3,3,7,4,1,4};
        Map<Integer, Integer> amp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!amp.containsKey(arr[i])) {
                amp.put(arr[i],1);
            }else{
                amp.put(arr[i],amp.get(arr[i])+1);//get used to take value
            }
        } //----------->O(n)
        System.out.println(amp);

        int maxFreq= -1;
        int ansKey=-1;
        for(var e : amp.entrySet()){
            if (e.getValue()>maxFreq) {
                maxFreq=e.getValue();
                ansKey=e.getKey();
            }
        }//----------->O(n)
        System.out.printf(" %d has max frequency and it occurs %d times",ansKey,maxFreq);
    }
    public static void main(String[] args) {
        Map<String, Integer> mp = new HashMap<>();
        mp.put("Akash", 20000);
        mp.put("Prince", 23000);
        mp.put("Chand", 24000);
        System.out.println(mp);
        mp.putIfAbsent("Prince", 26000);
        System.out.println(mp);
        mp.put("Prince", 25000);
        System.out.println(mp);
        System.out.println(mp.get("Prince"));
        System.out.println(mp.get("Rahul"));
        System.out.println(mp.containsKey("Akash"));
        if (!mp.containsKey("Rahul")) {
            mp.put("Balindr", 30000);
        }
        System.out.println(mp);

        System.out.println();
        mp.put("Deepak", 21000);
        System.out.println(mp);
        System.out.println(mp.remove("Deepak")); // return value
        System.out.println(mp.remove("Chirag"));

        System.out.println();

        System.out.println(mp.keySet());// print all keys
        System.out.println(mp.values());// print all values
        System.out.println(mp.entrySet());// print both key & values

        System.out.println();
        for (String key : mp.keySet()) {
            System.out.printf("Salary of %s is %d\n", key, mp.get(key));
        }

        System.out.println();
        for (var e : mp.entrySet()) {
            System.out.printf("Salary of %s is %d\n", e.getKey(), e.getValue());
        }
        System.out.println(mp.get("Akash"));
    
        //! Ques : Given an array , find the most frequent element in it. If there are multiple elements that appear a maximum number of times, print any one of
        maxRepEle();
        //? Time complexity --> O(n)  
    }
}
