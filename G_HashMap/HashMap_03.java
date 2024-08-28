package G_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMap_03 {
    public static boolean areMapsEqual(HashMap<Character, Integer> mp1, HashMap<Character, Integer> mp2) {
        // Step 1: Check if sizes are equal
        if (mp1.size() != mp2.size()) {
            return false;
        }
        //? Convert the keySet to a list
        List<Character> keys = new ArrayList<>(mp1.keySet());
        System.out.println(keys);
        // Step 2: Use a normal for loop with an index to iterate over the keys
        for (int i = 0; i < keys.size(); i++) {//? forloop apply in array list, not in HashMap
            Character key = keys.get(i);
         
            if (!mp2.containsKey(key)) {
                return false;  // Key not present in both maps
            }
            if (!mp1.get(key).equals(mp2.get(key))) {
                return false;  // Values do not match
            }
        }//? O(n)

        return true; // All keys and values match
    }
    public static HashMap<Character,Integer> freqString(String s){
        HashMap<Character , Integer> mp= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch= s.charAt(i);
            if (!mp.containsKey(ch)) {
                mp.put(ch,1);
            }else{
                mp.put(ch,mp.get(ch)+1);
            }
        }
        return mp;
    }
    public static boolean isAnagram(String s, String t){
        if (s.length()!=t.length()) {
            return false;
        }
        HashMap<Character , Integer> mp1= freqString(s);  
        HashMap<Character , Integer> mp2= freqString(t);
        System.out.println(mp1.entrySet());
        System.out.println(mp2.entrySet());
        // return mp1.equals(mp2); 
        return areMapsEqual(mp1, mp2); 
    
    }

    public static boolean isAnagramOneHashMap(String s , String t){
        if (s.length()!=t.length()) {
            return false;
        }
        HashMap<Character , Integer> mp1= freqString(s);  
        for (int i = 0; i < t.length(); i++) {
            Character ch= t.charAt(i);
            if (!mp1.containsKey(ch)) {
                return false;
            }
            int currFreq = mp1.get(ch);
            mp1.put(ch, currFreq-1);
            if (mp1.get(ch)==0) {
                mp1.remove(ch);
            }
        }
        //?This is to check value in hashmap :use extra space
        // List<Character> keys = new ArrayList<>(mp1.keySet());
        // System.out.println(keys);
        // for (int i = 0; i < keys.size(); i++) {
        //     Character key  = keys.get(i);
        //     if (mp1.get(key)!=0) {
        //         return false;
        //     }
        // }

        //? this is to check value in map : Without using extra space
        // for (var e : mp1.values()) {
        //     if (e!=0) {
        //         return false;
        //     }
        // }
        if (mp1.size()!=0) {
            return false;
        }
        return true;
    }
    
    public static boolean isIsomorphic(String s, String t){
        if (s.length()!=t.length()) {
            return false;
        }
        HashMap<Character, Character> mp=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sch =s.charAt(i);
            Character tch =t.charAt(i);
            if (mp.containsKey(sch)) {
                if (mp.get(sch)!=tch) {
                    return false;
                }
            }else if (mp.containsValue(tch)) {//? containsValue in hash map has Linear Time Compleixty //O(n) but we can do this in constant time by using HASHSET 
                return false;
            }else{
                mp.put(sch, tch);
            }
        }//O(n)
        
        return true;
    }
    public static int[] pairIdxSum(int arr[],int target){
        int[] ans ={-1};//to pass an pair of index 
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int partner = target - arr[i];
            if (mp.containsKey(partner)) {
                ans = new int[]{i, mp.get(partner)};//* Imp: pass pair in array
                return ans;
            }
            mp.put(arr[i],i);
        }
        System.out.println(mp);
        return ans;
    }
    public static void subaryLen(int arr[]){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int preifxSum = 0;
        int maxLen =0;
        mp.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            preifxSum +=arr[i];
            if (mp.containsKey(preifxSum)) {
                maxLen = Math.max(maxLen, i-mp.get(preifxSum));
            }else{
                mp.put(preifxSum, i);
            }   
        }
        System.out.println(maxLen);
    }
    public static void main(String args[]){
        //! Quse :(Valid Anagram) Check whether two Strings are anagram of each other. Return true if they are else false. An anagram  of a string is another string that contains the same characters, only the order of characters can be different . For ex: "abcd" and "dabc" are an anagram of each other.
        //? For ex: listen and silent (anagram) & anagram and grams (not anagram)
        //* NOTE: Anagram ===> In two string set of characters should be same but order of character can be different */

        //? Condition : i> length of both (equal) ii> freq of each char (same) iii> No char extra from other

        //?Approch 1:
        String s1= "abcd";
        String s2 = "dabc";
        System.out.println(isAnagram(s1, s2));
        //We use Two hash map here due to which space are accumulate so much 

        //? Approch2 : using One Hahs Map 
        System.out.println("<========Using One HashMap========>");
        System.out.println(isAnagramOneHashMap("keen", "knese"));//O(n)

        //! Ques:Are two Strings isomorphic 
        System.out.println("<======Check Strings are isomorphic =======>");
        System.out.println(isIsomorphic("abacd","xyxzx"));
        //Time Complexty is O(n^2)

        //! Ques: Given an array of length and a target, return a pair(indices) whose sum is eqaul to the target. If there is no pair present , return -1
        System.out.println("<=======pairSum whose sum is target=========>");
        int arr[] = {14,7,10,4,5,9,1,2};
        int a[]=pairIdxSum(arr,13);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();

        //! Ques : Find largest subarray whose sum is equal to Zero
        System.out.println("<========Find largest subarray whose sum is equal to Zero=======>");
        int aray[] ={15,-2,2,-8,1,7,10};
        subaryLen(aray);
    }
}
