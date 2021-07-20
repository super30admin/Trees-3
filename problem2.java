
//TIME- O(N)
//SPACE- O(1)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
        }
    
    public boolean compare(TreeNode r1, TreeNode r2){
        
                //base
        if(r1==null && r2==null) return true;
        
        if(r1==null || r2==null) return false;
        if(r1.val!= r2.val) return false;

        
        else return compare(r1.left, r2.right) && compare(r1.right, r2.left);
    }
}