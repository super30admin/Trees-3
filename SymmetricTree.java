package binaryTrees;

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
