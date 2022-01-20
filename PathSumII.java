// Time Complexity : O(n)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class PathSumII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currentSum, int targetSum, List<Integer> list) {
        if (root == null)
            return;

        currentSum += root.val;
        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum)
                result.add(new ArrayList<>(list));
        }

        helper(root.left, currentSum, targetSum, list);
        helper(root.right, currentSum, targetSum, list);

        list.remove(list.size() - 1);
    }
}
