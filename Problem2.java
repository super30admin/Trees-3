

// Time Complexity :O(n)
// Space Complexity :O(1) 

// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//  Call recursive function  and add base case to check if left not equal to right return 
// left and right null return null\
// and in recursive call change position to match symmetry



public class Problem2 {
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
	
	    public boolean isSymmetric(TreeNode root) {
	        if(root==null)
	            return true;
	        return isSymmetrichelp(root.left,root.right);
	    }
	    
	    private boolean isSymmetrichelp(TreeNode l,TreeNode r){
	        if(l==null && r==null)
	            return true;
	        if(l==null || r==null || l.val!=r.val){
	            return false;
	        }
	       
	       
	        
	        return  isSymmetrichelp(l.left,r.right) &&   isSymmetrichelp(l.right,r.left);
	    }
	
	
}
