import java.util.ArrayList;
import java.util.List;

/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * Space complexity is O(n) where n is no of elements.
 */

public class PathSumII {
	public class TreeNode {
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
	int target;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		result = new ArrayList<>();
		if (root == null)
			return result;

		target = sum;
		backtrack(root, 0, new ArrayList<>());

		return result;

	}

	private void backtrack(TreeNode root, int currSum, List<Integer> path) {

		// base

		if (root == null)
			return;

		// logic

		currSum += root.val;
		path.add(root.val);
		if (root.left == null && root.right == null) {
			if (currSum == target) {
				result.add(new ArrayList<>(path));
			}
		}

		backtrack(root.left, currSum, path);
		backtrack(root.right, currSum, path);

		// backtrack

		path.remove(path.size() - 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PathSumII objIn = new PathSumII();

		// objIn.backtrack(root, currSum, path);

	}

}
