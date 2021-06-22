//Time complextity - O(n)
//Space complexity - O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



/ * Definition for a binary tree node.
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
         return isMirrorTree(root, root);
    }
    public boolean isMirrorTree(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    
    isMirrorTree(t1.right, t2.left);
    isMirrorTree(t1.left, t2.right);
    return (t1.val == t2.val)
        && isMirrorTree(t1.right, t2.left)
        && isMirrorTree(t1.left, t2.right);
    
  }
}


