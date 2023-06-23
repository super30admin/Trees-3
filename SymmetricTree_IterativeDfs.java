import java.util.Stack;

public class SymmetricTree_IterativeDfs {


    //DFS - ITERATIVE
    // STACK (LIFO)GIVES DFS ONLY

    class Solution {
        public boolean isSymmetric(TreeNode root) {

            if(root == null) return true;

            if(root.left == null && root.right == null) return true;

            Stack<TreeNode> StNodes = new Stack<>();

            StNodes.add(root.right);
            StNodes.add(root.left);

            // iterative
            while(!StNodes.isEmpty()){

                TreeNode left = StNodes.pop();
                TreeNode right = StNodes.pop();

                if(left == null && right == null) continue;

                if(left == null || right == null || left.val != right.val) return false;

                StNodes.add(left.left);    StNodes.add(right.right);
                //DFS
                StNodes.add(left.right);   StNodes.add(right.left);

            }
            return true;
        }
    }
}
