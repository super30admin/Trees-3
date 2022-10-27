// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

public class Symmetric {
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
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root.left, root.right);
        }
        private boolean isSymmetric(TreeNode main, TreeNode image){

            if(main == null && image == null){
                return true;
            }
            if(main == null || image == null || main.val != image.val){
                return false;
            }

            return isSymmetric(main.left, image.right) &&
                    isSymmetric(main.right, image.left);
        }
    }