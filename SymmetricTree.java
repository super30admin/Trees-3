//idea:  recursive solution.
//compare tree with self by passing  same tree as two parameters. and compare values of both trees (it should be equal)and left of first tree with right of second but same tree values should be equal. also check vice versa recursively.
//once reach leaf node return true

//time complexity o(n)
//space complexity is o(1)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:no

public class SymmetricTree {
	//class TreeNode contains data, left and right node
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			val = value;
		}
	}
	
	//isSymmetric method check mirror image is or not
	public static boolean  isSymmetricTree(TreeNode root) {
		//pass same tree as two parameters to helper method to compare with itself
		boolean flag = isMirror(root, root);
		return flag;	
	}
	
	//isMirror method- compare values of both trees which are same
	public static boolean  isMirror(TreeNode root, TreeNode root2) {
		//leaf node check
		if(root == null && root2 == null) return true;
		//null check
		if(root == null || root2 == null) return false;
		//check left and right values of root .for mirror image left of tree should be equal to right of same tree. and vice versa.
		return(root.val== root2.val) && isMirror(root.left,root2.right) && isMirror(root.right,root2.left);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Driver program 
	   
	        TreeNode tree = new TreeNode(1); 
	       
	        tree.left = new TreeNode(2); 
	        tree.right = new TreeNode(2); 
	        tree.left.left = new TreeNode(3); 
	        tree.left.right = new TreeNode(4); 
	        tree.right.left = new TreeNode(4); 
	        tree.right.right = new TreeNode(3); 
	        boolean output = isSymmetricTree(tree); 
	        if (output == true) 
	            System.out.println("it is symmetric tree"); 
	        else
	            System.out.println("it is not symmetric tree"); 
	    

	}

}
