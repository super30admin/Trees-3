// Time Complexity : O(n) where m=no. of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree ie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * We will be using recursive technique to solve the problem
 * Idea is we will be comparing the left node of the root node left sub tress with the right node of the
 * root node right sub tree
 * */


import java.util.Stack;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left, root.right);

    }

    private boolean helper(TreeNode left, TreeNode right) {

        if(left==null && right==null) return true;

        if(left==null || right==null || left.val!=right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    //using recursive stack
    public boolean isSymmetricUsingStack(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();

            if(n1==null && n2==null) continue;

            if(n1==null || n2==null || n1.val!=n2.val) return false;

            stack.push(n2.left);
            stack.push(n1.right);
            stack.push(n2.right);
            stack.push(n1.left);
        }
        return true;
    }
}


