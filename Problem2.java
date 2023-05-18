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

//  Time: O(n)
// Space: O(h)
class Solution {
    public boolean isSymmetric(TreeNode root) {

        return check( root.left , root.right);
        
    }

    public boolean check(TreeNode left, TreeNode right){
        //base
        if(left == null || right == null)
            return left == right;

        //condition
        if(left.val!= right.val)
            return false;

        return check(left.left, right.right) && check(left.right , right.left);

    }
}