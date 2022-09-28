import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// Time Complexity : O(n) where n = number of elements in tree
// Space Complexity : O(h) where h = height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//113. Path Sum II (Medium) - https://leetcode.com/problems/path-sum-ii/
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
//Time Complexity : O(n*n) where n = number of elements in tree
//Space Complexity : O(n*n*h) where n = number of elements in tree, h = height of the tree
//class Solution {
//    
//    List<List<Integer>> result;
//    
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        result = new ArrayList<>();
//        helper(root, 0, new ArrayList<>(), targetSum);
//        return result;
//    }
//    
//    private void helper(TreeNode root, int currSum, List<Integer> path, int targetSum) {
//        // base
//        if (root == null) return;
//        
//        // logic
//        currSum += root.val;
//        List<Integer> temp = new ArrayList<>(path);
//        temp.add(root.val);
//        
//        if (root.left == null && root.right == null) {
//            if (currSum == targetSum) {
//                result.add(temp);
//            }
//        }
//        
//        helper(root.left, currSum, temp, targetSum);
//        
//        helper(root.right, currSum, temp, targetSum);
//    }
//}

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
// Time Complexity : O(n) where n = number of elements in tree
// Space Complexity : O(h) where h = height of the tree
class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        // base
        if (root == null) return;
        
        // logic
        currSum += root.val;
        
        // action
        path.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        
        // recurse
        helper(root.left, currSum, path, targetSum);
        helper(root.right, currSum, path, targetSum);
        
        // backtrack
        path.remove(path.size()-1);
    }
}