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
// Time Complexity : O(n), n is number of nodes in the tree
// Space Complexity : O(h), h is height of the tree
class PathSumII {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path) {
        //base case
        if(root == null) return;

        //logic
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && currSum == targetSum) {
            result.add(new ArrayList<>(path));
        }

        helper(root.left, currSum, targetSum, path);
        helper(root.right, currSum, targetSum, path);

        path.remove(path.size()-1);

    }
}