/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//TC: o(n);
//SC: o(h);

class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
         flag =true;
        dfs (root.left, root.right);
        return flag;
              
    }
    
    private void dfs(TreeNode left,TreeNode right){

        //base
        if(left == null && right == null) return;
        // if left is null or right is null then return false
        
        if(left == null || right == null)
        {
            flag= false;
            return;
        }   
        
        // if left.val not equal to right.val then symentic tree is breached
        if(left.val != right.val)
        {
            flag= false;
            return;
        }
        
        if(flag)
        // go throug left.left and right.right
        // left most left and right most right values are iterated recusively
        dfs(left.left, right.right);
        //stack.pop();
        
        
        if(flag)
            // go throug left.right and right.right
            // left's right and right's left values are iterated recusively
        dfs(left.right,right.left);
        //stack.pop();
          
    }
    
    
}
