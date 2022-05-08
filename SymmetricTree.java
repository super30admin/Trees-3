public class SymmetricTree {
    
    boolean isValid;

    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
         
         isValid = true;
         dfs(root.left,root.right);
         
         return isValid;
         
         
     }
     
     private void dfs(TreeNode left,TreeNode right)
     {
         if(left == null && right == null) return;
         
         if(left==null || right == null || left.val !=right.val)
         {
             isValid = false;
             return;
         }
         
         dfs(left.left,right.right);
         if(isValid == true){
         dfs(left.right,right.left);
         }
     }
}
