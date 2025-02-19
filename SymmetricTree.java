// Time complexity:- 0(n)
// Space complexity:- 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach: 
 * In this problem I have to check the tree is Symmetric or not. 
 * The approach checks if the tree is symmetric by comparing the left and right parts of the tree. 
 * If both sides are empty, they are symmetric, but if one side is empty and the other is not, it’s not symmetric.
 * It compares the node values and then looks at their children.
 */ 

 class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {

            TreeNode left = queue.remove();
            TreeNode right = queue.remove();

            if(left == null && right == null) {
                continue;
            }

            if(left == null || right == null) {
                return false;
            }

            if(left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }
}