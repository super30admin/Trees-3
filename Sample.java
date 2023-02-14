import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

// Time Complexity : O(N^2)
// Space Complexity : O(H) H is the max height of leaf node.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Start from the root. If not null, add it to the list and check if
 * it is the leaf node, if so check if its val + sum till then == target,
 * if so push that list to the answer list. If not leaf, then process the same
 * for root.left and root.right and then remove the root node from the list.
 * return the answer list at last.
 *
 */
class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> ans = new ArrayList<>();
		helper(root, targetSum, 0, new ArrayList<>(), ans);
		return ans;
	}

	public void helper(TreeNode root, int targetSum, int sum, List<Integer> res, List<List<Integer>> ans) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			if (sum + root.val == targetSum) {
				res.add(root.val);
				ans.add(new ArrayList<>(res));
				res.remove(res.size() - 1);
			}
			return;
		}
		res.add(root.val);
		helper(root.left, targetSum, sum + root.val, res, ans);
		helper(root.right, targetSum, sum + root.val, res, ans);
		res.remove(res.size() - 1);
	}
}