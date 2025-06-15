// Time Complexity : O(n*h) n= number of elements, h = height of the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Backtracking, removing the last element in the result.


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


class PathSumII {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> subRes = new ArrayList<>();
        helper(root, targetSum, 0, subRes);
        return res;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> subRes){
        if(root == null)
            return;
        currSum = currSum + root.val;
        subRes.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                res.add(new ArrayList<>(subRes));
            }
        }
        helper(root.left, targetSum, currSum, subRes);
        helper(root.right, targetSum, currSum, subRes);
        subRes.remove(subRes.size()-1);
    }
}