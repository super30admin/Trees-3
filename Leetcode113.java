// TC - O(n)
// SC - O(h) with the assumption that output list is not considered 
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
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, 0, path, targetSum);
        return res;

    }

    private void helper(TreeNode node, int currSum, List<Integer> path, int targetSum) {
        // Base
        if (node == null)
            return;

        // Logic
        path.add(node.val);
        currSum += node.val;
        if (node.left == null && node.right == null && currSum == targetSum) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1); // Removing this for leaf node. Just to avoid another recursive call to null
                                          // left and right pointers.
            return;
        }

        // Left
        helper(node.left, currSum, path, targetSum);
        // Right
        helper(node.right, currSum, path, targetSum);

        // Backtrack
        path.remove(path.size() - 1);

    }
}