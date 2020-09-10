// Time Complexity : O(n)
// Space Complexity : O(h) + O(c*h)
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
    List<List<Integer>> output = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)    return new ArrayList();
        
        List<Integer> curPath = new ArrayList();
        
        helper(root, sum, 0, curPath);
        
        return output;
    }
    private void helper(TreeNode root, int target, int curSum, List<Integer> curPath){
        if(root == null)    return;
        
        if(root.left == null && root.right == null){
            if(curSum + root.val == target){
                List<Integer> path = new ArrayList(curPath);
                path.add(root.val);
                output.add(path);
            }
        }
        
        curSum += root.val;
        curPath.add(root.val);
        
        helper(root.left, target, curSum, curPath);
        helper(root.right, target, curSum, curPath);
        curPath.remove(curPath.size()-1);
    }
}
