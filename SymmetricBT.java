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
//TimeComplexity:O(N) Traversing each node
//SpaceComplexity:O(N) Recurrsive Stack
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }
    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null)
            return true;
        if(t1==null || t2==null)
            return false;
        return (t1.val==t2.val)
                && isSymmetric(t1.left,t2.right)
                && isSymmetric(t2.left,t1.right);
    }
}