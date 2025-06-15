/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 /*
 Approach:
 -We are used to fina all root-to-leaf paths where the sum of the node values equals a given target.
 -We perform a depth-first search (DFS) traversal to explore all paths from root to leaves.
 -While traversing, we maintain:
    1. The current path(as a list of integers)
    2. The running sum of the path.
-If we reach a leaf node and the current sum matches the target, we add a *copy* of the current path to the result list.
-After exploring both left and right subtrees, we backtrack by removing the last node from the path to explore other branches.
-Backtracking ensures that the same path list can be reused for other paths without side effects.

Time Complexity: O(n)
-In the worst case, we may visit each node once ->O(n)
-If there are L leaf nodes, and each path is of length h (height), copying a path takes O(h) time.
-So, total complexity can be approximated to O(n*h) in the worst case where many paths are valid.

Space Complexity: O(h)
-h = height of the tree.
-Space is used by the recursion stack (DFS traversal) and the current path list.
-Result list does not count towards auxiliary space since it's part of the output.
 */

 //Definition of binary tree node

public class TreeNode{
    int val; //Value of the node
    TreeNode left;//Left childs
    TreeNode right; //Right child

    TreeNode() {}//Default constructor

    TreeNode(int val){
        this.val = val;
    }


    TreeNode (int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right=right;
    }
}

class Solution {

    List<List<Integer>> result; //Global list to store all valid root-to-leaf paths

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();//Initialize the result list
        helper(root, targetSum, 0, new ArrayList<>()); //Start DFS with empty path and 0 sum
        return result; //Return all valid paths found        
    }

    //Helper function to perform DFS and backtrack
    private void helper(TreeNode root , int targetSum , int currSum , List<Integer> path) {
        //Base case: If current node is null, return (no path through this branch)
        if(root == null) return;

        //ACTION: Update current sum and add the node to path
        currSum += root.val;
        path.add(root.val);

        //If it's a aleaf node, check if the current path sum equals the target
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                //Add a *copy* of the current path to resukt (important to cllone list)
                result.add(new ArrayList<>(path));
            }
        } 
        //RECURSE on left and right subtrees
        helper(root.left, targetSum, currSum, path); //Traverse left
        helper(root.right, targetSum, currSum, path); //Traverse right

        //BACTRACK: Remove the last added node to restore state for sibling paths
        path.remove(path.size()-1);


    }
}