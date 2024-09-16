// Time complexity - O(n^2)
// Space complexity - O(n^2)

// Recusrive solution with different arraylist with each node.


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
        int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        helper(root, 0 , new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path){
        // base
        if(root == null){
            return;
        }
        // logic
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(path);
            }
        }
        
        helper(root.left,currSum,new ArrayList<>(path));
        helper(root.right   ,currSum,new ArrayList<>(path));
    }
}
