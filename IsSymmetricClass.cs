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
public class Solution
{
    public bool IsSymmetric(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        return CheckTree(root.left, root.right);
    }

    public bool CheckTree(TreeNode left, TreeNode right)
    {
        if (left == null && right == null)
        {
            return true;
        }
        if (left == null || right == null)
        {
            return false;
        }
        if (left.val != right.val)
        {
            return false;
        }

        return CheckTree(left.left, right.right) && CheckTree(left.right, right.left);
    }
}