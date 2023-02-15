// Time Complexity : O(N)
// Space Complexity : O(H) H is the max height of leaf node.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * If root is null, return true, if not, we have to check
 * if left & right children are not null. If any one of them is null,
 * then return false. If not, check if they are equal and then we have
 * to check left.left == right.right && left.right == right.left and
 * return true if equal else false.
 *
 */
class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return helper(root.left, root.right);
	}

	public boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;

		if (left == null || right == null)
			return false;
		return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
	}
}