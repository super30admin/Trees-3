// Time Complexity : O(n^2), where n is the number of nodes in the tree (At every node creating copy of array while traversing the tree)
// Space Complexity :O(n), where n is the number of nodes in the tree (space required to create new arrays at every node)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//three liner explanation in plain english
//1. We can perform inorder traversal to traverse the tree. At every node, calculate the runningSum and path till the current root as an new array
//2. Check if the root is the leaf node and runningSum till the root is equal to the sum and add the path to the results array
//2. Keep doing this for the complete tree and find multiple paths if there 

// Your code here along with comments explaining your approach

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
class Solution {
    //List to return result
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if(root == null) return result;
        target = sum;
        helper(root, 0, new ArrayList<>());
        return result;
    }
    
    private void helper( TreeNode root, int runningSum, List<Integer> path){
        //base
        if(root == null) return;
        
        //logic
        //register the path till the current node
        path.add(root.val);
        //calculate the runningSum till the current node
        runningSum += root.val;
        
        //add the path to the result if get the sum and the current node id leaf
        if( root.left ==null && root.right ==null && runningSum == target){
            result.add(path);
        }
        //traverse the left subtree with new instance of the path
        helper(root.left, runningSum, new ArrayList<>(path));
        //traverse the right subtree with new instance of the path
        helper(root.right, runningSum, new ArrayList<>(path));
    }
}