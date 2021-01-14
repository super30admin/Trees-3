
/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * Space complexity is O(h) where h is height of tree.
 */
public class SymmetricTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}


	boolean isValid = true;

	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return isValid;
		isValid = true;
		helper(root.left, root.right);

		return isValid;

	}

	private void helper(TreeNode left, TreeNode right) {

		// if(root == null)
		// return isValid;

		if (left == null && right == null)
			return;

		if (left == null || right == null || left.val != right.val) {
			isValid = false;
			return;
		}

		helper(left.left, right.right);
		helper(left.right, right.left);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
