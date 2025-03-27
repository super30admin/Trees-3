// Overall Time Complexity : O(n) . Since we are traversing each node in the tree. 
// Overall Space Complexity :  O(h) + O(h) where h  height of the tree for the recursive stack space taken and h for the path taken.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation



// Keep track of currentSum  and the path at each node from root to leaf
// Check if the currentNode is the leafNode  and if true validate the targetSum  create a new reference path   
// and add it result 
// Recursively move towards left and right 
// Remove the node from the path once we backtrack

import java.util.*;
class PathSum {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result= new ArrayList<>();

        helper(root,0,new ArrayList<>(),targetSum);

        return result;
        
    }

    public void helper(TreeNode root, int currSum, List<Integer> path, int targetSum){

        //base
        if(root == null){
            return;
        }

        currSum+= root.val;
        //action
        path.add(root.val);

        //logic
        
        if(root.left == null && root.right == null && currSum == targetSum){
            result.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }
        //recurse
        helper(root.left, currSum,path,targetSum);
        helper(root.right,currSum,path,targetSum);
        
        //backtrack
        path.remove(path.size()-1);
       
    }
}