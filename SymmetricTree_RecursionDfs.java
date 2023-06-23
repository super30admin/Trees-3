public class SymmetricTree_RecursionDfs {

    //RECURSION
    class Solution {
        public boolean isSymmetric(TreeNode root) {

            if(root == null) return true;

            //start with children of the root
            return SymmetryTreeDfs(root.left, root.right);

        }
        private boolean SymmetryTreeDfs(TreeNode left, TreeNode right){

            // root is the single node in a tree
            if(left == null && right == null) return true;

            // if anyside is null or values are different
            if(left == null || right == null || left.val != right.val) return false;

            boolean edge = SymmetryTreeDfs(left.left, right.right);
            //st.pop()

            if(!edge) return false;

            boolean between = SymmetryTreeDfs(left.right, right.left);
            //st.pop()

            return between;

            // when the entire is checked
            //return edge && between;
        }
    }
}
