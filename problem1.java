// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no

/*
we are doing the preorder DFS
we are itterating over left and the right child nodes at the same it, if
both are empty we have reached the depth of the tree

and if one of the value is null or not equal we turn the flag false and return

in the end if we return value of flag

the travesal
            1
        2           2
    3       4   4       3
using left.left = 3, right.right = 3
left.right = 4, right.left = 4

*/

class Solution {
    boolean flag;

    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        dfs(root.left, root.right);
        return flag;
    }

    private void dfs(TreeNode left, TreeNode right) {
        // base
        if (left == null && right == null)
            return;

        // logic
        if (left == null || right == null || left.val != right.val) {
            flag = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}