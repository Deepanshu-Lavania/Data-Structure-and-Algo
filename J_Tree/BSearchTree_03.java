package J_Tree;

public class BSearchTree_03 {

    public static class Node{
        int val;
        Node leftNode;
        Node rightNode;

        Node(int val){//constructor
            this.val=val;
            this.leftNode=null;
            this.rightNode=null;
        }
    }
    public static class BSTree{
        public static Node insertNode(Node root , int data){
            if(root == null) {
                return new Node(data);
                // In your insertNode method, this line is used when root is null, meaning there is no node at that position in the tree. Therefore, a new node with the given data is created and returned, making it part of the tree
            }
            System.out.println("Root value is : " +root.val);
            if (data < root.val) {
                root.leftNode = insertNode(root.leftNode, data);
            } else {
                root.rightNode = insertNode(root.rightNode, data);
            }
            return root;
        }
        Node constructBST(int arr[]){
            Node root = null;
            for (int i = 0; i < arr.length; i++) {
                root = insertNode(root, arr[i]);
                System.out.println(root.val);//5
            }
            return root;
        }
    }
    public static void inorder(Node root){
        if (root==null) {
            return;
        }
        inorder(root.leftNode);
        System.out.print(root.val+" ");
        inorder(root.rightNode);
    }
    
    public static boolean searchKey(Node root , int key){
        if (root==null) {
            return false;
        }
        if(root.val> key){
           return searchKey(root.leftNode, key);
        }else if (root.val<key){
            return searchKey(root.rightNode, key);
        }else{
            return true;
        }
    }

    public static Node inorderSuccessor(Node root){
        while (root.leftNode!=null) {
            root= root.leftNode;
        }
        return root;

    }
    public static Node delete(Node root, int key){
        if (root==null) {
            return null;
        }
        if (root.val>key) {
            root.leftNode=delete(root.leftNode, key);
        }
        else if(root.val<key) {
            root.rightNode=delete(root.rightNode, key);
        }else{
            //caseI: delete leaf node
            if (root.rightNode==null && root.leftNode==null) {
                return null;
            }
            //caseII: delete node (ont leaf node)
            if (root.rightNode==null) {
                return root.rightNode;
            }else if(root.leftNode==null){
                return root.leftNode;
            }
            //case III : delete node(two child)
            Node IS = inorderSuccessor(root.rightNode);
            root.val= IS.val;//replace value
            root.rightNode=delete(root.rightNode,IS.val);//delete InorderSuccesor node
        }
        return root;
    }
    
    public static void printRangeNode(Node root, int x, int y){
        if (root==null) {
            return;
        }
        if (root.val>=x && root.val<=y) {
            printRangeNode(root.leftNode, x, y);
            System.out.print(root.val+" ");
            printRangeNode(root.rightNode, x, y);
        }
        else if (root.val<x) {
            printRangeNode(root.rightNode, x, y);
        }else{
            printRangeNode(root.leftNode, x, y);
        }
    }
    public static void main(String[] args) {
        BSTree bst = new BSTree();
        int arr[]={5,1,3,4,2,7};
        //! Ques : Insertion in BST
        System.out.println("<=====Build a new BST=========>");
        Node root = bst.constructBST(arr);
        System.out.println(root.val);
        //! Ques : Inorder Traversal in BST
        System.out.println("<========InOrder traversal in BST=======>");
        inorder(root);
        System.out.println();
        System.out.println("leftnode data of root node : " + root.leftNode.val);
        System.out.println("rightnode data of root node : " +root.rightNode.val);

        //! Ques : Search key in BST
        System.out.println("<=========Search key in BST==========>");
        if (searchKey(root, 3)) {
            System.out.println("key Found");
        }else{
            System.out.println("key not found");
        }


        //! Ques : Deletion in BST 
        System.out.println("<=====Deletion in BST=======>");
        delete(root,5);
        inorder(root);
        System.out.println();

        //! Ques : Print node in given range
        System.out.println("<=======Print values of nodes in given range=======>");
        printRangeNode(root,2,6);
    }
}
