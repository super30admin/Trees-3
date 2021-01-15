/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
    // public boolean isSymmetric(TreeNode root) {
    //     return isMirror(root, root);
    //     }
    // public boolean isMirror(TreeNode t1, TreeNode t2)
    // {
    //     if ( t1 == null && t2 == null) return true;
    //     if ( t1 == null || t2 == null) return false;
    //     return ( t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right,t2.left);
    // }
    class Solution {
     public boolean isSymmetric(TreeNode root) {
         Queue<TreeNode> q = new LinkedList<TreeNode>();
         q.add(root);
         q.add(root);
         while ( !q.isEmpty())
         {
             TreeNode t1 = q.poll();
             TreeNode t2 = q.poll();
             if ( t1 == null && t2 == null) continue;
             if ( t1 == null || t2 == null) return false;
             if ( t1.val != t2.val) return false;
             q.add(t1.left);
             q.add(t2.right);
             q.add(t2.left);
             q.add(t1.right);
         }
         return true;
     }        
}
