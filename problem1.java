// Time Complexity: O(n)
// Space Complexity: O(H)

// We recursively sum values in dfs, if we reach a leaf node and sum is equal to targetSum, we add the entire path to result

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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();

        findPathSum(root, 0, targetSum, new ArrayList<>());

        return result;
    }

    public void findPathSum(TreeNode root, int sum, int targetSum, List<Integer> path) {
        if (root == null) return;

        sum = sum + root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && sum == targetSum) {
            result.add(new ArrayList<>(path));
        }

        findPathSum(root.left, sum, targetSum, path);
        findPathSum(root.right, sum, targetSum, path);

        path.removeLast();


    }

}
