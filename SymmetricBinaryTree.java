/*
 * #101. Symmetric Tree
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Follow up: Solve it both recursively and iteratively.

 */


/*
 * Time Complexity: O (N) -> To traverse through 'N' nodes of a tree
 * 
 * Space Complexity: O (N) -> Space to store elements equal to 'maxDepth' at the same time in a recursive stack
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.trees3;


//Definition for a binary tree node.
class TreeNode9 {
	int val;
	TreeNode9 left;
	TreeNode9 right;
	TreeNode9() {}
	TreeNode9(int val) { this.val = val; }
	TreeNode9(int val, TreeNode9 left, TreeNode9 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class SymmetricBinaryTree {
	 public boolean isSymmetric(TreeNode9 root) {
	        
	        // #1. if root is null , meaning no binary tree, empty tree is symmetric return true
	        if(root == null){
	            return true;
	        }
	        // When traversing is done, or at any leaf branch the answer becomes false, the answer from child nodes is returned to the parent node all the way up to the root node and final answer is returned from this function
	        return recurr(root.left, root.right);
	    }
	    
	    public boolean recurr(TreeNode9 p1Left, TreeNode9 p2Right){
	        
	        // #2. If Binary tree just have a root node or we reached the leaf nodes, return true
	        if(p1Left == null && p2Right == null){
	            return true;
	        }
	        
	        // #3. If while traversing, any of the p1Left or p2Right is null or the value of nodes is different, return false
	        if(p1Left == null || p2Right == null || p1Left.val != p2Right.val){
	            return false;
	        }
	        
	        // # 4. Make recursive calls and return the answer to the parent node as parent node is dependant on child node's answer for its execution, In case if answer is false, then parent node will not explore/traverse the other branches and directly return the answer all the way up to root node
	        return recurr(p1Left.left, p2Right.right) && recurr(p1Left.right, p2Right.left);
	        
	    }
	    
}
