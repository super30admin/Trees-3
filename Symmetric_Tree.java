/*****************************************Recursive**********************************/
// Time Complexity :O(n), we traverse the entire input tree once
// Space Complexity : O(h), height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/* The Two trees are a mirror reflection of each other if: 
 * Their two roots have the same value and
 * The right subtree of each tree is a mirror reflection of the left subtree of the other tree.*/

//Definition for a binary tree node.
/*class TreeNode {
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
}*/

public class Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	private boolean isMirror(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null) // when both left and right tree has reached null
			return true;

		//logic
		if(t1==null || t2 == null || t1.val != t2.val) // if the value of left and right tree are not equal or we have reached end of one of the tree
			return false; // then tree is not symmetric

		// returns true if two roots have the same value and the right subtree of each tree is a 
		//mirror reflection of the left subtree of the other tree	
		return (t1.val == t2.val) &&
				isMirror(t1.right, t2.left) &&
				isMirror(t1.left, t2.right);
	}
} 	