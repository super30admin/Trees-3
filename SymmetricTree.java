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
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// class Solution {
//     boolean isValid;
//     public boolean isSymmetric(TreeNode root) {
//         if(root == null)
//             return true;
        
//         isValid = true;
        
//         dfs(root.left, root.right);
        
//         return isValid;        
//     }
    
//     private void dfs(TreeNode left, TreeNode right){
//         if(left == null && right == null)
//             return;
//         if(left == null || right == null || left.val != right.val){
//             isValid = false;
//             return;
//         }
        
//         if(isValid){
//             dfs(left.left, right.right);
//             dfs(left.right, right.left);
//         }
//     }
// }

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
