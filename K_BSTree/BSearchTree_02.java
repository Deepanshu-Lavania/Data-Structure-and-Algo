package K_BSTree;

import java.util.*;

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
        // To delete root node
        Node temp = new Node(Integer.MAX_VALUE);
        temp.left = root;
        delete(temp, key);
        return temp.left;
    }

    // ? Approch 1:
    public static void findSucPre(List<Integer> list, int key) {
        if (list.get(0) == key) {
            System.out.println("Precessor is : " + null + " & Successor is : " + list.get(1));
            return;
        } else if (list.get(list.size() - 1) == key) {
            System.out.println("Precessor is : " + (list.size() - 2) + " & Successor is : " + null);
            return;
        } else {
            boolean flag = false;
            for (int i = 1; i < list.size() - 1; i++) {
                if (list.get(i) == key) {
                    flag = true;
                    System.out.println("Precessor is : " + list.get(i - 1) + " & Successor is : " + list.get(i + 1));
                    return;
                }
            }
            if (!flag) {
                System.out.println("Enter the correct key to find Suc and Pre ");
                return;
            }
        }

    }

    public static void FindPSApp1(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        FindPSApp1(root.left, list);
        list.add(root.val);
        FindPSApp1(root.right, list);
    }

    // ? Approch 2:
    // * */ If you use int instead of Integer, you cannot assign null to int because
    // it's a primitive type. The int type must always hold some numeric value,
    // which makes it hard to represent the absence of a value (like no
    // predecessor). Using Integer solves this issue by allowing us to work with
    // null.
    static Integer pred = null, suc = null; // Using Integer to handle null values
    static Node temp = null;

    public static void FindPSApp2(Node root, int key) {
        if (root == null) {
            return;
        }
        FindPSApp2(root.left, key);
        // Work logic for predecessor and successor
        if (root.val == key) {
            // Predecessor is the last node visited before the current one
            if (temp != null) {
                pred = temp.val; // Set predecessor to the value of temp
            }

            // Flag is not needed as we'll handle the successor after this node
        } else if (root.val > key && suc == null) {
            // First node greater than key is the successor
            suc = root.val;
        }

        // Update temp to current node after checking conditions

        if (temp == null) {
            System.out.println("temp is null");
        }
        temp = root;// temp will be one step ahead for precessor due to start with leaf node
        System.out.print(temp.val + " ");

        // Traverse the right subtree
        FindPSApp2(root.right, key);
    }

    public static class State {
        Node temp = null;
        boolean flag = true;
    }

    public static void inorder(Node root, State state) {// Type variable
        if (root == null || !state.flag)
            return;

        inorder(root.left, state);
        if (state.temp != null && root.val <= state.temp.val) {
            state.flag = false;
            return;
        }

        // Update temp to current root
        state.temp = root;

        inorder(root.right, state);
    }

    public static boolean isValidBST(Node root) {
        State state = new State();

        inorder(root, state);
        return state.flag;
    }

    public static Node consBstArr(int arr[], int low, int hi) {
        if (low > hi)
            return null;
        int mid = low + (hi - low) / 2;
        Node root = new Node(arr[mid]);
        root.left = consBstArr(arr, low, mid - 1);
        root.right = consBstArr(arr, mid + 1, hi);
        return root;
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
        // ! Ques :Deletion in BST using precessor
        System.out.println("<======Delete node=======>");
        // deleteNode(root, 5);//delete root node
        // deleteNode(root, 8);//delete leaf node
        // deleteNode(root, 7);//delete node which has one child
        // deleteNode(root, 3);// delete which has two child
        inorder(root);
        System.out.println();

        // ! Ques : Find precessor and successor in BST
        // ? Approch 1 : using inorder traversal and arraylist
        System.out.println("<=======Find precessor and successor in BST using extra space =========>");
        List<Integer> list = new ArrayList<>();
        FindPSApp1(root, list);
        findSucPre(list, 8);
        // ?Aproch 2: using inroder traversal only
        System.out.println("<=======Find precessor and successor in BST without using extra space =========>");
        FindPSApp2(root, 8);
        System.out.println("precessor is : " + pred + " & Successor is : " + suc);

        // ! Ques : Validate BST without using global variable
        System.out.println("<===========Validate Binary Search Tree============>");
        System.out.println(isValidBST(root));

        // ! Ques : Construct BST using sorted array [leetcode -108]
        System.out.println("<=======Construct BST using sorted array=========>");
        int bstArr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int low = 0;
        int high = bstArr.length - 1;
        System.out.println(consBstArr(bstArr, low, high).val);
    }
}
