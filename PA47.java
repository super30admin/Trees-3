// Leetcode 101. Symmetric Tree
//Time Complexity: O(n) // n is no of nodes in tree 
//Space Complexity:O(n) // Stack will have only nodes equal to the heigt of the tree but in worst case it is equal to n. 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
            
       return helper(root.left,root.right);
    }
    
    public boolean helper(TreeNode root1,TreeNode root2){
        if(root1 == null && root2== null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        
        return helper(root1.right,root2.left) && helper(root1.left,root2.right);
    }
}