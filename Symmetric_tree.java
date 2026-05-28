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
 // Time Complexity = O(n)
 // Space Complexity = O(n)
 // using level order traversal - 
 /*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left==null && right==null) continue;
            if(left==null || right== null) return false;
            if(left.val!=right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
*/
 // Time Complexity = O(n)
 // Space Complexity = O(h)
 // using recursion - 
class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        this.flag = true;
        helper(root.left, root.right);
        return flag;
    }
    private void helper(TreeNode left, TreeNode right){
        if(left==null && right==null) return;
        if(left==null || right== null){
            flag = false;
            return;
        } 
        if(left.val!=right.val){
            flag = false;
        }
        if(flag) helper(left.left,right.right);
        if(flag) helper(left.right,right.left);
    }
}