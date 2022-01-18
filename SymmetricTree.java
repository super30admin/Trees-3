package trees3;

import java.util.Stack;

public class SymmetricTree {
	public class TreeNode {
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
	}
	
	//Iterative
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(n), for stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        
        while(!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            
            if(left == null && right == null)
                continue;
            if(left == null || right == null)
                return false;
            if(left.val != right.val)
                return false;
            
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        
        return true;
    }
	
	//Recursive
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(n), Implicit stack for recursion
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean isSymmetric1(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        // base
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        
        // logic
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
