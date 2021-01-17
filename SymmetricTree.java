import java.util.*;

public class SymmetricTree {

	class TreeNode {
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

	// Recursion
//	public boolean isSymmetric(TreeNode root) {
//
//		if (root == null)
//			return true;
//
//		return helper(root.left, root.right);
//	}
//
//	private boolean helper(TreeNode left, TreeNode right) {
//		// base
//		if (left == null && right == null)
//			return true;
//		// logic
//		// if one of the node is null or vals are not equal return false
//		if (left == null || right == null || left.val != right.val)
//			return false;
//		return helper(left.left, right.right) && helper(left.right, right.left);
//	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;
		Stack<TreeNode> st = new Stack<>();
		st.push(root.left);
		st.push(root.right);
		//while loop till stack is not empty
		while (!st.isEmpty()) {
			TreeNode right = st.pop();
			TreeNode left = st.pop();
			//we have to validate the null roots too! bcs should be null both the ends
			if (left == null && right == null)
				continue;
			if (left == null || right == null || right.val != left.val)
				return false;
			//push left thn right - stack last in First out
			st.push(left.left);
			st.push(right.right);
			st.push(left.right);
			st.push(right.left);
		}
		return true;
	}

}
