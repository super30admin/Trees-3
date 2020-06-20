import java.util.List;
//Without BackTracking

// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No
import java.util.ArrayList;

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

class Solution {
	List<List<Integer>> result;
	int target;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		result = new ArrayList<>();
		target = sum;
		helper(root, 0, new ArrayList<>());
		return result;
	}

	private void helper(TreeNode root, int CurSum, List<Integer> path) {
		// base
		if (root == null) {
			return;
		}
		// logic
		CurSum += root.val;
		path.add(root.val);
		if (root.left == null && root.right == null) {
			if (CurSum == target) {
				result.add(path);
			}
		}
		helper(root.left, CurSum, new ArrayList<>(path));
		helper(root.right, CurSum, new ArrayList<>(path));
	}
}