// Time Complexity : O(N)
// Space Complexity : O(H), height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Symmetric_Tree_Recursive {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
		// base
		if (left == null && right == null) {
			return true;
		}
		// logic
		if (left == null || right == null || left.val != right.val) {
			return false;
		}
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
}