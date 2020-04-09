//101.
//time - O(n)
//space - O(h)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode p, TreeNode q) {
        //base
        if(p == null && q == null)
        {
            return true;
        }
        if(p == null || q == null)
        {
            return false;
        }
        //logic
        if((p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left))
        {
            return true;
        }
        return false;
        
    }
}
