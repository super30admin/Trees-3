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
class Solution1 {
    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        helper(root, 0, targetSum);
        return result;
    }

    public void helper(TreeNode root, int sum, int targetSum) {
        //base case
        if( root == null ) {
            return;
        }
        // if( sum > targetSum) {
        //     return;
        // }
        sum = sum + root.val;
        //action
        path.add(root.val);
        if( root.left == null && root.right == null ) {
            if( sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, sum , targetSum);
        helper(root.right, sum, targetSum);
        //backtrack
        path.remove(path.size()-1);
    }
}