// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
    Approach used - passed nodes in a function which are to be same
 */

public class MirrorTree {

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
        boolean flag = true;
        public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;

            checkNode(root, root);
            return flag;
        }
        private void checkNode(TreeNode rootLeft, TreeNode rootRight) {
            if( flag == false) return ;
            if(rootLeft == null && rootRight != null)
            {
                flag = false;
                return;
            }
            else if(rootLeft != null && rootRight == null)
            {

                flag = false;
                return;
            }
            if(rootLeft != null && rootRight!=null){
                if(rootLeft.val == rootRight.val) {
                    checkNode(rootLeft.left, rootRight.right);
                    checkNode(rootLeft.right , rootRight.left);
                }
                else{
                    flag = false;
                }
            }

        }
    }
}
