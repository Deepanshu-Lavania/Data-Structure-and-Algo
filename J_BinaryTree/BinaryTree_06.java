package J_BinaryTree;

import java.util.*;

public class BinaryTree_06 {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node constructBFS(String arr[]) {
        int x = Integer.parseInt(arr[0]);
        int n = arr.length;
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < n - 1) {
            Node temp = q.remove();// peek of Queue
            Node leftNode = new Node(10);
            Node rightNode = new Node(100);
            if (arr[i].equals("")) {
                leftNode = null;
            } else {
                int l = Integer.parseInt(arr[i]);
                leftNode.val = l;
                q.add(leftNode);
            }

            if (arr[i + 1].equals("")) {
                rightNode = null;
            } else {
                int r = Integer.parseInt(arr[i + 1]);
                rightNode.val = r;
                q.add(rightNode);
            }
            temp.left = leftNode;
            temp.right = rightNode;
            i += 2;
        }
        return root;
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void nthLevel(Node root, int n) {
        if (root == null) {
            return;
        }
        if (n == 1) {
            System.out.print(root.val + " ");
            ;
            return;
        }
        nthLevel(root.left, n - 1);
        nthLevel(root.right, n - 1);
    }

    public static void leftBoundry(Node root){
        if (root==null || (root.left==null && root.right==null)) {
            return;
        }
        System.out.print(root.val+" ");
        leftBoundry(root.left);
        if (root.left==null) {
            leftBoundry(root.right); 
        }
    }
    public static void leafBoundry(Node root){
        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null) {     
            System.out.print(root.val+" ");
        }
        leafBoundry(root.left);
        leafBoundry(root.right);
    }
    public static void rightBoundry(Node root){
        if (root==null || (root.left==null && root.right==null)) {
            return;
        }
        rightBoundry(root.right); 
        if (root.right==null) {
            rightBoundry(root.left);
        }
        System.out.print(root.val+" ");
    } 
    public static void boundryDisplay(Node root){
        // System.out.println("LeftBoundry");
        leftBoundry(root);
        // System.out.println();
        // System.out.println("LeafNode");
        leafBoundry(root);
        // System.out.println();
        // System.out.println("RightBoundry");
        rightBoundry(root.right);

    }
    

    public static void preOrder(Node root,List<Integer> arrlist, int level ){
        if (root==null) {
            return;
        }
        arrlist.set(level-1, root.val);
        preOrder(root.left, arrlist, level+1);
        preOrder(root.right, arrlist, level+1);
    }

    public static List<Integer> rightSideView(Node root){
        List<Integer> arrlist= new ArrayList<>();
        if(root==null) return arrlist;
        int level = height(root);
        for (int i = 0; i < level; i++) {
            arrlist.add(100);//value will change
        }
        preOrder(root, arrlist ,1);
        return arrlist;
    }
    public static void main(String[] args) {
        // ! Quse : Contruct tree from level order traversal
        String arr[] = {
                "1", "2", "3", "4", "5", "", "6", "7", "", "8","","9",
                "10", "", "11", "", "12", "", "13", "", "14", "15", "16","", "17", "", "", "18", "",
                "19", "", "", "", "20", "21", "22", "23", "", "24","25",
                "26", "27", "", "", "28", "", ""
        };
        Node root = constructBFS(arr);
        int level = height(root) ;
        for (int i = 0; i < level; i++) {
            nthLevel(root, i);
            System.out.println();
        }
        //! Ques: Boundry Traversal of Binary tree
        System.out.println("<=======Boundry Traversal of Binary tree ==========>");
        boundryDisplay(root);

        System.out.println();
        //! Ques : Traverse Right Side View
        System.out.println("<=======rightSideView=======>");
        List<Integer> list= rightSideView(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

    }
}
