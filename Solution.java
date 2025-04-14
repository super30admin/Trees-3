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

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>());
        return result;

    }

    private void helper(TreeNode root, int targetSum, List<Integer> path)
    {
        if(root == null) return;

        //logic
        targetSum = targetSum - root.val;
        path.add(root.val);

        if(root.left == null && root.right == null)
        {
            if(targetSum == 0){
                result.add(new ArrayList<>(path));
            }

        }
        helper(root.left, targetSum, path);
        helper(root.right, targetSum, path);
        //backtracking
        path.remove(path.size() - 1);

    }
}