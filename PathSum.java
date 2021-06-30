import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(h), h - height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


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
class PathSum {
    List<List<Integer>> result;
    List<Integer> path;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path =  new ArrayList<>();
        target = targetSum;
        if(root == null) return result;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int currSum){
        if(root == null) return;
        
        currSum += root.val;
        path.add(root.val);
        
        helper(root.left, currSum);
        
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.right, currSum);
        
        path.remove(path.size() - 1);
    }
}