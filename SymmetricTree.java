// Time Complexity : O(N)
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Take left and right node as arguments and pass result to bottom nodes.
 * 2. For each node compare left node left and right node right
 * 3. For each node  compare left node right and right node left
 * 3. if it is not equlas return false.
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		if (root1.val != root2.val)
			return false;

		boolean case1 = helper(root1.left, root2.right);
		boolean case2 = helper(root1.right, root2.left);

		return case1 && case2;
	}
}
