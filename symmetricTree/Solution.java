// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    
    public boolean check(TreeNode l,TreeNode r){
    if(l==null && r==null) return true;
    else if(l==null || r==null) return false;
    else if(l.val != r.val) return false;
    return (check(l.left,r.right) && check(l.right,r.left));  
    }
}
