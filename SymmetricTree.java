// Time Complexity :O(N) number of nodes
// Space Complexity :O(h) height of the tree
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach

public class SymmetricTree {
	   public boolean isSymmetric(TreeNode root) {
	        if(root ==null)
	            return true;
	            return helper(root.left,root.right); 
	    }
	    
	    public boolean helper(TreeNode left, TreeNode right){
	        if(left ==null && right ==null)
	            return true;
	        else if(left ==null || right ==null)
	            return false;
	        else if(left.val !=right.val)
	            return false;
	        else 
	            return helper(left.right,right.left) && helper(left.left,right.right); 
	        
	    }
	    
}
