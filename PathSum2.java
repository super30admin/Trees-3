// Time Complexity : O(n) + O(n*h) n is the no of nodes and h is the height
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
At each node, calculate the sum
check the sum only at leaf nodes and if it is equal to the target, add it to the result - deep copy
 */

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
        this.result=new ArrayList<>();
        helper(root,new ArrayList<>(),0,targetSum);
        return this.result;
    }

    public void helper(TreeNode root,List<Integer> path,int currSum,int targetSum){
        //base
        if(root==null) return;

        //action
        currSum=currSum+root.val;
        path.add(root.val);

        if(root.left==null && root.right==null && currSum==targetSum)
        {
            result.add(new ArrayList<>(path));
        }

        //recurse
        helper(root.left,path,currSum,targetSum);
        helper(root.right,path,currSum,targetSum);

        //backtrack
        path.remove(path.size()-1);

    }
}