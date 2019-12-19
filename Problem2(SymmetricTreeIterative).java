/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* Iterative Algorithm:
    1. We are iteratively comparing the left subtree and the right subtree.
    By pushing left of left and right of right then right of left and left of right into stack.
    2. If at any point the left subtree is null or right subtree is null or values are not equal return false.
    3. If left subtree and the right subtree are null then we have reached a point where we know the tree is symmetrical till that point.
    
    Time Complexity: O(n)
    Space Complexity: O(Height)
    
    Did the code run successfully on leetcode? Yes
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        
        while(!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(right==null && left==null)
                continue;
            if(right==null || left==null || right.val!=left.val)
                return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }
}