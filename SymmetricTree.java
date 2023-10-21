// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Node

public class SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {

            return helper(root, root);
        }

        public boolean helper(TreeNode root1, TreeNode root2){

            if(root1==null && root2==null)
                return true;

            if(root1 != null && root2 != null && (root1.val == root2.val)){
                return(helper(root1.left,root2.right) && helper(root1.right,root2.left));
            }

            return false;
        }
    }
}
