// Time Complexity : O(N**2)
// Space Complexity : O(N**2) + O(H)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        helper(root, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(TreeNode root, int currSum, List<Integer> path) {
        if(root == null) return;
        
        
        //logic
        currSum = currSum + root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null) {
            System.out.println(currSum + " " + target);
            
            if(currSum == target) {
                System.out.println(path);
                result.add(path);
                return;
            }
        }
        
        helper(root.left, currSum, new ArrayList<>(path));
        helper(root.right, currSum, new ArrayList<>(path));
        
    }
}
