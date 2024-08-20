package RecursionString;

import java.util.Scanner;

public class RecStr_01 {
    static String remEleRecu(String s, int idx, String ans) {
        if (idx == s.length()) {
            return ans;
        }
        if (s.charAt(idx) != 'a') {
            ans += s.charAt(idx);
        }
        return remEleRecu(s, idx + 1, ans);
    }
    // ! Time Complexity : No. of calls + Time taken in 1 call
    // ? T.C : O(n)+O(n) == O(n^2)

    static String remEleSubRecu(String s) {// s = abcax , bcax , cax , ax , x
        if (s.length() == 0) {
            return "";
        }
        String smallAns = remEleSubRecu(s.substring(1));// abcax , bcax , cax , ax , x
        // ? Substring also takes time in linear i.e., O(n)
        char currChar = s.charAt(0);
        if (currChar != 'a') {
            return currChar + smallAns;// ? Concatination of String so it takes O(n) time in string
        } else {
            return smallAns;
        }
        // ! Time Complexitu : No. of calls + Time taken in 1 call
        // ? T.C : O(n)+2*O(n) == 2*O(n^2) == O(n^2)
    }

    static String printRevStr(String str, int idx) {
        if (idx >= str.length()) {
            return "";
        }
        String smallAns = printRevStr(str, idx + 1);
        return smallAns + str.charAt(idx); // ? string + Char == String
    }

    static boolean twoPointRevStr(String str, int l, int r) {
        if (l >= r) {
            return true;
        }
        if(str.charAt(l)!=str.charAt(r)){
            return false;
        }
        return twoPointRevStr(str, l + 1, r - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "Deepanshu Singh Lavania";
        // for (int i = 0; i < args.length; i++) { //? This is for array
        // System.out.println(arr[i]);
        // }
        for (int i = 0; i < s.length(); i++) { // ? here length is the methodk for string
            System.out.print(s.charAt(i) + " "); // ?CharAt() method used in String to print characters
        }
        System.out.println();
        System.out.println(s.substring(3, 9));
        System.out.println(s.substring(3));

        // ! Ques: To remove the character from an array if present
        String str = "levelf";
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'a') {
                ans += str.charAt(i);
            }
        }
        System.out.println("Remove Char by using normal iteration :");
        System.out.print(ans);
        System.out.println();
        // ! Ques : To remove the character from an array using index in recursion
        String RecuAns = "";
        System.out.println("Remove Char by using index throgh Recursion :");
        System.out.println(remEleRecu(str, 0, RecuAns));
        System.out.println();

        // ! Ques : To remove the character from an array without using index (through
        // substrings)
        System.out.println("Remove Char by using Recursion without using index :");
        System.out.println(remEleSubRecu(str));

        // ! Ques: To print reverse of a string using recursion
        System.out.println(printRevStr(str, 0));
        // ! Ques : Check String is palindroom or not
        String strPalndrm = printRevStr(str, 0);
        if (strPalndrm.equals(str)) {
            // System.out.println(str+" is palindroom");
            System.out.printf("%s is palindroom", str);
        } else {
            System.out.printf("%s is not palindroom", str);
        }
        // ! Ques : Check String is palindroom or not using left and right pointer
        System.out.println();
        System.out.println("String is palindroom or not using left and right pointer ");
        String st = "saf";
        if (twoPointRevStr(st, 0, st.length() - 1)) {
            System.out.printf("%s is palindroom String ", st);
        }else {
            System.out.printf("%s is not palindroom String", st);
        }
    }
}
