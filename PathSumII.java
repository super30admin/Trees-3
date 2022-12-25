import java.util.*;

// Time Complexity : O(n^2) // we add all elements from previous array to the current
// Space Complexity : O(n^2) // two things: stack space(which has all nodes) and list at each node

/*
 * here we traverse through the tree and get the running sum. 
 * add elements to the list and if at the leaf node we get the target value 
 * add it the final result.
 */

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
class PathSUMII{
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<List<Integer>>();
        helper(root, new ArrayList<>(), 0, targetSum);
        return result;
    }

    public void helper(TreeNode root, ArrayList<Integer> arr, int currSum, int targetSum){
        //base
        if(root == null) return;

        //logic
        currSum += root.val;
        ArrayList<Integer> li = new ArrayList<>(arr);
        li.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(li);
            }
        }
        helper(root.left, li, currSum, targetSum);
        helper(root.right, li, currSum, targetSum);
    }
}