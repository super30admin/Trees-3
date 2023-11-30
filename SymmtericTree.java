// Time Complexity: O(n)
// Space Complexity: O(h) 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    
    public boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if((p != null && q != null) && (p.val == q.val))
            return isMirror(p.left, q.right) && isMirror(p.right, q.left);
        else return false;
    }
}