package trees3;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) {
			 this.val = val;
			 this.left = left;
			 this.right = right;
		 }
	}
	
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(n), Implicit stack for recursion
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, result, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        // base
        if(root == null)
            return;
        
        // logic
        path.add(root.val);
        if(root.left == null && root.right == null && targetSum - root.val == 0)
            result.add(new ArrayList<>(path));
        
        helper(root.left, targetSum - root.val, result, path);
        helper(root.right, targetSum - root.val, result, path);
        
        path.remove(path.size() - 1);
    }
}
