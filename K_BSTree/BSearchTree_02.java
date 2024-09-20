package K_BSTree;

import javax.swing.tree.TreeNode;

public class BSearchTree_02 {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {// constructor
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class BSTree {
        public static Node insertNode(Node root, int data) {
            if (root == null) {
                /*
                 * Node temp =new Node(data);
                 * root=temp;
                 * return root;
                 */
                return new Node(data);
                // In your insertNode method, this line is used when root is null, meaning there
                // is no node at that position in the tree. Therefore, a new node with the given
                // data is created and returned, making it part of the tree
            }
            if (data < root.val) {
                root.left = insertNode(root.left, data);
            } else {
                root.right = insertNode(root.right, data);
            }
            return root;
        }

        Node constructBST(int arr[]) {
            Node root = null;
            for (int i = 0; i < arr.length; i++) {
                root = insertNode(root, arr[i]);
            }
            return root;
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

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }
    /*
     * public static Node delete(Node root, int key) {
     * if (root == null) {
     * return null;
     * }
     * if (root.val > key) {
     * root.left = delete(root.left, key);
     * } else if (root.val < key) {
     * root.right = delete(root.right, key);
     * } else {
     * // caseI: delete leaf node
     * if (root.right == null && root.left == null) {
     * return null;
     * }
     * // Case II: Delete a node with one child
     * if (root.left == null) {
     * return root.right; // Fix: Return the right child if left child is null
     * } else if (root.right == null) {
     * return root.left; // Fix: Return the left child if right child is null
     * }
     * 
     * // case III : delete node(two child)
     * Node IS = inorderSuccessor(root.right);
     * root.val = IS.val;// replace value
     * root.right = delete(root.right, IS.val);// delete InorderSuccesor node
     * }
     * return root;
     * }
     */

    public static void delete(Node root, int key) {
        if (root == null)
            return;
        if (root.val > key) {// go left
            if (root.left == null)
                return;
            if (root.left.val == key) {
                Node l = root.left;
                if (l.left == null && l.right == null) {// 0 child
                    root.left = null;
                } else if (l.left == null || l.right == null) {// 1 child in left subtree
                    if (l.left != null)
                        root.left = l.left;
                    else
                        root.left = l.right;
                } else {// 2 child
                    Node curr = l;
                    Node pred = curr.left;
                    while (pred.right != null)
                        pred = pred.right;
                    delete(root, pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.left = pred;
                }
            } else
                delete(root.left, key);
        } else {// go right
            if (root.right == null)
                return;
            if (root.right.val == key) {
                Node r = root.right;
                if (r.left == null && r.right == null) {// 0 child
                    root.right = null;
                } else if (r.left == null || r.right == null) {// 1 child in right subtree
                    if (r.left != null)
                        root.right = r.left;
                    else
                        root.right = r.right;
                } else {// 2
                    Node curr = r;
                    Node pred = curr.right;
                    while (pred.left != null)
                        pred = pred.left;
                    delete(root, pred.val);
                    pred.right = curr.right;
                    pred.left = curr.left;
                    root.right = pred;
                }
            } else
                delete(root.right, key);
        }
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null)
            return null;
        //To delete root node
        Node temp = new Node(Integer.MAX_VALUE);
        temp.left = root;
        delete(temp, key);
        return temp.left;
    }

    public static void main(String[] args) {
        BSTree bst = new BSTree();
        int arr[] = { 5, 1, 3, 4, 2, 7, 8 };
        // ! Ques : Insertion in BST
        System.out.println("<=====Build a new BST=========>");
        Node root = bst.constructBST(arr);
        System.out.println(root.val);
        inorder(root);
        System.out.println();
        System.out.println("<======Delete node=======>");
        // deleteNode(root, 5);//delete root node
        // deleteNode(root, 8);//delete leaf node
        // deleteNode(root, 7);//delete node which has one child
        deleteNode(root, 3);// delete which has two child
        inorder(root);
        
        
    }
}
