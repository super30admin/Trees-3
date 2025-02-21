// time complexity - O(n)
// space complexity - O(n)
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
    bool flag = true;
    public bool IsSymmetric(TreeNode root)
    {
        // helper(root.left, root.right);
        // return flag;
        // BFS
        if (root == null)
        {
            return true;
        }
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root.right);
        queue.Enqueue(root.left);

        while (queue.Count() > 0)
        {
            TreeNode right = queue.Dequeue();
            TreeNode left = queue.Dequeue();

            if (left == null && right == null)
            {
                continue;
            }

            if (left == null || right == null || left.val != right.val)
            {
                return false;
            }
            queue.Enqueue(right.right);
            queue.Enqueue(left.left);
            queue.Enqueue(right.left);
            queue.Enqueue(left.right);

        }
        return true;
    }

    // private void helper(TreeNode rootLeft,TreeNode rootRight)
    // {
    //     // base
    //     if(rootLeft == null && rootRight == null)
    //     {
    //         return;
    //     }

    //     //logic
    //     if(rootLeft == null || rootRight== null || rootLeft.val != rootRight.val)
    //     {
    //         flag = false;
    //     }

    //     if(flag)
    //     {
    //         helper(rootLeft.left,rootRight.right);
    //         helper(rootLeft.right,rootRight.left);
    //     }

    // }
}