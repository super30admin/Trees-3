// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    //aesha
    int curSum;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), curSum);
        return result;
    }
    private void helper(TreeNode root, int targetSum, List<Integer> path, int curSum)
    {
        if(root == null) return;

        curSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right==null)
        {
            if(curSum == targetSum)
            {
                result.add(path);
            }
        }
        
        helper(root.left, targetSum, new ArrayList<>(path), curSum);
        helper(root.right, targetSum, new ArrayList<>(path), curSum);


    }
}
