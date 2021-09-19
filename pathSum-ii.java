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

// Time Complexity: O(n) as we are traversing all node once and removing from path which we are not going to save in result
// Space Complexity: Only additional list of path is used which may take space upto O(h)
// Did you complete it on leetcode: Yes
// Any problems faced: Understood in class

// Write your approach here:
// Idea here is to perform the action based on condition that if we have reached leaf node
// by recursing through left or right, if the sum equals to the target sum, the path is added to result.
// an additional step of backtracking is performed to remove the last element in list
// to manage time complexity by having global pointer itself updating to new path.
class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;
        if(root==null) return result;
        helper(root, 0);
        return result;
    }
    
    public void helper(TreeNode root, int currSum) {
        if(root==null) {
            return;
        }
        path.add(root.val);
        currSum = currSum + root.val;
        if(root.left==null && root.right==null) {
            if(currSum==target) {
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.left, currSum);
        
        helper(root.right, currSum);
        
        path.remove(path.size()-1);
    }
}