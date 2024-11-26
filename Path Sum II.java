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

 //TC = O(n)
 //SC = O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    void helper(TreeNode root, int targetSum, int currSum, List<Integer> path)
    {
        //base case
        if(root == null) return;

        //logic
        currSum+=root.val;
        path.add(root.val);

        //action
        if(root.left == null && root.right == null && currSum == targetSum) result.add(new ArrayList<>(path));

        //recurse
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        //backtrack
        path.remove(path.size() - 1);
    }
}
