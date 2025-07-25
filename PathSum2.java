// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem1 (https://leetcode.com/problems/path-sum-ii/)
// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
// Each path should be returned as a list of the node values, not node references.
// A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

// Example 1:
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]
// Explanation: There are two paths whose sum equals targetSum:
// 5 + 4 + 11 + 2 = 22
// 5 + 8 + 4 + 5 = 22

// Example 2:
// Input: root = [1,2,3], targetSum = 5
// Output: []

// Example 3:
// Input: root = [1,2], targetSum = 0
// Output: []
 
// Constraints:
// The number of nodes in the tree is in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000

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
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result; // to store all valid root-to-leaf paths

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // Base case: empty tree
        if (root == null){
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        // Starting DFS with initial sum 0 and an empty path
        dfs(root, 0, targetSum, new ArrayList<>());

        return result;
    }

    private void dfs(TreeNode root, int currSum, int targetSum, List<Integer> path){
        // Base case: reached a null node
        if (root == null){
            return;
        }

        // Add current node's value to current sum and path
        currSum = currSum + root.val;
        path.add(root.val); // action

        // If it's a leaf node and the current sum matches the target, save the path
        if(root.left == null && root.right == null){
            if (currSum == targetSum){
                result.add(new ArrayList<>(path)); // making a deep copy of path
            }
        }

        // Recursive calls: Exploring left and right children
        dfs(root.left, currSum, targetSum, path);
        dfs(root.right, currSum, targetSum, path);

        // Backtrack: remove last added node before returning to the caller
        path.remove(path.size() - 1);
    }
}