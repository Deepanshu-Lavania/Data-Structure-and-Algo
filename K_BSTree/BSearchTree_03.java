package K_BSTree;



public class BSearchTree_03 {
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

    // public static int sum=0; //?Instead of Global variable, use object / data stucture for variable
    public static Node convertBST(Node root,int sum[]){
        if(root==null) return null;
        convertBST(root.right, sum);
        root.val = root.val+sum[0];
        sum[0]=root.val;
        convertBST(root.left, sum);
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

        //! Ques : Convert BST into greater tree
        System.out.println("<========= Convert BST inot greater tree==========>");
        int sum[]={0};
        convertBST(root,sum);
        inorder(root);
        
        
    }
}
