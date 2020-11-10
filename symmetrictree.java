/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//A tree is symmetric if the left subtree is a mirror reflection of the right subtree.
//Time Complexity : O(N)
//Space Complexity : O(N)
class Solution {
    public boolean isSymmetric(TreeNode root) {

        return isMirror(root,root);
    }
    // so we divided the tree into two subtrees called t1 and t2.
    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1== null && t2== null)
            return true;
        if(t1== null || t2== null)
            return false;

        return (t1.val == t2.val)
                && isMirror(t1.right,t2.left) &&isMirror(t1.left,t2.right);

    }
        