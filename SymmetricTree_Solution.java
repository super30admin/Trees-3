package SymmetricTree;

//import ZigZagOrderTraversal.Solution.TreeNode;

//import TreeLevelTraversal.Solution.TreeNode;

public class SymmetricTree_Solution {

	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static boolean isSymmetric(TreeNode root) {
        if (root == null)
        {
            return true;
        }
     return  isSymmetric(root.left, root.right);  
    }
    
    public static boolean isSymmetric(TreeNode left,TreeNode right)
    {
        if(left == null || right == null)
        {
            return left==right;
        }
        
        if(left.val != right.val)
        {
            return false;
        }
        
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
	
	public static void main(String[] args) {
		

		TreeNode node = new TreeNode(1);
		node.left= new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(7);
		node.left.right = new TreeNode(6);
		node.right.left = new TreeNode(5);
		node.right.right  = new TreeNode(4);
		
		boolean ans = isSymmetric(node);
		System.out.println(ans);
		// TODO Auto-generated method stub

	}

}
