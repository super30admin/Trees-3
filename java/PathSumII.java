package java;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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
        List<List<Integer>> res;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            this.res = new ArrayList<>();
            helper(root, targetSum, 0, new ArrayList<>());
            return res;
        }

        private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
            //base
            if (root == null)
                return;

            List<Integer> tmp = new ArrayList<>(path);
            currSum += root.val;
            tmp.add(root.val);

            if (root.left == null && root.right == null) {
                if (currSum == targetSum) {
                    res.add(tmp);
                }
            }

            helper(root.left, targetSum, currSum, tmp);
            helper(root.right, targetSum, currSum, tmp);
        }
    }

//TC: O(n * h) for copying elements to new Array lists
//SC: O(n * h) for creating new Array lists

//Approach -2

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
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        //base case
        if (root == null)
            return;

        //ACTION
        currSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (currSum == targetSum)
                res.add(new ArrayList<>(path));
        }

        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        //backtrack
        path.remove(path.size() - 1);
    }
}

// TC: O(n) - considering constant paths only meet the targetSum
// SC: O(h) + O(h) - recursive stack + the array used for backtracking