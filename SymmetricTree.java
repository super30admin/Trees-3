/*SC - O(2N), creating a copy of tree to check,  TC O(N)
 * check left of tree to its corresponding right most
 * */

class Solution {
    
    
    public boolean isSymmetricTree(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            // both are 
           return true; 
        }
        
        if (root1 == null && root2 != null){
            return false;
        }
        if (root1 != null && root2 == null){
            return false;
        }
        
    
        
        return ((root1.val == root2.val) && (isSymmetricTree(root1.left, root2.right)) && isSymmetricTree(root1.right, root2.left));
    }
    
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTree(root, root);
    }
}
