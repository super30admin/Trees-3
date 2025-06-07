/*
  Time complexity: O(n)
  Space complexity: O(h)
  
  Code ran successfully on leetcode: Yes

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    bool flag;
    public bool IsSymmetric(TreeNode root) {
        flag = true;
        if(root==null)
            return flag;

        helper(root.left, root.right);
        return flag;
    }

    private void helper(TreeNode left, TreeNode right)
    {
        if(left==null && right==null) 
        {
            return;
        }
        if(left==null || right==null)
        {
            flag = false;
            return;
        }
        if(left.val!=right.val)
        {
            flag = false;
            return;
        }
        helper(left.left,right.right);
        helper(right.left, left.right);
    }
}
