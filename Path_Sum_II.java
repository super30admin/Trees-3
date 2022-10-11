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
// TC : O(n)
// SC : O(h * n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null) return result;
        
        helper(root, targetSum, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int curSum, 
                        List<Integer> path) {
        
        if(root == null) return;
        
        

        curSum = curSum + root.val;
        if(root.left == null && root.right == null) {
            if(curSum == targetSum) {
                path.add(root.val);
                result.add(path);
                return;
            }   
        }
        path.add(root.val);
        helper(root.left, targetSum, curSum, new ArrayList<>(path));
        helper(root.right, targetSum, curSum, new ArrayList<>(path));
    }
}
