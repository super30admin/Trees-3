// Time Complexity : O(N)
// Space Complexity : O(H), height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class Symmetric_Tree_Iterative {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> st = new Stack<>();
		st.add(root.left);
		st.add(root.right);
		while (!st.isEmpty()) {
			TreeNode left = st.pop();
			TreeNode right = st.pop();
			if (left == null && right == null) {
				continue;
			}
			if (left == null || right == null || left.val != right.val) {
				return false;
			}
			st.push(left.left);
			st.push(right.right);
			st.push(left.right);
			st.push(right.left);
		}
		return true;
	}
}