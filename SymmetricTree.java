// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
The intuition is to compare 2 nodes at a time:
1. left.left with right.right
2. left.right with right.left

if they are not same, return false.
Note: Keep track of null checks for both left and right before returning.
*/

public class SymmetricTree {

    public class TreeNode {
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

    Boolean flag;
    public boolean isSymmetric(TreeNode root) {
        //iterative
        /*if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(left == null && right==null) continue;
            if(left == null || right == null || left.val != right.val) {
                return false;
            }
            stack.add(left.left);
            stack.add(right.right);
            stack.add(left.right);
            stack.add(right.left);
        }
        return true;*/

        //recursive
        flag = true;
        if(root == null) return flag;
        helper(root.left, root.right);
        return flag;
    }

    // recursive
    private void helper(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return;
        if(left == null || right == null || left.val != right.val) {
            flag=false;
            return;
        }
        //logic
        helper(left.left, right.right);

        helper(left.right, right.left);
    }
}
