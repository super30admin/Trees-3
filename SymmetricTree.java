package binaryTrees;

import java.util.Stack;

/**
 * Time: O(n)
 * Space: O(1)
 * Leetcode Accepted: yes
 * Problems faced: No
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root));
		System.out.println(isSymmetricItertive(root));
	}
	
	 private static boolean isSymmetricItertive(TreeNode root) {
		 if(root == null) return true;
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        stack.push(root.right);
	        stack.push(root.left);
	        
	        while(!stack.isEmpty()){
	            TreeNode left = stack.pop();
	            TreeNode right = stack.pop();
	            if(left == null && right == null) {
	            		continue;
	            }
	            if(right == null || left == null || left.val != right.val) {
	                return false;
	            }
	            //Push nodes in an order that they must be compared
	            stack.push(left.right);
	            stack.push(right.left);
	            stack.push(right.right);
	            stack.push(left.left);
	        }
	        return true;
	}

	public static boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return helper(root.left, root.right);
	 }

	private static boolean helper(TreeNode left, TreeNode right) {
		//Base Case
		if(left == null && right == null) return true;
		if(left == null) return false;
		if(right == null) return false;
		if(left.val != right.val) return false;
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
	    
}
