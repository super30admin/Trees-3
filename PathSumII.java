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
        if(root == null) {
            return new ArrayList<>();
        }

        build(root, 0, targetSum, new ArrayList<>());

        return result;
    }

    private void build(TreeNode root, int curSum, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }

        curSum += root.val;

        path.add(root.val);

        if(curSum == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
            
        }

        build(root.left, curSum, targetSum, path);
        build(root.right, curSum, targetSum, path);

        path.remove(path.size() - 1);
    }

}