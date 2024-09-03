package J_Tree;

public class BinaryTree_02 {
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
    public static void inOrder(Node root){
        if (root == null) {
            System.out.print(-1+" ");
            return;
        }
        inOrder(root.leftNode);
        System.out.print(root.val+" ");
        inOrder(root.rightNode);
    }

    public static void main(String[] args) {
        BinaryTrees tree = new BinaryTrees();
        int node[] = {1, 2, 3, -1, -1, 4, 5, -1, 6, -1, -1, 7, 8, -1, -1, 9, -1, -1};

        Node root = tree.buildTrees(node);
        if (root != null) {
            System.out.println(root.val); // Prints the value of the root node
        } else {
            System.out.println("The tree is empty.");
        }
        //! Ques : Inorder Traversal :Left, Root Subtree , Right Subtree
        System.out.println();
        System.out.println("<=====Preorder Traversal=====>");
        inOrder(root);
    }
    
}
