package Trees-3;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class problem2 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return helper(root.left, root.right);
        }
        
        public boolean helper(TreeNode p1, TreeNode p2){
            if(p1 == null && p2 == null) return true;
            if(p1 == null || p2 == null) return false;
            if(p1.val != p2.val) return false;
            
            boolean left = helper(p1.left,p2.right);
            boolean right = helper(p1.right,p2.left);
            
            return left && right;
        }
    }
}
