/*    Worst case - O(n) 
 Space Complexity : O(h)
  Where h is height of tree. 
 Did this code successfully run on Leetcode : yes

 Three line explanation of solution in plain english

/* DFS Approach :- 
 * Call recursive method by passing (left->left, right->right) && (left->right, right->left).
 * If the node values don't match return false, else tree is symmetric.
 */
class Solution {
    boolean isValid  = true;
    public boolean isSymmetric(TreeNode root) {
        if( root == null){
            return isValid;
        }
        dfs(root.left, root.right);
        return isValid;
        
    }
    private void dfs(TreeNode n1 , TreeNode n2 ){
        
        if(n1 == null && n2 == null){
            return;
        }
        if(n1 == null || n2 == null || n1.val != n2.val){
            isValid = false;
            return;
        }
        dfs(n1.left, n2.right);
        dfs(n1.right, n2.left);
    }
    
}
