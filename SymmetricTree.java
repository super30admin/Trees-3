import javax.swing.tree.TreeNode;

// Time Complexity :O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//Use recrusion and pass two copies of root to recursive function and check that the root and left and right child of
// both copies are equal.
public class SymmetricTree {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        private boolean isMirror(TreeNode root1, TreeNode root2){
            //base cases to return true it both roots are equal to null else return false
            if(root1 == null && root2 == null) return true;
            if(root1 == null || root2 == null) return false;

            //check if values of both names are the same and if the left and right are also the same
            return ((root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
        }
    }



}
