// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}

		helper(root, targetSum, new ArrayList<Integer>(), ans);
		return ans;
	}

	public void helper(TreeNode root, int targetSum, List<Integer> pathVal, List<List<Integer>> ans) {
		if (root == null) {
			return;
		}

		pathVal.add(root.val);

		if (targetSum == root.val && root.left == null && root.right == null) {
			ans.add(new ArrayList<>(pathVal));
		} else {
			helper(root.left, targetSum - root.val, pathVal, ans);
			helper(root.right, targetSum - root.val, pathVal, ans);
		}
		pathVal.remove(pathVal.size() - 1);
	}

	public static void main(String[] args) {
		PathSum2 obj = new PathSum2();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		int target = 22;
		System.out.println("Paths with target " + 22 + ": ");
		List<List<Integer>> paths = obj.pathSum(root, target);
		for (List<Integer> path : paths) {
			for (Integer node : path) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
	}
}
