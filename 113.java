/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;dd
 *         this.left = left;
 *         this.right = right;ss
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public void helper(TreeNode node, int targetSum, int sum, List<Integer> path) {
        sum += node.val;
        path.add(node.val);
        if (sum == targetSum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        }
        if (node.left != null) {
            helper(node.left, targetSum, sum, path);
        }
        if (node.right != null) {
            helper(node.right, targetSum, sum, path);
        }
        path.remove(path.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<Integer> path = new ArrayList<>();
       if (root == null) {
           return res;
       }
       helper(root, targetSum, 0, path);
       return res;
    }
}