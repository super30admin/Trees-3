// Time Complexity :O(n)
// Space Complexity :O(h)

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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>(), 0);
        return result;
    }

    public void helper(TreeNode root, int targetSum, List<Integer> path, int currentSum) {

        if (root == null)
            return;
        currentSum += root.val;
        if (root.left == null && root.right == null && targetSum == currentSum) {
            path.add(root.val);
            System.out.println("inside if and path is" + path);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        // edge case

        // logic
        path.add(root.val);
        helper(root.left, targetSum, (path), currentSum);
        helper(root.right, targetSum, (path), currentSum);
        path.remove(path.size() - 1);
    }}