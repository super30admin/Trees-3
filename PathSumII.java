/* Time Complexity: O(n)
 * Space Complexity: O(h)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

import java.util.ArrayList;
import java.util.List;

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
        //null
        if(root == null) return result;
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path, int target) {
        //base
        if(root == null) return;
        
        //logic
        currSum += root.val;
        //action
        path.add(root.val);
        
        if(root.left == null && root.right == null) {
            if(currSum == target) {
                result.add(new ArrayList<>(path));
            }
        }
        
        //recurse
        //left
        helper(root.left, currSum, path, target);
        //st.pop()
        //right
        helper(root.right, currSum, path, target);
        //st.pop()
        
        //backtrack
        path.remove(path.size() - 1);
    }
}