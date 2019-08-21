package binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: O(n)
 * Space: O(n)
 * Leetcode Accepted: yes
 * Problems face: No
 */
public class PathSumII {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		System.out.println(pathSum(root, 22));
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		
		//A set for storing nodes from root to leaf
		List<Integer> set = new ArrayList<Integer>();
		set.add(root.val);
		
        return helper(root, sum, result, set);
        
    }

	private static List<List<Integer>> helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> set) {
		//For child node
		if(root.left == null && root.right == null && sum == root.val) {
			result.add(set);
			return result;
		}
		
		//A deep copy of parent set is required, in order to have a separate copy for left and right children
		if(root.left != null) {
			List<Integer> leftSet = new ArrayList<Integer>(set);
			leftSet.add(root.left.val);
			result = helper(root.left, sum-root.val, result, leftSet);
		}
		
		if(root.right != null) {
			List<Integer> rightSet = new ArrayList<Integer>(set);
			rightSet.add(root.right.val);
			result = helper(root.right, sum-root.val, result, rightSet);
		}
		return result;
	}

}
