/*
 * #113. Path Sum II
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

 */


/*
 * Time Complexity: max(O (N), O (c * maxDepth))  // O (N) -> To traverse all the nodes in a tree, O (c * maxDepth) -> To copy all the nodes from currPath to temp list, worst case all the paths will give valid sum same as target, we will have to crate temp for each path and add c(no of leaf nodes) * maxDepth(nodes in a current path)
 * 
 * Space Complexity: O (N) + O (maxDepth) // O (N) -> Recursive stack, O (maxDepth) -> currPath has at the max nodes for one path = maxDepth of that path
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.trees3;

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode8 {
	int val;
	TreeNode8 left;
	TreeNode8 right;
	TreeNode8() {}
	TreeNode8(int val) { this.val = val; }
	TreeNode8(int val, TreeNode8 left, TreeNode8 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class RootToLeafPaths {
	public List<List<Integer>> pathSum(TreeNode8 root, int sum) {
		// Create lists for storing current path and final output
        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
    
        // Initiate the recursion
        recurr(root, sum, 0, currPath, output);
        return output;
    }
    
	// Recursion function
    public void recurr(TreeNode8 root, int target, int currSum, List<Integer> currPath, List<List<Integer>> output){
        
        // Base case to stop recursion
        if(root == null){
            return;
        }
        
        // Recursive case
        
        // Top-Down recursion
        
        // 1.  Conditional statements
        // Check if at the leaf node and previous sum + leaf node equals target sum
        // If yes, then create a temp list, copy all elements from currPath to it and then add leaf node to temp list, then add temp to output list
        if(root.left == null && root.right == null){
            if(currSum + root.val == target){
                List<Integer> temp = new ArrayList<>(currPath);
                temp.add(root.val);
                output.add(temp);
            }
        }
        
        // While going top to down, add the nodes to currPath and compute sum by adding node value to previous sum
        currPath.add(root.val);
        currSum += root.val;
        
        // 2. recursive calls 
        recurr(root.left, target, currSum, currPath, output);
        recurr(root.right, target, currSum, currPath, output);
        
        // Once recursion is done for both left and right child of a node, remove that node from currPath as it will change while exploring other branches of a tree.since we are using same list for storing currPath, not creating separate list at each node to keep track of current path
        
        currPath.remove(currPath.size() - 1); // remove last value from currPath list
    }
    
}
