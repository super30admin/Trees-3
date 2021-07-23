//TC: O(n)
//SC: O(n)
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
        result = new ArrayList<>();
        
        helper(root, targetSum, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if(root == null) return;
        currSum = currSum + root.val;
        path.add(root.val);
        helper(root.left, targetSum, currSum, path);
        if(root.left == null && root.right == null && targetSum == currSum) {
            result.add(new ArrayList<>(path));
        }
        helper(root.right, targetSum, currSum, path);
        path.remove(path.size()-1);
    }
}