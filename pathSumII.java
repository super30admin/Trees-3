// TC : O(n)
// SC : O(h)
// Ran on LC : Yes
// Problems faced : None.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	List<List<Integer>> res;
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		 res = new ArrayList<>();
		 helper(root, new ArrayList<>(), 0, targetSum);
		 return res;
	}
	
	private void helper(TreeNode root, List<Integer> path, int sum, int target) {
		 //base
		 if (root == null) return;
		 
		 //logic
		 sum += root.val;
		 path.add(root.val);
		 if(root.left == null && root.right == null) {
			  if (sum == target) {
					res.add(new ArrayList<>(path));
			  }
		 }
		 helper(root.left, path, sum, target);
		 helper(root.right, path, sum, target);
		 
		 path.remove(path.size()-1);
	}
}