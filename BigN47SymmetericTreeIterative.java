//Time complexity is O(N) as we are traversing all the nodes of the tree
//space complexity is O(N/2) i.e O(N) i.e the number of the element in the last row
//This solution is submitted on leetcode

public class BigN47SymmetericTreeIterative {

	public boolean isSymmetric(TreeNode root) {
		// null root is an symmetric tree
		if (root == null) {
			return true;
		}
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
