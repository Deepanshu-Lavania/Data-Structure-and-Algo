package J_Tree;

public class BinaryTree_001 {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
        }
    }

    public static void inorder(Node root){
        if (root==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static int size(Node root){
        if (root==null) {
            return 0;
        }
        return size(root.left)+size(root.right)+1;
    }
    public static int maxNode(Node root){
        if (root ==null) {
            return Integer.MIN_VALUE;//so that it will work for -ve value also in tree
        }
        int a = root.val;
        int b = maxNode(root.left);
        int c=maxNode(root.right);

        return Math.max(a, Math.max(b, c));
        
    }

    public static int maxHigh(Node root){
        if (root == null) {
            return 0;
        }
        if (root.left==null && root.right==null) {
            return 0;
        }
        return Math.max(maxHigh(root.left), maxHigh(root.right))+1;
    }
    public static int minValue(Node root){
        if (root==null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.val,Math.min(minValue(root.left),minValue(root.right)));
    }
    public static int productValue(Node root){
        if (root==null) {
            return 1;
        }
        return productValue(root.left)*productValue(root.right)*root.val;
    }
    public static void main(String[] args) {
        Node root = new Node(-1);
        Node a = new Node(2);
        Node b=new Node(3);
        root.left=a;
        root.right=b;
        Node c = new Node(-4);
        Node d=new Node(5);
        a.left=c;
        a.right=d;
        Node e = new Node(6);
        Node f=new Node(-7);
        b.left=e;
        b.right=f;
        System.out.println("<======Inorder Traversal=======>");
        inorder(root);
        System.out.println();
        //! Ques : Size of the tree
        System.out.println("<========Size of the tree=======>");
        System.out.println(size(root));

        //! Ques : max Value in tree
        System.out.println("<======Maximem Node Value=======>");
        System.out.println(maxNode(root));

        //! Ques : max height according to edgeWise 
       System.out.println("<=====Maximum height according to edges=====>");
        System.out.println( maxHigh(root));

        //! Ques : Min value of the tree
        System.out.println("<======Minimum Value in tree=======>");
        System.out.println(minValue(root));

        //! Ques : Product value of the tree
        System.out.println("<======Product of Value in tree=======>");
        System.out.println(productValue(root));        
    }
}
