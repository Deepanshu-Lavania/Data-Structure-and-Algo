package RecursionString;

import java.util.*;

public class RecStr_02 {
    static ArrayList<String> getSSQ(String str) {
        ArrayList<String> ans = new ArrayList<>();
        // base case
        if (str.length() == 0) {
            ans.add("");// because empty string consist
            return ans;
        }

        char curr = str.charAt(0);
        System.out.println("curr character is : " + curr);
        ArrayList<String> smallAns = getSSQ(str.substring(1));// {"bc","c"," "}
        // smallAns =["bc","b","c",""]
        // ans=["bc","abc","b","ab","c","ac","","a"]
        for (int i = 0; i < smallAns.size(); i++) {
            ans.add(smallAns.get(i));
            ans.add(curr + smallAns.get(i));
        }
        return ans;
    }

    static void printSSQ(String str, String currAns) {
        if (str.length() == 0) {
            System.out.println(currAns+" : "+currAns.length() );
            return;
        }
        char curr=str.charAt(0);//a
        String remString  = str.substring(1);//bc

        // Curr Char -> choooses to be a part of currAns
        printSSQ(remString,currAns+curr);
         // Curr Char ->does not choooses to be  a part of currAns
        printSSQ(remString, currAns);

        //? ans==> 2^3 value can exists in a subsequence
    }

    static void sumSubSetArr(int arr[],int n,int idx,int sum){
        if(idx>=arr.length){
            System.out.println(sum);
            return;
        }
        int currEle = arr[idx];
        sumSubSetArr(arr,n, idx+1,sum+currEle);
        sumSubSetArr(arr, n,idx+1,sum);
    }
    public static void main(String[] args) {
        String st = "abc";

        // ? Return Subsequences : "abc"==> "abc", "ab" , "ac", "a", "bc", "b", "c", " ".
        // ! Ques : Given a string, WAM to retrun all its subsequences in an arraylist
        // System.out.println(getSSQ(st));
        ArrayList<String> ans = getSSQ(st);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        //? Include Exclude techniques to find the number of permutaion in for given input
        System.out.println();
        System.out.println("size of new arrayList is :" + ans.size());
        // ! Ques : Given a string, print all its subsequences without using extra space i.e., ArrayList
        System.out.println();
        printSSQ(st,"");
        System.out.println();
        // ! Ques : Given an array of integers, print sums of all subsets in it.
        int arr[]={2,5,4};
        int n=arr.length;
        sumSubSetArr(arr,n,0,0);
    }
}
