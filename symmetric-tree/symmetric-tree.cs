/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsSymmetric(TreeNode root) {
        Queue<TreeNode> q = new Queue<TreeNode>();
        q.Enqueue(root);
        q.Enqueue(root);
        while(q.Count>0)
        {
            TreeNode n1 = q.Dequeue();
            TreeNode n2 = q.Dequeue();
            
            if(n1==null && n2 ==null) continue;
            if(n1==null || n2==null) return false;
            if(n1.val != n2.val) return false;
            q.Enqueue(n1.left);
            q.Enqueue(n2.right);
            q.Enqueue(n1.right);
            q.Enqueue(n2.left);
        }
        return true;
        
    }
}
