//Time Complexity: O(N)
//Space Complexity: O(h) //height of the tree
//Leetcode: yes
public class SymetricTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    class Solution {
        public boolean isSymmetric(TreeNode root) {

            if (root == null) {
                return true;
            }

            return helper(root.left, root.right);

        }

        public boolean helper(TreeNode left, TreeNode right) {

            if (right == null && left == null) {
                return true;
            }
            if ((right != null && left == null) || (right == null && left != null) || right.val != left.val) {
                return false;
            }

            return helper(left.left, right.right) && helper(left.right, right.left);

        }
    }
}
