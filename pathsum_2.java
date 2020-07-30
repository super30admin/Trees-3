
//With BackTracking
// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.List;
import java.util.ArrayList;

class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;

	TreeNode1() {
	}

	TreeNode1(int val) {
		this.val = val;
	}

	TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class pathsum_2 {
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
		// action
		path.add(root.val);
		if (root.left == null && root.right == null) {
			if (CurSum == target) {
				result.add(new ArrayList<>(path));
			}
		}
		// recurse
		helper(root.left, CurSum, path);
		helper(root.right, CurSum, path);

		// backtracking
		path.remove(path.size() - 1);
	}
}