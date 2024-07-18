/**
 * Time Complexity - O(N)
 * Space Complexity - O(H)
 */

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumHelper(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSumHelper(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if(root == null)
            return;

        currentPath.add(root.val);

        if(root.left == null && root.right == null && root.val == targetSum)
            result.add(new ArrayList<>(currentPath));

        pathSumHelper(root.left, targetSum - root.val, currentPath, result);
        pathSumHelper(root.right, targetSum - root.val, currentPath, result);

        currentPath.remove(currentPath.size() - 1);

    }
}