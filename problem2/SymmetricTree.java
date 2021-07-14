// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return helper(root.left, root.right);
	}

	public boolean helper(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return node1.val == node2.val && helper(node1.left, node2.right) && helper(node1.right, node2.left);
	}

	public static void main(String[] args) {
		SymmetricTree obj = new SymmetricTree();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		System.out.println("Is the tree symmetric? " + (obj.isSymmetric(root) == true ? "Yes" : "No"));
	}

}
