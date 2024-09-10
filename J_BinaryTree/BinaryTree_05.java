package J_BinaryTree;


public class BinaryTree_05 {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static class BinaryTrees{
        static int idx=-1;
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
   

    public static Node invertTree(Node root) {
        if(root ==null) return root;
        Node leftSub = invertTree(root.left);
        Node rightSub =invertTree(root.right);
        // Swap the left and right subtrees
        root.left = rightSub;
        root.right = leftSub;
        return root;
    }
    
    public static boolean isSameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true; // Both are null
        if (root1 == null || root2 == null) return false; // One is null
        if (root1.val != root2.val) return false; // Values are different
        // Recursively compare left and right subtrees
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    public static boolean isSymmetric(Node root) {
        if(root==null) return true;
        return isSameTree(root.left, invertTree(root.right));
    }
    public static void main(String[] args) {
        BinaryTrees tree = new BinaryTrees();
        // int node[] = { 5, 2, 3, -1, -1, 4, -1, -1, 1, 6, -1, -1, 7, -1, -1 };
            // int node[]={1,2,-1,-1,3,-1,-1};
        int node[] = {1,2,3,-1,-1,4,-1,-1,2,4,-1,-1,3,-1,-1};
        Node root = tree.buildTrees(node);
        if (root != null) {
            System.out.println(root.val +" root.left "+root.left.val +" && root.right "+root.right.val); // Prints the value of the root node
        } else {
            System.out.println("The tree is empty."); 
        }
        //! Ques: Invert Binary Tree (Mirror Image)
        System.out.println("<======Invert Binary Tree (Mirror Image)======>");
        invertTree(root);
        System.out.print("After Invert Binary tree : ");
        System.out.println(root.val +" root.left "+root.left.val +" && root.right "+root.right.val);

        //! Quse : check Symmetric tree
        if(isSymmetric(root)){
            System.out.println("Tree is Symmetric");
        }else{
            System.out.println("Tree is not Symmetric");
        }

    }
}
