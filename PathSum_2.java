/*
Running Time Complexity: O(n)
Space complexity: O(n)
Successfully Run and Compiled on leetcode
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
    List<Integer> temp;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        target = targetSum;
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int curr){
        //base case
        if(root==null) return;
        //logic
        //action 
        curr += root.val;
        temp.add(root.val);
        helper(root.left,curr);
        // System.out.println("left side:"+root.val);
        if(root.left==null && root.right==null){
            if(target==curr){
                result.add(new ArrayList<>(temp));
            }
        }
        helper(root.right,curr);
        // System.out.println("right side:"+root.val);
        temp.remove(temp.size()-1);
        // System.out.println("Removing element"+root.val);
        
    }
}