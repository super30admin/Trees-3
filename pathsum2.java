// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Backtracking


// Your code here along with comments explaining your approach:
// In this problem we are using backtracking to reduce the space complexity. 
// as we need add a list of Integers to the result which is list of list of integers it will be getting stored as a pointer referenece in the recurssion stack.
// so we need to push a new arraylist of path when the sum is equal to target. 
// at each node we push the curr sum , target sum and path .. as we need to return the path we are adding it to the list while removing that call
// from the stack we need to remove that element from the list. 
// if it is leaf node and the sum == target then we create a new arraylist of path and add it to the result.
// currsum is not changing as it is getting stored as a value but not as a pointer.

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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        sum(root,targetSum,0, new ArrayList<>());
        return this.result;
    }
    public void sum(TreeNode root, int targetSum, int currSum,List<Integer> path){
        //base
        if(root ==null ) return;

        //logic * action
        currSum = currSum  + root.val; // value in stack

        // pointer in stack 
        path.add(root.val);

        if(root.right == null && root.left == null)
        {
            if(currSum == targetSum)
            {                
                result.add(new ArrayList<>(path));
            }
        }


        //recurse
        sum(root.left,targetSum, currSum, path);
        sum(root.right,targetSum, currSum, path);
        
        // back track;
        path.remove(path.size()-1);

    }
}