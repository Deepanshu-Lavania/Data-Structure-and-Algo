package J_BinaryTree;

import java.util.*;

public class BinaryTree_04 {
    public static class Node {
        Node left;
        Node right;
        int val;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTrees {
        private int idx = -1; // Make idx an instance variable or Global variable

        Node buildTrees(int node[]) {
            idx++;
            if (idx >= node.length || node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildTrees(node);
            newNode.right = buildTrees(node);
            return newNode;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static boolean isBalancedBTree(Node root) {
        if (root == null)
            return true; // A null tree is balanced

        // Calculate height difference
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check if the current node's height difference is greater than 1
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        // Recursively check if the left and right subtrees are balanced
        return isBalancedBTree(root.left) && isBalancedBTree(root.right);
    }

    public static void helper(Node root, List<String> ans, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            s = s + root.val;
            ans.add(s);
            return;
        }
        helper(root.left, ans, s + root.val + "->");
        helper(root.right, ans, s + root.val + "->");
    }

    public static List<String> binaryTreePaths(Node root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, "");
        return ans;
    }

    public static void printPath(List<Integer> path) {
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + (i == 0 ? "\n" : " -> "));
        }
    }

    public static void printLeafToRoot(Node node, List<Integer> path) {
        if (node == null)
            return;

        // Add the current node to the path
        path.add(node.val);

        // If it's a leaf node, print the path from leaf to root
        if (node.left == null && node.right == null) {
            printPath(path);
        }

        // Traverse left and right subtrees
        printLeafToRoot(node.left, path);
        printLeafToRoot(node.right, path);

        // Backtrack: remove the current node from the path
        path.remove(path.size() - 1);
    }

    public static void printLeafToRootPaths(Node root) {
        List<Integer> path = new ArrayList<>();
        printLeafToRoot(root, path);
    }



    public static Node findNode(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }
        Node left = findNode(root.left, value);
        if (left != null) {
            return left;
        }
        return findNode(root.right, value);
    }
    public static boolean contains(Node root, Node node) {
        if (root == null)
            return false;
        if (root == node)
            return true;
        return contains(root.left, node) || contains(root.right, node);
    }
    private static Node findLCA(Node root, Node p, Node q) {
        // Base case: if root is null, return null
        if (root == null) {
            return null;
        }

        // If the current node is p or q, return it
        if (root == p || root == q) {
            return root;
        }

        // Recur for left and right subtrees
        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        // If both left and right are not null, p and q are in different subtrees, root
        // is the LCA
        if (left != null && right != null) {
            return root;
        }

        // If both are in the left or both are in the right subtree, return the non-null
        // node
        return left != null ? left : right;
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        // Check if both p and q are present in the tree
        if (!contains(root, p) || !contains(root, q)) {
            return null; // If either is not found, return null
        }
        // Now perform the LCA search
        return findLCA(root, p, q);
    }

    public static Node LCAinBST(Node root, Node p , Node q){
        if (root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        else if (root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        else return root;
    }
    public static void main(String[] args) {
        BinaryTrees tree = new BinaryTrees();
        int node[] = { 5, 2, 3, -1, -1, 4, -1, -1, 1, 6, -1, -1, 7, -1, -1 };
        // int node[]={1,2,-1,-1,3,-1,-1};
        Node root = tree.buildTrees(node);
        if (root != null) {
            System.out.println(root.val); // Prints the value of the root node
        } else {
            System.out.println("The tree is empty.");
        }

        // ! Ques : Balanced Binary Tree
        System.out.println("<=========Balanced Binary Tree===========>");
        isBalancedBTree(root);
        if (isBalancedBTree(root)) {
            System.out.println("Balanced tree");
        } else {
            System.out.println("Tree is not Balanced");
        }

        // ! Ques : Binary tree path root to leaf
        System.out.println("<=========Binary Tree Path root to leaf===========>");
        List<String> l = binaryTreePaths(root);
        System.out.println(l);
        // ! Ques : Binary tree path leaf to root
        System.out.println("<=========Binary Tree Path leaf to root===========>");
        printLeafToRootPaths(root);

        // ! Ques : Find Lowest Common Ancestor
        System.out.println("<=========Find Lowest Common Ancestor in BInary Tree============>");
        Node p = findNode(root, 5);
        Node q = findNode(root, 4);

        Node lca = lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println("Lowest Common Ancestor: " + lca.val);
        } else {
            System.out.println("Lowest Common Ancestor not found.");
        }


        System.out.println("<=========Find Lowest Common Ancestor in BSTree============>");
        Node LCAvalue= LCAinBST(root, p, q);
        System.out.println("Lowest common Ancessor in BST : "+LCAvalue.val);

    }
}
