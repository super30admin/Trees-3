import java.util.ArrayList;
import java.util.List;

/**
## Problem1 (https://leetcode.com/problems/path-sum-ii/)
 
Time Complexity :   O (N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (113. Path Sum II)
Any problem you faced while coding this :       No
 */

// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
class PathSum {
    List<List<Integer>> result;
    List<Integer> path;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(root, 0, targetSum);
        return result;
    }
    public void helper(TreeNode root, int curr_Sum, int targetSum) {
        // base case
        if( root == null){
            return;
        }
        
        // logic - maintain curr_Sum at every node
        curr_Sum += root.val;
        
        // action
        path.add(root.val);

        // if child node
        if(root.left == null && root.right == null){
            // if curr_Sum == target, add into result
            if(curr_Sum == targetSum){
                List<Integer> temp = new ArrayList<>(path);
                result.add(temp);
            }
        }
        helper(root.left, curr_Sum, targetSum);
        helper(root.right, curr_Sum, targetSum);
        
        //backtrack
        path.remove(path.size() -1);
    }
}