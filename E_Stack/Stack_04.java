package E_Stack;

import java.util.*;

public class Stack_04 {
    public static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();
        // int size=0;

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);

            } else {
                if (st.size() == 0) {
                    return false;
                }
                if (st.peek() == '(') {
                    // size++;
                    st.pop();
                }
            }
        }
        // System.out.println("The number of element to be removed is: "+(n-size*size));
        if (st.size() > 0) {
            return false;
        }
        return true;
    }

    public static void checkNumBrackets(String str) {
        Stack<Character> st = new Stack<>();
        int unmatchClosing = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.isEmpty()) {
                    unmatchClosing++;
                } else {
                    st.pop();
                }
            }
        }
        int unmatchOpening = st.size();
        System.out.println("unmatch " + (unmatchOpening + unmatchClosing));
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean checkBracketsSeq(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {// ch=')'
                if (st.size() == 0) {
                    return false;
                }
                if ((ch == ')' && st.peek() != '(') || (ch == ']' && st.peek() != '[')
                        || (ch == '}' && st.peek() != '{')) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return true;
    }

    public static int[] removeConSub(int arr[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0 || arr[i] != st.peek()) {
                st.push(arr[i]);
            } else if (arr[i] == st.peek()) {
                if (i == arr.length - 1 || arr[i] != arr[i + 1]) {
                    st.pop();
                }
            }
        }
        System.out.print("Stack is : ");
        System.out.println(st);
        int newArr[] = new int[st.size()];
        for (int i = newArr.length - 1; i >= 0; i--) {
            newArr[i] = st.pop();// enter value of stack into array
        }
        return newArr;
    }

    public static void nextGretEle(int arr[]) {
        int newArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    newArr[i] = arr[j];
                    break;
                } else {
                    newArr[i] = -1;
                }
            }
        }
        printArr(arr);
        printArr(newArr);

    }

    public static void nextGretEleStack(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int newArr[] = new int[arr.length];
        newArr[arr.length - 1] = -1;
        st.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= arr[i]) {// can't be change the order of conditions otherwise it give
                                                          // emptyStackException
                st.pop();
            }
            if (st.size() == 0) {
                newArr[i] = -1;
            } else {
                newArr[i] = st.peek();
            }
            st.push(arr[i]);
        }
        printArr(newArr);
    }

    public static void nextSpanElem(int arr[]) {
        int newArr[] = new int[arr.length];
        newArr[0] = 1;
        printArr(arr);
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (arr[j - 1] < arr[i] && j > 0) {
                j--;
            }
            int x = j - 1;
            newArr[i] = i - x;
        }
        printArr(newArr);
    }

    public static void nextSpanElemStack(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int newArr[] = new int[arr.length];
        newArr[0] = 1;
        st.push(0);
        for (int i = 1; i < newArr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            // If the stack is empty, it means all elements to the left are smaller
            // ? newArr[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            if (st.isEmpty()) {
                newArr[i] = i + 1;
            } else {
                newArr[i] = i - st.peek();
            }
            st.push(i);
        }
        printArr(newArr);
    }

    public static void main(String[] args) {
        // System.out.print("Enter input string : ");
        // String str = sc.nextLine();
        // ! Ques : check whether a given bracket sequence is balanced or not
        Scanner sc = new Scanner(System.in);
        String s = "()())(";
        if (isBalanced(s)) {
            System.out.println("String is balanced");
        } else {
            System.out.println("string is not balanced");
        }
        // ! find minimum number of brackets to removed for making an balanced String
        checkNumBrackets(s);

        // ! Check whether a given bracket sequence is valid(balance) or not :- for
        // character '()','{}','[]'
        String sI = "([)]";
        System.out.println(checkBracketsSeq(sI));

        // ! Ques : Remove Consecutive subsequence whose length>1
        int a[] = { 1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2 };
        int newArr[] = removeConSub(a);
        System.out.print("Array is : ");
        printArr(newArr);

        // ! Ques : find next Greater element if there is no next greater element then
        // put -1 there
        // ? Approch 1:
        int ar[] = { 1, 3, 2, 1, 8, 6, 3, 4 };
        nextGretEle(ar);
        // Time complexity is : O(n^2)
        // ? Approch 2:
        nextGretEleStack(ar);
        // Time complexity is : O(n)
        // ! Quse : Given a series of N daily qusotes for as stock , we need to calculate the span of the stock's price for all N days. The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
        int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
        nextSpanElem(arr);
        // Time complexity is : O(n^2)
        nextSpanElemStack(arr);
        // Time complexity is : O(n)

    }
}
