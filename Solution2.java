// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I recursively call the helper function check on left and right child of root(p & q). If either of the children is null, I return p==q.
 * Then I check if p.val == q.val. If not I return false. Else I recursively call check on p.left & q.right and p.right & q.left.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }

    public boolean check(TreeNode p, TreeNode q)
    {
        if(p==null || q==null)
        {
            return p==q;
        }
        if(p.val!=q.val)
        {
            return false;
        }
        return check(p.left,q.right) && check(p.right,q.left);
    }
}