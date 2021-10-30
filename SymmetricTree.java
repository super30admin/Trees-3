// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SymmetricTree {
	 public boolean isSymmetric(TreeNode root) {
	        return helper(root.left,root.right);
	    }
	    
    public boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        
        if(left==null || right==null){
            return false;
        }
        
        if(left.val!=right.val){
            return false;
        }
        
        return helper(left.left,right.right) && helper(left.right,right.left);
        
    }
    
    public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
    	      }
    }
	
}
