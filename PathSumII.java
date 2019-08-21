package binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Time: O(2^Depth of the tree) 
 * No. of paths checked during the tree traversal
 * Space: O(Depth of the tree)
 * Leetcode Accepted: yes
 * Problems face: Understanding the backtracking implementation in code for this problem was slightly difficult
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
		System.out.println(optimizedPathSum(root, 22));
	}
	
	/**
	 * Optimizing PathSum solution not to use copy of new ArrayList on every child node
	 * Tip: Done using Backtracking --- Improved the runtime and space
	 * Time: O(2^Depth of the tree) 
	 */
	
	private static List<List<Integer>> optimizedPathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> set = new ArrayList<Integer>();
		findPaths(root, sum, set, result);
		return result;
	}

	private static void findPaths(TreeNode root, int sum, List<Integer> set, List<List<Integer>> result) {
		if(root == null) return;
		set.add(root.val);
		
		//Check if the root is a leaf node
		//Since set is an ArrayList reference, and set varies through out the tree, it is better to have a copy of set
		if(root.left == null && root.right == null && root.val == sum) 
			result.add(new ArrayList<>(set));
		
		//Find paths on children nodes
		findPaths(root.left, sum-root.val, set, result);
		findPaths(root.right, sum-root.val, set, result);
		
		//Bactracking -- remove the current node from set
		set.remove(set.size()-1);
	}
	
	/**
	 * Bruteforce solution: Passing a new copy of path(covered so far) set to every child node
	 * @param root
	 * @param sum
	 * @return
	 */

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
