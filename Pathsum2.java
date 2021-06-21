// Time Complexity : O(N)
// Space Complexity : O(H) //pathList might have height of the list elements at max
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Go to the root and add root value to th currentsum and also add node val to path list.
 * 2. start to the left subtree iterate and do the same.
 * 3. at the leaf node if sum is equal to target add the copy of list to result.
 * 4. do the same for right tree.
 * 5. to backtrack remove the last element when cursum is not equals to target sum.
 */

import java.util.ArrayList;
import java.util.List;

public class Pathsum2 {

	List<List<Integer>> result;
	int targetSum;
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		result= new ArrayList<>();
		this.targetSum=targetSum;
		
		helper(root, 0, new ArrayList<Integer>());
		
		return result;
	}
	
	private void helper(TreeNode root,int curSum,List<Integer> pathList) {
		//condition
		if(root==null) return;
		
		//processing
		curSum+=root.val;
		pathList.add(root.val);
		
		helper(root.left, curSum, pathList);
		
		//logic
		if(root.left==null && root.right==null) {
			if(curSum==targetSum) {
				result.add(new ArrayList<>(pathList));
			}
		}
		helper(root.right, curSum, pathList);
		
		//backtrack
		pathList.remove(pathList.size()-1);
	}

	public static void main(String[] args) {
		TreeNode root= new TreeNode(5);
		root.left=new TreeNode(4);
		root.left.left=new TreeNode(11);
		root.left.left.right=new TreeNode(2);
		root.left.left.left=new TreeNode(7);
		root.right=new TreeNode(8);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(4);
		root.right.right.left=new TreeNode(5);
		root.right.right.right=new TreeNode(1);
		
		System.out.println(new Pathsum2().pathSum(root, 22));
	}

}

class TreeNode {
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
