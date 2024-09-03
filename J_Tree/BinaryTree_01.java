package J_Tree;
import java.util.*;

public class BinaryTree_01 {
    public static class Node{
        Node leftNode;
        Node rightNode;
        int val;
    
        Node(int val){
            this.val=val;
            this.leftNode=null;
            this.rightNode=null;
        }
    }
    public static class BinaryTree{
        static int idx=-1;
        Node buildTree(int node[]){
            idx++;
            if (node[idx]==-1) {
                return null;
            }
            
            Node newNode = new Node(node[idx]);
            newNode.leftNode= buildTree(node);
            newNode.rightNode=buildTree(node);
            // Encountering firstOccurance of  -1:
            // idx = 3, node[idx] = -1.
            // Since it's -1, the function returns null.
            // This means node 3 (left child of 1) has no left child. The recursion does not continue further down this left subtree.
            // After returning null, the code resumes and now builds the right subtree of node 3

            return newNode;
        }
    }

    public static void preorder(Node root){
        if (root == null) {
            System.out.print(-1+" ");
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.leftNode);
        preorder(root.rightNode);
    }
    public static void inOrder(Node root){
        if (root == null) {
            System.out.print(-1+" ");
            return;
        }
        preorder(root.leftNode);
        System.out.print(root.val+" ");
        preorder(root.rightNode);
    }
    public static void postOrder(Node root){
        if (root == null) {
            System.out.print(-1+" ");
            return;
        }
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        System.out.print(root.val+" ");
    }
    public static void levelOrder(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curNode = q.remove();
            if(curNode==null){
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curNode.val+" ");
                if (curNode.leftNode!=null) {
                    q.add(curNode.leftNode);
                }
                if(curNode.rightNode!=null){
                    q.add(curNode.rightNode);
                }
            }
        }
        
    }

    public static int countNode(Node root){
        if (root==null) {
            return 0;
        }
        int leftnodes =countNode(root.leftNode);
        int rightnodes = countNode(root.rightNode);
        
        return leftnodes+rightnodes+1;
    }

    public static  int sumNodes(Node root){
        if (root==null) {
            return 0;
        }
        int leftnodes =sumNodes(root.leftNode);
        int rightnodes = sumNodes(root.rightNode);
        
        return leftnodes+rightnodes+root.val;
    }

    public static void main(String[] args) {
        //! Ques : Build the Binary tree Preorder
        System.out.println("<=====Build the Binary tree Preorder=====>");
        int nodes[]={2,1,3,-1,-1,5,-1,-1,8,-1,6,-1,-1};
/*         //*Building the Left Subtree of Node 2 (Steps Already Covered):
idx = 1: Create Node 1.
idx = 2: Create Node 3 (left child of Node 1).
idx = 3: Encounter -1, set Node 3's left child to null.
idx = 4: Encounter -1, set Node 3's right child to null.
Return Node 3 to Node 1 as its left child.
idx = 5: Create Node 5 (right child of Node 1).
idx = 6: Encounter -1, set Node 5's left child to null.
idx = 7: Encounter -1, set Node 5's right child to null.
Return Node 5 to Node 1 as its right child.
          //*Building the Right Subtree of Node 2 (This is Key):
After completing the left subtree for Node 2 (which includes Node 1 and its children 3 and 5):
idx = 8: Create Node 3 (right child of Node 2).
idx = 9: Encounter -1, set Node 3's left child to null.
idx = 10: Create Node 6 (right child of this Node 3).
idx = 11: Encounter -1, set Node 6's left child to null.
idx = 12: Encounter -1, set Node 6's right child to null.
Return Node 6 to Node 3 as its right child.
Return Node 3 to Node 2 as its right child. */
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("The root node of the Binary Tree is : "+root.val);

        //! Ques : Preorder Traversal : Root ,Left Subtree , Right Subtree
        System.out.println("<=====Preorder Traversal=====>");
        preorder(root);

        //! Ques : Inorder Traversal :Left, Root Subtree , Right Subtree
        System.out.println();
        System.out.println("<=====Preorder Traversal=====>");
        inOrder(root);
        //! Ques : PostOrder Traversal :Left,  Right Subtree,Root Subtree 
        System.out.println();
        System.out.println("<=====Postorder Traversal=====>");
        postOrder(root);
        //! Ques : LevelOrder Traversal :Left,  Right Subtree,Root Subtree 
        System.out.println();
        System.out.println("<=====Levelorder Traversal=====>");
        levelOrder(root);

        System.out.println("<=====Number of Nodes=====>");
        System.out.println("Number of nodes are : "+countNode(root));

        System.out.println("<=====Sum of Nodes ======>");
        System.out.println("Sum of nodes are : "+sumNodes(root));
        // sumNodes(root);
    }
}
