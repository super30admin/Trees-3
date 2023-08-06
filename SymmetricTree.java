public class SymmetricTree {

    //Time complexity  = 0(n)
    //Space complexity = O(h)
    //  Definition for a binary tree node.
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
        boolean flag;
        //Using BFS approach
        public boolean isSymmetric(TreeNode root) {
            if(root==null) return true;
            flag = true;
            dfs(root.left, root.right);
            return flag;
        }

        public void dfs(TreeNode left, TreeNode right){
            if(left == null && right == null){
                return;
            }

            if(left == null || right == null || left.val !=right.val){
                flag = false;
                return;
            }

            dfs(left.left, right.right);
            dfs(left.right, right.left);
        }
    }
}
