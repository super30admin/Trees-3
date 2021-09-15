// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no
public class sym {
    public boolean isSymmetrichelper(TreeNode l, TreeNode r)
    {
        //base
        if(l == null && r == null){
            return true;
        }
        if(l == null && r != null){
            return false;
        }
        if(l != null && r == null){
            return false;
        }
        if(l.val != r.val){
            return false;
        }
        return ( isSymmetrichelper(l.left, r.right) 
                && isSymmetrichelper(l.right, r.left) );
    }
    public boolean isSymmetric(TreeNode root) {
        
        if( isSymmetrichelper(root.left, root.right) ) return true;
        return false;
    }
}
