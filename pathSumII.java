
// Time Complexity : O(nh) --> O(n^2) (worst case Skewed tree)
// Space Complexity : O(nh) , n is no of elements, h is the max size of the new
// list -> O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
 * Create a result list of list globally, create a helper function to get the
 * target sum and path to be added in result list
 * We calculate new sum for every new node added and create a new list to avoid
 * the same reference lists.
 * if we reach the leaf node, we check if the current sum is equal to target
 * sum, if so add the list to the result.
 */
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();

        helper(root, 0, new ArrayList<>(), targetSum);

        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        // base
        if (root == null)
            return;

        // logic
        currSum += root.val;
        List<Integer> list = new ArrayList<>(path);
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(list);
            }
        }

        helper(root.left, currSum, list, targetSum);
        helper(root.right, currSum, list, targetSum);

    }
}

// backtrack approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
 * Create a result list of list globally, create a helper function to get the
 * target sum and path to be added in result list
 * 
 * if we reach the leaf node, we check if the current sum is equal to target
 * sum, if so , create a new list of path and add the list to the result.
 */
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();

        helper(root, 0, new ArrayList<>(), targetSum);

        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        // base
        if (root == null)
            return;

        // logic
        currSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, currSum, path, targetSum);
        helper(root.right, currSum, path, targetSum);

        path.remove(path.size() - 1);
    }
}