package s30Coding;

//Time Complexity :- O(n) where n is the total number of nodes in the tree

//Space Complexity :- O(h) where h is the height of the tree.

//LeetCode:- yes

//Logic :- The right subtree of each tree is a mirror reflection of the left subtree of the other tree.

public class SymmetricTree {
	public class TreeNode {
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
	public boolean isSymmetric(TreeNode root) {
		return helper(root, root);
		}

	private boolean helper(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return true;
		if (t1 == null || t2 == null) return false;
		return (t1.val == t2.val) && helper(t1.right, t2.left) && helper(t1.left, t2.right);
		}
}
