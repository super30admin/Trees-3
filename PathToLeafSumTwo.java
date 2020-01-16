// Recursive Solution

//Time Complexity : O(n)
//Space Complexity : O(h) --> Recursive Stack Space
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class PathToLeafSumTwo {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		List<List<Integer>> li = new ArrayList<>();

		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			if (root == null)
				return li;
			dfs(root, 0, new ArrayList<>(), sum);
			return li;
		}

		private void dfs(TreeNode root, int currSum, List<Integer> currli, int sum) {
			if (root == null)
				return;
			currSum += root.val;
			currli.add(root.val);
			if (root.left == null && root.right == null) {
				if (currSum == sum) {
					li.add(currli);
				}
			}
			dfs(root.left, currSum, new ArrayList<>(currli), sum);
			dfs(root.right, currSum, new ArrayList<>(currli), sum);
		}
	}
}
