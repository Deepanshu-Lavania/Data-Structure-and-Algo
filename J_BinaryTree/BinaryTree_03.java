package J_BinaryTree;

import java.util.*;

public class BinaryTree_03 {
    public static class Node {
        Node leftNode;
        Node rightNode;
        int val;

        Node(int val) {
            this.val = val;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    public static class BinaryTrees {
        private int idx = -1; // Make idx an instance variable

        Node buildTrees(int node[]) {
            idx++;
            if (idx >= node.length || node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.leftNode = buildTrees(node);
            newNode.rightNode = buildTrees(node);
            return newNode;
        }
    }

    public static class BinarySubTrees {
        private int idx = -1; // Make idx an instance variable

        Node buildSubTrees(int node[]) {
            idx++;
            if (idx >= node.length || node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.leftNode = buildSubTrees(node);
            newNode.rightNode = buildSubTrees(node);
            return newNode;
        }
    }

    public static int maxHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftheight = maxHeight(root.leftNode);
        int rightheight = maxHeight(root.rightNode);
        // int treeheight = Math.max(leftheight, rightheight)+1;
        // return treeheight;
        if (leftheight > rightheight) {
            return leftheight + 1;
        } else {
            return rightheight + 1;
        }
    }

    public static int maxDiam(Node root) {
        if (root == null) {
            return 0;
        }
        int Diam1 = maxDiam(root.leftNode);
        int Diam2 = maxDiam(root.rightNode);
        int Diam3 = maxHeight(root.leftNode) + maxHeight(root.rightNode) + 1;

        return Math.max(Diam3, Math.max(Diam1, Diam2));
    }

    public static class TreeInfo {
        //?The TreeInfo class is used in code to optimize the calculation of the diameter of the tree by allowing you to return multiple values (both height and diameter) in a single function call, rather than calculating these values separately. This improves efficiency by avoiding redundant computations.
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {// constructor
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftSubtree = diameter2(root.leftNode);
        TreeInfo rightSubtree = diameter2(root.rightNode);

        // height
        int myHeight = Math.max(leftSubtree.ht, rightSubtree.ht) + 1;

        // diameter for all cases : leftSubtree , rightSubtree , wholeTree
        int diam1 = leftSubtree.diam;
        int diam2 = rightSubtree.diam;
        int diam3 = leftSubtree.ht + rightSubtree.ht + 1;

        int mydiam = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, mydiam);
        return myInfo;
    }
    
    public static boolean isIdentical(Node root, Node subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if (root == null || subroot == null) {
            return false;
        }
        if (root.val == subroot.val) {
            return isIdentical(root.leftNode, subroot.leftNode) && isIdentical(root.rightNode, subroot.rightNode);
        }
        return false;
    }

    public static boolean checkSubtree(Node root, Node subroot) {
        if (subroot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subroot)) {
            if (root.val == subroot.val) {
                return true;
            }
        }
        return checkSubtree(root.leftNode, subroot) || checkSubtree(root.rightNode, subroot);
    }

    public static int levelSum(Node root,int k) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int sum=0;
        int count=1;
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (count==k && currNode==null) {
                return sum;
            }
            if (currNode == null) {
                sum=0;
                count++;
                if (!q.isEmpty()) {
                    q.add(null);
                }else{
                    break;
                }
            }else{
                if (k==count) {
                    sum+=currNode.val;
                }
                if (currNode.leftNode!=null) {
                    q.add(currNode.leftNode);
                }
                if (currNode.rightNode!=null) {
                    q.add(currNode.rightNode);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BinaryTrees tree = new BinaryTrees();
        BinarySubTrees subtree = new BinarySubTrees();
        int node[] = { 5, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, 8, -1, 9, 10, -1, -1 };

        Node root = tree.buildTrees(node);
        if (root != null) {
            System.out.println(root.val); // Prints the value of the root node
        } else {
            System.out.println("The tree is empty.");
        }

        // ! Ques : Find largest diameter of a tree
        System.out.println("<=======Find largest diameter of a tree in Quadratic time ======>");
        System.out.println(maxDiam(root));
        // ? Time complexity is O(n^2) because we traverse for diameter on each row then
        // we also traverse again for height calculation.

        // diameter2(root);
        System.out.println("Find largest diameter of a tree in linear time");
        System.out.println(diameter2(root).diam);

        // ! Ques : Check subtree is present in the Tree
        int subnode[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node subroot = subtree.buildSubTrees(subnode);
        System.out.println("<======Is Subtree present in the Tree =====>");
        checkSubtree(root, subroot);
        System.out.println(checkSubtree(root, subroot));

        //! Ques : Sum of node at any Level in tree"
        System.out.println("<=====Levelorder Sum=====>");
        int k=3;
        int sum =levelSum(subroot,k);
        System.out.println("The sum of tree at level "+k +" is "+sum);
        System.out.println(diameter2(subroot).diam);
    }

}
