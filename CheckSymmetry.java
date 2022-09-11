public class CheckSymmetry {
    //Time: O(n)
    //Space: O(n)
    public boolean checkSymmetry(TreeNode root1,TreeNode root2)
    {
         //base
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        
        //logic
        
        return root1.val==root2.val && checkSymmetry(root1.left,root2.right) && checkSymmetry(root1.right,root2.left);
    }
}
