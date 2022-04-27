// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: check symmetry at every node for elft and right child

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return DFS(root.left, root.right);
    }
    private boolean DFS(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || right.val != left.val) return false;
        return DFS(left.left, right.right) && DFS(left.right, right.left);
    }
}
