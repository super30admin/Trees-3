// Time Complexity: O(n^2), we create copy of elements each time
// Space Complexity : O(n^2) copy of elements each time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/***********************************Brute Force**********************************/
/* Traverse each path from the root, save in an array, if it adds to sum append it to array*/

import java.util.*;

public class Path_SumII {
	List<List<Integer>> result;	//global result so that we dont have to pass again and again
	int target;	// global variable target sum
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		result = new ArrayList<>();
		target = sum;
		if(root == null)
			return result;

		dfs(root, 0, new ArrayList<>());	// calling dfs for sum 0 and path pointing to empty list

		return result;
	}

	private void dfs(TreeNode root, int currSum, List<Integer> temp){
		if(root == null)	// when we reach the null node
			return;

		//logic
		currSum += root.val;	// finding sum for the node for which the call is made using prev sum
		temp.add(root.val);	// adding node to path

		if(root.left == null && root.right == null){	//if leaf node we have to if check target is found
			if(target == currSum)
				result.add(new ArrayList<>(temp));	// if target found we add path to result
		}

		dfs(root.left, currSum, new ArrayList<>(temp));	// calling on left subtree by creating a copy of the path and passing its pointer as the original path is getting changed
		dfs(root.right, currSum, new ArrayList<>(temp));	// calling on right subtree
	}
}