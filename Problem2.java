// Time Complexity : o(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using recursion check for the left and right nodes in pair
//Return Not symmetric when the left value is not equal to right value or either the left or right node is null
//Check recursively for lefts left node to be equal to rights right node and lefts right node to be equal to rights left
//recursion ends when both left and right is null
 //using recursion
 class Solution {
    boolean toReturn = true;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        dfs(root.left, root.right);
        return toReturn;
    }

    private void dfs(TreeNode left, TreeNode right) {
        //base
        if (left == null && right == null) return;
        //logic
        //either of node left and right is null or nodes values are diff then it is non symmetric
        if (left==null || right == null || left.val != right.val) {
            toReturn = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);

    }
}
