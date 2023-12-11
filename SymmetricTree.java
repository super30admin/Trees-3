//T.C O(n) //Number of nodes
//S.C O(h) //recursive stack space will be height of the tree
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
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        return check(root.left, root.right);
        
    }
    private boolean check(TreeNode left, TreeNode right){
        if(left==null && right ==null) return true;
        if((left == null && right != null) ||(right == null && left != null)) return false;
        if(left.val != right.val) return false;
        
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
