package Q_113_Path_Sum_II;

import java.util.*;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Given the below binary tree and sum = 22,
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
//7    2  5   1
//Return:
//
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]

//Time Complexity  : O(n)  
//Space Complexity : O(H) // as per the stack space 

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	List<List<Integer>> li = new ArrayList<>();
	public  List<List<Integer>> pathSum(TreeNode root, int sum) {
//		List<List<Integer>> ansList
		if(root == null) {
			return li;
		}
		helper(root, 0, new ArrayList<Integer>(), sum);
		return li;

	}
	
	public  void helper(TreeNode node,int currSum, List<Integer> sumList , int sum) {
		//base case
		if(node ==null) {
			return;
		}
		
//		if(currSum+node.val <= sum) {
		sumList.add(node.val);
		currSum = currSum + node.val;
		
		if(node.left == null && node.right ==null && currSum == sum) {
			li.add(sumList);
			return;
		}
		
//		}else {
//			return;
//		}
		helper(node.left, currSum, new ArrayList<Integer>(sumList), sum);
		helper(node.right, currSum, new ArrayList<Integer>(sumList), sum);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
//		TreeNode root = new TreeNode(5);
//		root.left = new TreeNode(4);
//		root.right = new TreeNode(8);
//		root.left.left = new TreeNode(11);
//		root.left.left.left = new TreeNode(7);
//		root.left.left.right = new TreeNode(2);
//		
//		root.right.left = new TreeNode(13);
//		root.right.right = new TreeNode(4);
//		root.right.right.left = new TreeNode(5);
//		root.right.right.right = new TreeNode(1);
		
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		
		System.out.println(s.pathSum(root, -5));
		

	}

}
