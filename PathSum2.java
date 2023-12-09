// Time Complexity : O(n) //going through all nodes
// Space Complexity : O(n) //Recursive stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

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

//DFS with backtracking(to remove last node, if not it cascades from left to right) and used global result variable
class Solution {
    List<List<Integer>> res;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<List<Integer>>();
        target = targetSum;
        helper(root, 0, new ArrayList<Integer>());

        return res;
    }

    private void helper(TreeNode root, int currSum, List<Integer> temp){
        //base
        if(root == null)
            return;

        currSum += root.val;
        temp.add(root.val);

        //identify leaf node and check if target is met
        if(root.left == null && root.right==null){
            if(currSum == target){
                //Need to deep copy temp instead of directly adding as data structure inside another data structure will be ref not copy
               res.add(new ArrayList<>(temp));
            }
        }
        
        helper(root.left, currSum, temp);
        helper(root.right, currSum, temp);

        //backtrack
        temp.remove(temp.size() - 1);
        
    }


}
