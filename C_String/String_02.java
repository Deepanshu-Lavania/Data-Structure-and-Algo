package C_String;

public class String_02 {
    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        // ! Ques : Given a string s , return the number of palindormic substrings in
        // it.
        System.out.println("<=========== the number of palindormic substrings =============> ");
        String str = "abbd";
        int count = 0;
        System.out.println(isPalindrome(str));
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if ((isPalindrome(str.substring(i, j))) == true) {
                    count++;
                    System.out.print(str.substring(i, j) + " ");
                }
            }
        }
        System.out.println("number of Palindrome present is : " + count);

        // ! Quse : Reverse each word in String Input: I am an educator ==> I ma na
        // rotacude
        System.out.println("<=========== Reverse each word in String ===========>");
        String s = "I am an online educator";
        String ans = " ";
        StringBuilder st = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                st.append(ch);

            } else {
                st.reverse();
                System.out.println(st);
                ans += st;
                ans += " ";
                st = new StringBuilder("");
            }
        }
        System.out.println(ans);// educator is not come becatse else operation perform when ch==' '
        st.reverse();
        ans += st;
        System.out.println(ans);

        // ! Ques : Compressed string Input: aaabbbbccddde ===> a3b4c2d2e

        System.out.println("<================== Compressed string =================>");
        String input = "aaabbbbccdddeee";
        int num = 1;
        String res = "" + input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (input.charAt(i) == input.charAt(i - 1)) {
                num++;
            } else {
                if (num > 1)
                    res += num;
                num = 1;
                res += ch;
            }
        }
        System.out.println(res);
        if (num > 1)
            res += num;// because when loop reach to last it doesn't get else situation
        System.out.println(res);
    }
}
