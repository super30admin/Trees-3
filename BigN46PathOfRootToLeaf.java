//Time complexity is O(N) as we are going through all the nodes
// Space complexity is O(H) i.e the height of the tree
// This solution is submitted on leetcode

public class BigN46PathOfRootToLeaf {
	List<List<Integer>> result = new ArrayList();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		// edge
		if (root == null)
			return result;
		helper(root,sum,0, new ArrayList<Integer>());
		return result;
	}

	public void helper(TreeNode node, int sum, int currSum, List<Integer> list) {
		// base case:
		currSum +=node.val;
		list.add(node.val);
		if (node.left == null && node.right == null) {
			if(sum == currSum)
			result.add(list);
		}
		// Logic:
		helper(node.left, sum, currSum, new ArrayList<>(list));
		helper(node.right, sum, currSum,new ArrayList<>(list));
	}
}
