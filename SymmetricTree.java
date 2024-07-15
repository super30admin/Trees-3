
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this :

public class SymmetricTree {
  
    public boolean isSymmetric(TreeNode root) {
       
        
        return helper(root,root);
    }

    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2==null) return true;
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val != root2.val) return false;

        return helper((root1.left), root2.right) && helper(root1.right, root2.left);
    }
}
