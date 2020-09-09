package com.Sep2020.Trees3;
// Time Complexity : O(n)
// Space Complexity : O(h) // height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//Need to check if this works using  traversal methods (any)
public class SymmetricTree {
	
	
	 // Definition for a binary tree node.
	  public static class TreeNode {
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
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,2,3,4,4,3};
		
		for (int i : arr) {
			
			System.out.println(" output => " + isSymmetric(new TreeNode(i)));
		}

		
	}
	public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    
	static boolean  isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left !=null && right != null && left.val == right.val)
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        return false;
    }
}
