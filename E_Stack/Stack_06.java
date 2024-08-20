package E_Stack;

import java.util.*;

public class Stack_06 {
    public static void infix(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57)
                val.push(ascii - 48);
            else if (op.size() == 0)
                op.push(ch);
            else {
                if (ch == '+' || ch == '-') {
                    // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '-')
                        val.push(v1 - v2);
                    if (op.peek() == '+')
                        val.push(v1 + v2);
                    if (op.peek() == '*')
                        val.push(v1 * v2);
                    if (op.peek() == '/')
                        val.push(v1 / v2);
                    op.pop();

                    // push
                    op.push(ch);
                } else if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        // work
                        int v2 = val.pop();
                        int v1 = val.pop();
                        // if ch=='*' and op.peek()=='-' then no need to perform operation simply push
                        // the element after pop peel from op stack
                        if (op.peek() == '*')
                            val.push(v1 * v2);
                        if (op.peek() == '/')
                            val.push(v1 / v2);
                        op.pop();

                        // push
                        op.push(ch);
                    } else
                        op.push(ch);
                }
            }
        }
        // val stack size -> 1
        while (val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
            if (op.peek() == '-')
                val.push(v1 - v2);
            if (op.peek() == '+')
                val.push(v1 + v2);
            if (op.peek() == '*')
                val.push(v1 * v2);
            if (op.peek() == '/')
                val.push(v1 / v2);
            op.pop();
        }
        System.out.println(val.peek());
    }

    public static void infixBrac(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57)
                val.push(ascii - 48);
            else if (op.size() == 0 || ch == '(' || op.peek() == '(')
                op.push(ch);
            else if (ch == ')') {
                while (op.peek() != '(') {
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '-')
                        val.push(v1 - v2);
                    if (op.peek() == '+')
                        val.push(v1 + v2);
                    if (op.peek() == '*')
                        val.push(v1 * v2);
                    if (op.peek() == '/')
                        val.push(v1 / v2);
                    op.pop();
                }
                op.pop();// '(' remove
            } else {
                if (ch == '+' || ch == '-') {
                    // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '-')
                        val.push(v1 - v2);
                    if (op.peek() == '+')
                        val.push(v1 + v2);
                    if (op.peek() == '*')
                        val.push(v1 * v2);
                    if (op.peek() == '/')
                        val.push(v1 / v2);
                    op.pop();

                    // push
                    op.push(ch);
                } else if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        // work
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (op.peek() == '*')
                            val.push(v1 * v2);
                        if (op.peek() == '/')
                            val.push(v1 / v2);
                        op.pop();

                        // push
                        op.push(ch);
                    } else
                        op.push(ch);
                }
            }
        }
        // val stack size -> 1
        while (val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
            if (op.peek() == '-')
                val.push(v1 - v2);
            if (op.peek() == '+')
                val.push(v1 + v2);
            if (op.peek() == '*')
                val.push(v1 * v2);
            if (op.peek() == '/')
                val.push(v1 / v2);
            op.pop();
        }
        System.out.println(val.peek());
    }

    public static void prefix(String str) {
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                int strVal = ascii - 48;
                val.push(String.valueOf(strVal));
            } else if (op.size() == 0 || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = o + v1 + v2;
                    val.push(t);
                }
                op.pop();// remove '('
            } else {
                if (ch == '+' || ch == '-') {
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = o + v1 + v2;
                    val.push(t);

                    // push
                    op.push(ch);
                } else if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        // work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = o + v1 + v2;
                        val.push(t);

                        // push
                        op.push(ch);
                    } else
                        op.push(ch);
                }
            }
        }
        while (val.size() > 1) {
            // work
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = o + v1 + v2;
            val.push(t);
        }
        String prefix = val.pop();
        System.out.println(prefix);

    }

    public static void postfix(String str) {
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                // int strVal = ascii - 48;
                // val.push(String.valueOf(strVal));
                String s = "" + ch; // ?Char + String == String
                val.push(s);

            } else if (op.size() == 0 || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1 + v2 + o;
                    val.push(t);
                }
                op.pop();// remove '('
            } else {
                if (ch == '+' || ch == '-') {
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1 + v2 + o;
                    val.push(t);

                    // push
                    op.push(ch);
                } else if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        // work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = v1 + v2 + o;
                        val.push(t);

                        // push
                        op.push(ch);
                    } else
                        op.push(ch);
                }
            }
        }
        while (val.size() > 1) {
            // work
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = v1 + v2 + o;
            val.push(t);
        }
        String prefix = val.pop();
        System.out.println(prefix);

    }

    public static void solveExpPost(String str) {
        Stack<Integer> val = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
            } else {
                int v2 = val.pop();
                int v1 = val.pop();
                if (ch == '+') {
                    val.push(v1 + v2);
                } else if (ch == '-') {
                    val.push(v1 - v2);
                } else if (ch == '*') {
                    val.push(v1 * v2);
                } else {
                    val.push(v1 / v2);
                }
            }
        }
        System.out.println(val.peek());
    }

    public static void solveExpPref(String str) {
        Stack<Integer> val = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
            } else {
                // ? NOTE:  we changle v1 and v2 here because in prefix we traverse string from reverse side
                int v1 = val.pop();
                int v2 = val.pop();
                if (ch == '+') {
                    val.push(v1 + v2);
                } else if (ch == '-') {
                    val.push(v1 - v2);
                } else if (ch == '*') {
                    val.push(v1 * v2);
                } else {
                    val.push(v1 / v2);
                }
            }
        }
        System.out.println(val.peek());
    }
    
    public static void prefPost(String str){
        Stack<String> st = new Stack<>();
        for (int i = str.length()-1; i >=0; i--) {
            char ch= str.charAt(i);
            int ascii  = (int)ch;
            if (ascii>=48 && ascii <=57) {
                st.push(""+ch);
            }else{
                String v1 = st.pop();
                String v2 =st.pop();
                String val = v1+v2+ch;
                st.push(val);
            }
        }
        System.out.println(st.peek());
    }
    
    public static void postPref(String str){
        Stack<String> st = new Stack<>();
        for (int i = 0;i<str.length();i++) {
            char ch= str.charAt(i);
            int ascii  = (int)ch;
            if (ascii>=48 && ascii <=57) {
                st.push(""+ch);
            }else{
                String v2 = st.pop();
                String v1 =st.pop();
                String val = ch+v1+v2;
                st.push(val);
            }
        }
        System.out.println(st.peek());
    }

    public static void postToInfix(String str){
        Stack<String> st = new Stack<>();
        for (int i = 0;i<str.length();i++) {
            char ch= str.charAt(i);
            int ascii  = (int)ch;
            if (ascii>=48 && ascii <=57) {
                st.push(""+ch);
            }else{
                String v2 = st.pop();
                String v1 =st.pop();
                String val = v1+ch+v2;
                st.push(val);
            }
        }
        System.out.println(st.peek());
    }
   
    public static void prefToInfix(String str){
        Stack<String> st = new Stack<>();
        for (int i = str.length()-1;i>=0;i--) {
            char ch= str.charAt(i);
            int ascii  = (int)ch;
            if (ascii>=48 && ascii <=57) {
                st.push(""+ch);
            }else{
                String v1 = st.pop();
                String v2 =st.pop();
                String val = v1+ch+v2;
                st.push(val);
            }
        }
        System.out.println(st.peek());
    }
   
    public static void main(String[] args) {
        //! Ques :  To solve expression of string i.e., infix
        System.out.println("<=======To solve expression of string i.e., infix=========>");
        infix("9-5+3*4/6");
        infixBrac("9-(5+3)*4/6");

        //! Ques :  Conversion Infix to prefix
        System.out.println("<======Conversion Infix to prefix======>");
        prefix("9-(5+3)*4/6");

        //! Ques :  Conversion Infix to postfix
        System.out.println("<======Conversion Infix to postfix======>");
        postfix("9-(5+3)*4/6");

        //! Ques :  Solve expression of Prefix
        System.out.println("<======Solve expression of Prefix======>");
        solveExpPref("-9/*+5346");

        //! Ques :  Solve expression of Postfix
        System.out.println("<======Solve expression of Postfix======>");
        solveExpPost("953+4*6/-");

        //! Ques :  Conversion prefix to postfix
        System.out.println("<======Conversion prefix to postfix=========>");
        prefPost("-9/*+5346");
        
        //! Ques :  Conversion  postfix to prefix
        System.out.println("<======Conversion postfix to prefix=========>");
        postPref("953+4*6/-");

        //? During conversion into Infix its must with brackets otherwise get wrong answer
        //! Ques :  Conversion  postfix to Infix
        System.out.println("<======= Conversion postfix to Infix========>");
        postToInfix("953+4*6/-");

         //! Ques :  Conversion  prefix to Infix
        System.out.println("<======= Conversion prefix to Infix========>");
        prefToInfix("-9/*+5346");

    }
}
