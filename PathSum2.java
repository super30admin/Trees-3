/**
 * Time Complexity: O(n)
 * Space complexity: O(h); height of the tree
 * Ran on leetcode? Yes
 * Problems faced? No
 *
 * Approach:
 *
 */
import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static class TreeNode {
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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        dfs(root, targetSum, 0, list);
        return result;
    }

    private void dfs(TreeNode root, int target, int curSum, List<Integer> list) {
        // base
        if (root == null) {
            return;
        }

        //logic
        curSum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (curSum == target) {
                result.add(new ArrayList<>(list));
            }
        }
        dfs(root.left, target, curSum, list);
        dfs(root.right, target, curSum, list);
        list.remove(list.size() - 1);
    }
}
