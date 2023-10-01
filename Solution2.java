// Leetcode Problem : https://leetcode.com/problems/symmetric-tree/description/
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * If root.left and root.right are null I return true. Now I call the function check with parameters 
 * root.left and root.right. In the fn, if a and b are both null, I return true. If either one of them is
 * null, I return false. If a.val!=b.val, I return false. I recursively call the function 
 * check on a's left child and b's right child and on a's right child and b's left child.
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
        if(root.left==null && root.right==null)
        {
            return true;
        }
        return check(root.left,root.right);
    }

    public boolean check(TreeNode a , TreeNode b)
    {
        if(a==null || b==null)
        {
            if(a==null && b==null)
            {
                return true;
            }
            return false;
        }
        if(a.val!=b.val)
        {
            return false;
        }
        return check(a.left,b.right) && check(a.right,b.left);

    }
}