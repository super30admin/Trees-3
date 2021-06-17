// 101. Symmetric Tree

class Solution{


 boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        isValid = true;
        
        helper(root.left, root.right);
        return isValid;
    }
    
    private void helper(TreeNode left, TreeNode right){
        // base
        if(left == null && right == null) return;
        
        if(left == null || right == null || left.val != right.val){
            isValid = false;
            return;
         }   
        // logic 
         helper(left.left, right.right);
         
         helper(left.right, right.left);   
        
    }
}

/*
Complexity Analysis

Time complexity : O(n). 
Because we traverse the entire input tree once, the total run time is 
O(n), where n is the total number of nodes in the tree.

Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in 
O(n). Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case.  
*/
  