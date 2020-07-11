import java.util.Stack;
// https://leetcode.com/problems/symmetric-tree/
public class symmetricTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // iterative approach

    // Time Complexity :O(n) -> number of elements
    // Space Complexity :O(n) -> for using stack
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    //
    // Your code here along with comments explaining your approach
    // 1. check if both left and right elements are present , if only one of them present return false
    // 2. check the above step for left node of  previous left node and right node of previous right node AND
    // 3. check step 1 for right node of previous left node and left node of previous right node . 
    // check if values of nodes are same , if not same return false. 
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(left == null && right == null)
                continue;
            if((left!=null && right == null) || (left == null && right!= null))
                return false;
            if(left.val!=right.val)
                return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    // recursive approach

    // Time Complexity :O(n) -> number of elements
    // Space Complexity :O(n) -> for using stack
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    
    public boolean isSymmetric2(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode left,TreeNode right){
        if(left == null && right == null)
            return true;
        if((left!=null && right == null) || (left == null && right!=null))
            return false;
        if(left.val != right.val)
            return false;
        boolean outside = helper(left.left,right.right);
        boolean inside = helper(left.right,right.left);
        return (outside && inside);
    }
}
