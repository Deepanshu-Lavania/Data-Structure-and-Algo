package K_BSTree;

public class BSearchTree_02 {
    public static class Node {
        int val;
        Node leftNode;
        Node rightNode;

        Node(int val) {// constructor
            this.val = val;
            this.leftNode = null;
            this.rightNode = null;
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
                root.leftNode = insertNode(root.leftNode, data);
            } else {
                root.rightNode = insertNode(root.rightNode, data);
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
        inorder(root.leftNode);
        System.out.print(root.val + " ");
        inorder(root.rightNode);
    }

    public static Node inorderSuccessor(Node root) {
        while (root.leftNode != null) {
            root = root.leftNode;
        }
        return root;

    }

    public static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.leftNode = delete(root.leftNode, key);
        } else if (root.val < key) {
            root.rightNode = delete(root.rightNode, key);
        } else {
            // caseI: delete leaf node
            if (root.rightNode == null && root.leftNode == null) {
                return null;
            }
            // Case II: Delete a node with one child
            if (root.leftNode == null) {
                return root.rightNode; // Fix: Return the right child if left child is null
            } else if (root.rightNode == null) {
                return root.leftNode; // Fix: Return the left child if right child is null
            }

            // case III : delete node(two child)
            Node IS = inorderSuccessor(root.rightNode);
            root.val = IS.val;// replace value
            root.rightNode = delete(root.rightNode, IS.val);// delete InorderSuccesor node
        }
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
        System.out.println("<======Delete node=======>");
        delete(root, 5);//delete root node
        // delete(root, 8);//delete leaf node
        // delete(root, 7);//delete node which has one child
        // delete(root, 3);//delete which has two child
        inorder(root);
    }
}
