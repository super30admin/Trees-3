// Time complexity is O(N) as we are traversing all the nodes of the tree
// space complexity is O(h) i.e the height of the tree.
// This solution is submitted on leetcode
public class SymmetericTreeUsingRecursion {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true; 
		return find(root.left,root.right);
	}

	private boolean find(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		return find(left.left, right.right) && find(left.right, right.left);
	}
}