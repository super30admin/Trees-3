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
/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        helper(root, new ArrayList<>(), res, targetSum);
        return res;

    }

    public void helper(TreeNode root, List<Integer> state, List<List<Integer>> res, int target) {

        if(root.left == null && root.right == null){

            if(target == 0){
                List<Integer> temp = new ArrayList<>();
                for(int i: state){
                    temp.add(i);
                }
                res.add(temp);
                return;
            }
        }
        else{
            if(root.left != null){
                helper(root.left, state, res, target);

            }
            if(root.right != null){
                helper(root.right, state, res, target);
            }
        }
    }
}