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

        // Convert the keySet to a list
        List<Character> keys = new ArrayList<>(mp1.keySet());
        System.out.println(keys);
        // Step 2: Use a normal for loop with an index to iterate over the keys
        for (int i = 0; i < keys.size(); i++) {
            Character key = keys.get(i);
            System.out.println("key is "+key);

            if (!mp2.containsKey(key)) {
                return false;  // Key not present in both maps
            }
            if (!mp1.get(key).equals(mp2.get(key))) {
                return false;  // Values do not match
            }
        }

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
    public static void main(String args[]){
        //! Quse :(Valid Anagram) Check whether two Strings are anagram of each other. Return true if they are else false. An anagram  of a string is another string that contains the same characters, only the order of characters can be different . For ex: "abcd" and "dabc" are an anagram of each other.
        //? For ex: listen and silent (anagram) & anagram and grams (not anagram)
        //* NOTE: Anagram ===> In two string set of characters should be same but order of character can be different */

        //? Condition : i> length of both (equal) ii> freq of each char (same) iii> No char extra from other

        String s1= "abcd";
        String s2 = "dabc";
        System.out.println(isAnagram(s1, s2));
    }
}
