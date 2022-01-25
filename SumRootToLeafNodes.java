// Time Complexity : O(n)
// Space Complexity : O(h) , h is height of tree, worst case h = n, n - nodes in tree
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

class SumRootToLeafNodes{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair {

        TreeNode node;
        int value;

        public Pair(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumLeafNodes(root, 0);
        return sum;
    }

    private void sumLeafNodes(TreeNode root, int currNum){
        //base
        if(root == null) return;

        if(root.left == null && root.right == null){
            sum+= currNum *10 + root.val;
            return;
        }
        //logic
        sumLeafNodes(root.left, currNum * 10 + root.val);
        //st.pop internally
        sumLeafNodes(root.right, currNum * 10 + root.val);
    }

    public int sumNumbersIteratively(TreeNode root){
        int sum = 0;
        int currNum = 0;
        Stack<Pair> st = new Stack<>();

        while(root != null || !st.isEmpty()){
            //inorder traversal
            while (root != null){
                currNum = currNum * 10 + root.val;
                Pair p = new Pair(root ,currNum);
                st.push(p);
                root = root.left;
            }
            //st.pop() happens internally in recursive solution
            Pair p = st.pop();
            root = p.getNode();
            currNum = p.getValue();
            //process the leaf node
            if(root.left == null && root.right == null){
                sum += currNum;
            }
            root = root.right;
        }
        return sum;
    }

    public static void main(String[] args) {

        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t9 = new TreeNode(9, t5, t1);
        TreeNode t0 = new TreeNode(0, null, null);
        TreeNode t4 = new TreeNode(4, t9, t0);

        System.out.println("Path Sum : " + new SumRootToLeafNodes().sumNumbers(t4));
        System.out.println("Path Sum Iteratively: " + new SumRootToLeafNodes().sumNumbersIteratively(t4));

    }
}