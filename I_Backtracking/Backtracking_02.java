package I_Backtracking;

import java.util.*;

public class Backtracking_02 {
    public static void printP(String str , String t,List<String> l){
        if (str.equals("")) {
            // System.out.println(t);
            l.add(t);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String  left =str.substring(0, i);
            String right = str.substring(i+1);
            String remainString =left+right;
            printP(remainString,t+ch,l);
        }
    }
   
    public static void helper(int nums[],List<Integer> ds,boolean[] isValid, List<List<Integer>> ans){
        if(ds.size()==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i = 0 ; i<ds.size();i++){
                list.add(ds.get(i));
            }
            ans.add(list);
            return;
        }
        for(int i =0 ; i<nums.length;i++){
            if(isValid[i] == false){
                ds.add(nums[i]);
                isValid[i]=true;
                helper(nums,ds,isValid,ans);
                //backtracking
                isValid[i] =false;
                ds.remove(ds.size()-1);//last index
            }
        }
    }
    public static  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] isValid = new boolean[nums.length];
        helper(nums,ds,isValid,ans);
        return ans;
    }
    public static void main(String[] args) {
        //! permutation of String 
        System.out.println("<====return all the possible permutations of String====>");
        List<String> l =new ArrayList<>();
        String str= "abc";
        printP(str,"",l);
        for (int i = 0; i <l.size(); i++) {
            System.out.print(l.get(i)+" ");
        }

        //! Ques: Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
        System.out.println();
        System.out.println("<====return all the possible permutations of array====>");
        int arr[]={1,2,3};
        List<List<Integer>> ans = permute(arr);
        System.out.println(ans);
    }
}
