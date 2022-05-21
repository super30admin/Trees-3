// Time Complexity : O(n)
// Space Complexity : O(h) for recursive
// Did this code successfully run on Leetcode :  YES
// Any problem you faced while coding this : NO


import java.util.Stack;

public class SymmetricTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if((left == null && right != null) || (left != null && right == null) || (left.val != right.val)) return false;
        if(!helper(left.left, right.right)) return false;
        if(!helper(left.right, right.left)) return false;
        return true;
    }
    
    private boolean helperRecursive(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        stackLeft.push(root.left);
        stackRight.push(root.right);
        TreeNode left;
        TreeNode right;
        while(!stackLeft.isEmpty() && !stackRight.isEmpty()){
            left = stackLeft.pop();
            right = stackRight.pop();
            if(left == null && right == null) continue;
            if((left == null && right != null) || (left != null && right == null) || (left.val != right.val)) return false;
            stackLeft.push(left.left);
            stackRight.push(right.right);
            stackLeft.push(left.right);
            stackRight.push(right.left);
        }
        if(!stackLeft.isEmpty() || !stackRight.isEmpty()) return false;
        return true;
    }
    
}