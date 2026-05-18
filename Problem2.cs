// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I perform DFS on the left and right child of the root node. In the helper function, if either of the nodes are null I return false. If both are null, I return true. If the 
value of the first node is not equal to that of the second node, I return false. Then I recursively perform the check on the left child of the first node and right child of the
second node and the right child of the first node and left child of the second node.

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
public class Solution
{
    public bool IsSymmetric(TreeNode root)
    {
        return Helper(root.left, root.right);
    }

    public bool Helper(TreeNode a, TreeNode b)
    {
        if (a == null || b == null)
        {
            if (a == null && b == null)
            {
                return true;
            }

            else
            {
                return false;
            }
        }

        if (a.val != b.val)
        {
            return false;
        }

        return Helper(a.left, b.right) && Helper(a.right, b.left);
    }
}