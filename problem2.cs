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
    public bool IsSymmetric(TreeNode root) {
        Queue<TreeNode> q = new Queue<TreeNode>();
        if(root == null) return false;
        q.Enqueue(root.left);
        q.Enqueue(root.right);
        while(q.Count>0)
        {
            TreeNode left = q.Dequeue();
            TreeNode right = q.Dequeue();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            q.Enqueue(left.left);
            q.Enqueue(right.right);
            q.Enqueue(left.right);
            q.Enqueue(right.left);

        }
        return true;
    }
}