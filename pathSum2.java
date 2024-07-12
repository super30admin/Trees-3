
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
/*
 TC --> O(n)
 Sc --> O(n) auxillary space for stack recurssion
 */
import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(resList, path, root, targetSum);
        return resList;
    }

    public void helper(List<List<Integer>> resList, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            resList.add(new ArrayList<>(path));
        } else {
            helper(resList, path, root.left, targetSum);
            helper(resList, path, root.right, targetSum);
        }
        path.remove(path.size() - 1);
    }
}
