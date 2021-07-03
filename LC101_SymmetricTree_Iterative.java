/**
 * 
 */
package LC101_SymmetricTree_Iterative;

import java.util.Stack;


/**
 * @author neha
 * @Time Complexity - O(N)
 * @Space Complexity - O(N)
 */
public class LC101_SymmetricTree_Iterative {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	    TreeNode right;
	     TreeNode(int x) 
	     { 
	    	 val = x; 
	    	 }
	     
	 }
	static TreeNode root; 

	public static boolean isSymmetric(TreeNode root) {
        //Edge case
        if(root == null)
        {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        
        while(!stack.isEmpty())
        {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if(left == null && right == null)
            {
                continue;
            }
           if(left==null || right==null || left.val!=right.val)
           {
               return false;
           }
            
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
       return true; 
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

	}

}
