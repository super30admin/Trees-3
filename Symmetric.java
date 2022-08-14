
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return helper(root.left,root.right);
        
       /*TreeNode left = null;
       TreeNode right = null;
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root.left);
       queue.add(root.right);
        
        while(!queue.isEmpty()){
            left = queue.remove();
            right =queue.remove();
            if(left != null && right != null){
                if(left.val != right.val)
                    return false;

                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }
            else if(left != null || right != null)
                return false;
            
        }
        
        return true;*/
    }
    public boolean helper(TreeNode left,TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        return (left.val == right.val) && helper(left.left,right.right) && helper(left.right,right.left);
    }
    
}
