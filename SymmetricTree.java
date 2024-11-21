import java.util.Stack;

// Recursive Solution

//Time Complexity : O(n)
//Space Complexity : O(h) --> Recursive Stack Space
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Iterative Solution

//Time Complexity : O(n)
//Space Complexity : O(h) --> Auxiliary Stack Space
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class SymmetricTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class RecursiveSolution {
		public boolean isSymmetric(TreeNode root) {
			if (root == null)
				return true;
			return helper(root.left, root.right);
		}

		private boolean helper(TreeNode left, TreeNode right) {
			if (left == null && right == null)
				return true;
			if (left == null || right == null || left.val != right.val)
				return false;
			return helper(left.left, right.right) && helper(left.right, right.left);
		}
	}

	class IterativeSolution {
		public boolean isSymmetric(TreeNode root) {
			if (root == null)
				return true;
			Stack<TreeNode> st = new Stack<>();
			st.push(root.left);
			st.push(root.right);
			while (!st.isEmpty()) {
				TreeNode right = st.pop();
				TreeNode left = st.pop();
				if (left == null && right == null)
					continue;
				if (left == null || right == null || left.val != right.val)
					return false;
				st.push(left.left);
				st.push(right.right);
				st.push(left.right);
				st.push(right.left);
			}
			return true;
		}
	}
}
