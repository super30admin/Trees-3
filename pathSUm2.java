// Time complexity - O(n)
// Space complexity - O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
    
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        int currentSum = 0;
        ArrayList<Integer> arr1 = new ArrayList<>();
        pathHelper(root, targetSum, 0, arr1);
        
        return result;
        
    }
    
    private void pathHelper(TreeNode root, int targetSum, int currentSum, ArrayList<Integer> arr1){
        
        if(root == null){
            
            return;
        }
        currentSum = currentSum + root.val;
        arr1.add(root.val);
        if(root.left == null && root.right == null && currentSum == targetSum){
            
            result.add(new ArrayList<>(arr1));
        }
        
        pathHelper(root.left, targetSum, currentSum, arr1);
        pathHelper(root.right, targetSum, currentSum, arr1);
        
        //backtrack logic
        arr1.remove(arr1.size() - 1);
        
        
    }
}