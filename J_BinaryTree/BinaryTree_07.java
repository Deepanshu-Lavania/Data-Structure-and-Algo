package J_BinaryTree;

import java.util.*;

public class BinaryTree_07 {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node constructBFS(String arr[]) {
        int x = Integer.parseInt(arr[0]);
        int n = arr.length;
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < n - 1) {
            Node temp = q.remove();// peek of Queue
            Node leftNode = new Node(10);
            Node rightNode = new Node(100);
            if (arr[i].equals("")) {
                leftNode = null;
            } else {
                int l = Integer.parseInt(arr[i]);
                leftNode.val = l;
                q.add(leftNode);
            }

            if (arr[i + 1].equals("")) {
                rightNode = null;
            } else {
                int r = Integer.parseInt(arr[i + 1]);
                rightNode.val = r;
                q.add(rightNode);
            }
            temp.left = leftNode;
            temp.right = rightNode;
            i += 2;
        }
        return root;
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void nthLevel(Node root, int n) {
        if (root == null) {
            return;
        }
        if (n == 1) {
            System.out.print(root.val + " ");
            ;
            return;
        }
        nthLevel(root.left, n - 1);
        nthLevel(root.right, n - 1);
    }

    public static boolean pathSumI(Node root, int targetSum){
        if (root==null) {
            return false;
        }
        if (root!=null && root.left==null && root.right==null) {
            if (root.val==targetSum) {
                return true;
            }
        }
        return pathSumI(root.left, targetSum-root.val) || pathSumI(root.right, targetSum-root.val);
    }


    public static void pathSumII(Node root,int sum ,List<Integer> sublist,List<List<Integer>> ans ){
        if (root==null) {
            return;
        }
        if(root.left==null && root.right==null){
            sublist.add(root.val);
            if (root.val==sum) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < sublist.size(); i++) {
                    list.add(sublist.get(i));
                }
                ans.add(list);
            }
            sublist.remove(sublist.size()-1);//backtracking
            return ;
        }
        sublist.add(root.val);
        pathSumII(root.left, sum-root.val, sublist, ans);
        pathSumII(root.right, sum-root.val, sublist, ans);
        sublist.remove(sublist.size()-1);//backtracking
    }
    public static int numOfPaths(Node root ,long sum){
        if(root==null) return 0;
        int path=0;
        if((long)(root.val)==sum) path++;
        return path+numOfPaths(root.left, sum-(long)(root.val))+numOfPaths(root.right, sum-(long)(root.val));
    }
    public static int pathSumIII(Node root, int targetSum) {
        if(root ==null) return 0;
        int count = numOfPaths(root, (long)targetSum);
        count = count+pathSumIII(root.left, targetSum)+pathSumIII(root.right, targetSum);
        return count;
    }
    public static void flattenTree(Node root){
        if(root==null) return;
        Node leftTree = root.left;
        Node rightTree=root.right;
        root.left=null;//change in original tree
        flattenTree(leftTree);
        flattenTree(rightTree);
        root.right=leftTree;
        //? till here , leftTree or rightTree is make flatten now you have to join both tree
        Node temp=leftTree;//To access last node of lefttree so that we can join rightTree with leftTree's last node
        while (temp!=null && temp.right!=null) { 
            temp=temp.right;
        }
        if(temp!=null){
            temp.right=rightTree;
        }else{
            root.right=rightTree;
        }
        return;
    }
    public static void flatten(Node root){
        Node curr =root;
        while (curr.right!=null) {
            if (curr.left!=null) {
                Node pred = curr.left;
                while (pred.right!=null) {
                    pred=pred.right;
                }
                pred.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }
    
    
    public static Node getNode(Node root, int start) {
        if (root == null)
            return null;
        if (root.val == start)
            return root;
        Node left = getNode(root.left, start);
        Node right = getNode(root.right, start);
        if (left == null)
            return right; // If the node is not found in the left subtree, return whatever is found in the
                          // right subtree (could be null or the node).
        else
            return left; // If the node is found in the left subtree, return it.
        // The last two lines are necessary to ensure that the function returns the
        // required node from the correct subtree. If you didn't include these, you
        // wouldn't be able to determine whether the node is in the left or right
        // subtree, and you might return the wrong result or null unnecessarily.
    }

    public static void preorder(Node root, Map<Node, Node> p) {
        if (root == null)
            return;
        if (root.left != null)
            p.put(root.left, root);
        if (root.right != null)
            p.put(root.right, root);
        preorder(root.left, p);
        preorder(root.right, p);
    }

    public static int amountOfTime(Node root, int start) {
        Node node = getNode(root, start);// start node =3
        Map<Node, Node> p = new HashMap<>();
        preorder(root, p);
        // bfs
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Node, Integer> v = new HashMap<>();// infected node data : node with level
        v.put(node, 0);// initialy 0 level add in map
        while (q.size() > 0) {
            Node temp = q.peek();
            int level = v.get(temp);
            // check leftnode
            if (temp.left != null && !v.containsKey(temp.left)) {
                q.add(temp.left);
                v.put(temp.left, level + 1);
            }
            // check rightnode
            if (temp.right != null && !v.containsKey(temp.right)) {
                q.add(temp.right);
                v.put(temp.right, level + 1);
            }
            // check parent
            if (p.containsKey(temp) && !v.containsKey(p.get(temp))) {// .get method of map return value corresponding to
                                                                     // key
                q.add(p.get(temp));
                v.put(p.get(temp), level + 1);
            }
            q.remove();
        }
        int max = -1;

        for (Integer value : v.values()) {//we can't apply normal loop in hashmap
            max = Math.max(max, value);
        }
        return max;
    }
    
    public static void main(String[] args) {
        // String arr[] = {"5", "4", "8", "11","","13","4", "7", "2","","", "5", "1"};
        String arr[]={"10","5","-3","3","2","","11","3","-2","","1"};
        Node root = constructBFS(arr);
        int level = height(root);
        for (int i = 0; i < level; i++) {
            nthLevel(root, i);
            System.out.println();
        }
        //! Ques : Path sum I, return true/false if those path root to leaf which are equal to targetSum
        System.out.println("<==========Path sum I==========>");
        System.out.println(pathSumI(root, 22));
        //! Ques : Path sum II, return those path root to leaf which are equal to targetSum in list to list form 
        System.out.println("<==========Path sum II==========>");
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> sublist=  new ArrayList<>();
        pathSumII(root, 22,sublist, ans);
        System.out.println(ans);
        //! Ques : Path sum III , return the number of path up to down which are eqaul to targetSum 
        System.out.println("<==========Path sum II==========>");
        System.out.println("Path sum is : "+pathSumIII(root,8)); 

        //! Ques : Given the root of a binary tree, flatten the tree into a "linked list/skewed tree" wihtout using extra space in different space complexity
        System.out.println("<============Given the root of a binary tree, flatten the tree into a linked list=========>");
        System.out.println("Right node of tree before flatten : "+root.right.val);
        // System.out.println("flatten tree with space complexity O(h)");
        // flattenTree(root);
        //? Time complexity : O(n) and Space Complexity : O(h) where h is the call stack frame max element in for tree
        System.out.println("flatten tree with space complexity O(1)");
        flatten(root);
        System.out.println("Right node of tree after flatten : "+root.right.val);

        //! Ques : Amount of Time for Binary Tree to Be Infected
        System.out.println("<=======Amount of Time for Binary Tree to Be Infected========>");
        System.out.println(amountOfTime(root,3));
    }
}
