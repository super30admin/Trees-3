/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        while(!stack.isEmpty()){
            TreeNode one =stack.pop();
            TreeNode two =stack.pop();
            if(one==null && two == null) continue;
            if(one == null || two == null || one.val != two.val) return false;
            stack.push(one.left);
            stack.push(two.right);
            stack.push(one.right);
            stack.push(two.left);
            
        }
        return true;
    }

}