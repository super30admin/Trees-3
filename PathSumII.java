// TC: O(n^2) where n represents the number of nodes in Tree. in worst case we are traverlling leaf nodes (n/2) and for each leaf nodes, we may copy all the 
// pathnodes into a arraylist, hence n^2 is TC.
//SC: O(N) for recursion stack since we are traversing all nodes in the tree

// We storing each node value in a temporary list, We are calculating remaining amount from the sum. Once we find any value which is equal to the remaining amount
// we add all the values in temp list which lead us to that leaf node into the resultant list.
// we repeat this process to each of the path node from root to left for left subtree and right subtree.

import java.util.*;

public class PathSumII {
	
	public List<List<Integer>> SumPath(TreeNode root, int sum){
		List<List<Integer>> res = new ArrayList();
		List<Integer> temp = new ArrayList();
		Sum(root, sum, res, temp);
		return res;
	}
	
	public void Sum(TreeNode root, int remainingSum,List<List<Integer>> res, List<Integer> temp) {
		
		if(root==null)
			return;
		
		temp.add(root.val);
		
		if(remainingSum==root.val && root.left==null && root.right==null)
		{
			res.add(new ArrayList(temp));
		}
		else {
			Sum(root.left, remainingSum-root.val, res, temp);
			Sum(root.right, remainingSum-root.val, res, temp);
		}
		temp.remove(temp.size()-1);
	}
	public static void main(String[] args) {
		PathSumII ps = new PathSumII();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		List<List<Integer>> res = ps.SumPath(root, 22);
			System.out.println(res);
		
	}

}
