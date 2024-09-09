package J_Tree;

import java.util.*;

public class BinaryTree_001 {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    public static int maxNode(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;// so that it will work for -ve value also in tree
        }
        int a = root.val;
        int b = maxNode(root.left);
        int c = maxNode(root.right);

        return Math.max(a, Math.max(b, c));

    }

    public static int maxHigh(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        return Math.max(maxHigh(root.left), maxHigh(root.right)) + 1;
    }

    public static int minValue(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.val, Math.min(minValue(root.left), minValue(root.right)));
    }

    public static int productValue(Node root) {
        if (root == null) {
            return 1;
        }
        return productValue(root.left) * productValue(root.right) * root.val;
    }

    public static void printLevel(Node root, int n) {
        if (root == null) {
            return;
        }
        if (n == 1) {
            System.out.print(root.val + " ");
            return;
        }
        printLevel(root.left, n - 1);
        printLevel(root.right, n - 1);
    }

    public static void dfcIterativeInorder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st.push(root);
        while (st.size() > 0) {
            Node temp = st.peek();
            if (temp.left != null) {
                st.push(temp.left);
                temp.left = null;// ?vvImp
            } else {
                st.pop();
                list.add(temp.val);
                if (temp.right != null)
                    st.push(temp.right);
            }
        }
        System.out.println(list);
    }

    public static void dfcIterativePreorder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        st.push(root);
        while (st.size()>0) {
            Node temp = st.pop();
            list.add(temp.val);
            // Push right child first so that left is processed first
            if (temp.right != null) {
                st.push(temp.right);
            }
            if (temp.left != null) {
                st.push(temp.left);
            }
        }
        System.out.println(list);
    }
    
    public static void main(String[] args) {
        Node root = new Node(-1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(-4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(6);
        Node f = new Node(-7);
        b.left = e;
        b.right = f;
        System.out.println("<======Inorder Traversal=======>");
        inorder(root);
        System.out.println();
        // ! Ques : Size of the tree
        System.out.println("<========Size of the tree=======>");
        System.out.println(size(root));

        // ! Ques : max Value in tree
        System.out.println("<======Maximem Node Value=======>");
        System.out.println(maxNode(root));

        // ! Ques : max height according to edgeWise
        System.out.println("<=====Maximum height according to edges=====>");
        System.out.println(maxHigh(root));

        // ! Ques : Min value of the tree
        System.out.println("<======Minimum Value in tree=======>");
        System.out.println(minValue(root));

        // ! Ques : Product value of the tree
        System.out.println("<======Product of Value in tree=======>");
        System.out.println(productValue(root));

        // ! Ques : print kth level nodes of tree
        System.out.println("<======print kth level nodes====>");
        printLevel(root, 3);
        // ? Time complexity : O(n) using but it can be done using iterative way in
        // which we use queue instead of using recursion.

        // ! Ques : Inorder traversal(DFS) by iteration using stack
        System.out.println();
        System.out.println("<=========Inorder Traversal by Iteration using stack=======>");
        dfcIterativeInorder(root);

        // ! Ques : preorder traversal(DFS) by iteration using stack
        System.out.println("<=========preorder Traversal by Iteration using stack=======>");
        dfcIterativePreorder(root);

    }
}
