package Q_101_Symmetric_Tree;


//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
//But the following [1,2,2,null,3,null,3] is not:
//
//    1
//   / \
//  2   2
//   \   \
//   3    3

//Time Complexity  : O(n)  
//Space Complexity : O(1)

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}
	
	public boolean helper(TreeNode left, TreeNode right) {
		
		if(left == null && right ==null) {
			return true;
		}
		
		if( left ==null || right ==null || left.val != right.val) {
			return false;
		}
		
		return helper(left.left, right.right) && helper(left.right, right.left);
//		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
		
		System.out.println(s.isSymmetric(root));

	}

}
