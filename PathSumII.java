import java.util.*;

public class PathSumII {
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

	List<List<Integer>> result;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		result = new ArrayList<>();
		if (root == null)
			return result;

		// call helper recursive function
		helper(root, 0, new ArrayList<>(), sum);
		return result;
	}

//	//normal recursion
//	private void helper(TreeNode root, int currSum, List<Integer> path, int target) {
//		// base
//		if (root == null)
//			return;
//
//		// logic
//		//add root val to path
//		path.add(root.val);
//		//calculate current sum
//		currSum += root.val;
//		
//		//if it is a leaf node and cumSum is eq target add to result
//		if (root.left == null && root.right == null) {
//			if (currSum == target) {
//				result.add(path);
//			}
//		}
//		//rec call on left & right with deep copies of array List each node
//		helper(root.left, currSum, new ArrayList<>(path), target);
//		helper(root.right, currSum, new ArrayList<>(path), target);
//	}

	// backtracking
	private void helper(TreeNode root, int currSum, List<Integer> path, int target) {
		// base
		if (root == null)
			return;

		// logic
		path.add(root.val);
		currSum += root.val;

		if (root.left == null && root.right == null) {
			if (currSum == target) {
				result.add(new ArrayList<>(path));
			}
		}
		helper(root.left, currSum, path, target);
		helper(root.right, currSum, path, target);
		
		// remove last node from the list before next traverse
		path.remove(path.size() - 1);
	}

}
