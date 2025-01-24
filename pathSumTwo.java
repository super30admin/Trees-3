import java.util.ArrayList;
import java.util.List;


class pathSumTwo {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    public void dfs(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        // base
        if (root == null) {
            return;
        }
        // logic
        currSum = currSum + root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(path);
            }
            return;
        }
        //if we give just path it will return two list with [5,4,11,7,8,13,4,5] which isn't desired o/p. We need a new list at each and every node so ArrayList<>(path)
        dfs(root.left, currSum, new ArrayList<>(path), targetSum);
        dfs(root.right, currSum, new ArrayList<>(path), targetSum);

    }
}
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
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    public void dfs(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        // base
        if (root == null) {
            return;
        }
        // logic
        currSum = currSum + root.val;
        //adding to the path
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            // return;
        }
        //Backtracking
        dfs(root.left, currSum, new ArrayList<>(path), targetSum);
        dfs(root.right, currSum, new ArrayList<>(path), targetSum);
        path.remove(path.size()-1);

    }
}