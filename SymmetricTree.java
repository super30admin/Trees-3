// TC - O(n)
// SC - O(h) where h is height of tree

import java.util.*;

public class SymmetricTree {

    public static class TreeNode {
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

    // DFS Approach
    public static class Solution1 {
        boolean flag;

        public boolean isSymmetric(TreeNode root) {
            // DFS approach
            if ( root == null) return true;
            flag = true;
            dfs(root.left,root.right);
            return flag;
        }
        private void dfs(TreeNode left, TreeNode right){
            //base
            if( left==null && right==null) return;
            if(left==null || right==null || left.val != right.val) {
                flag = false;
                return;
            }

            //logic
            if(flag)
                dfs(left.left,right.right);
            // st.pop();
            if(flag)
                dfs(left.right,right.left);
        }
    }

}
