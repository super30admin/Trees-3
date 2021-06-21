// Time Complexity: O(n)
// Space Complexity: O(1)

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
    int currSum;
    List<List<Integer>> result;
    List<Integer> path;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;
        if(root == null) return result;
        helper(root);
        return result;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        
        currSum += root.val;
        path.add(root.val);
        
        helper(root.left);
        
        helper(root.right);
        
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(new ArrayList<>(path));
            }
        }
        currSum -= root.val;
        path.remove(path.size() - 1);
    }
}