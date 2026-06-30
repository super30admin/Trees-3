import java.util.*;
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
    // SC = O(h)
    // TC = O(nh)
    /*
        This solution uses DFS with backtracking to find all root-to-leaf paths whose sum equals the target.
        Starting from the root, each visited node is added to the current path (list), and its value is subtracted from targetSum.
        If a leaf node is reached and the remaining targetSum is 0, the current path is a valid answer and is added to the result.
        The recursion continues by exploring both the left and right subtrees.
        After exploring a node's children, the node is removed from the current path (backtracking) so the same list can be reused for other paths.
    */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<Integer>());
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        }

        targetSum -= root.val;
        list.add(root.val);

        if (targetSum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }

        dfs(root.left, targetSum, list);
        dfs(root.right, targetSum, list);
        list.remove(list.size() - 1);
    }
}