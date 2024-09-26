/**
 * Time Complexity : O(n) where n = number of nodes
 * Space Complexity : (1)
 */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return isSymmetric(root.left,root.right);

    }
    public boolean isSymmetric(TreeNode p,TreeNode q)
    {
        if(p==null || q==null)
        {
            return p==q;
        }
        if(p.val != q.val)
        {
            return false;
        }
        else return isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);


    }

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
}