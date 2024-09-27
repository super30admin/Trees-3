/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* Recursive Algorithm:
    1. We are recursively comparing the left subtree and the right subtree.
    2. If at any point the left subtree is null or right subtree is null or values are not equal return false.
    3. If left subtree and the right subtree are null then we have reached a point where we know the tree is symmetrical till that point.
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Did the code run successfully on leetcode? Yes

*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return helper(root.left, root.right);
        
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null || left.val!=right.val)return false;
        return (helper(left.left, right.right) && helper(left.right,right.left));
}
}