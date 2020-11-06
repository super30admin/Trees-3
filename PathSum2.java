import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.ResolveResult;

public class PathSum2 {
	int target;
	List<List<Integer>> result;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		result = new ArrayList<List<Integer>>();
		target = sum;
		helper(root, new ArrayList<Integer>(), 0);

		return result;
	}

	private void helper(TreeNode root, List<Integer> path, int currSum) {
		// TODO Auto-generated method stub

		// base
		if (root == null)
			return;

		
		
		// logic
		currSum += root.val;
		path.add(root.val);

		if (root.left == null && root.right == null) {
			if (target == currSum) {
				result.add(path);
			}
		}
		helper(root.left, path, currSum);
		helper(root.right, path, currSum);

	}
}
