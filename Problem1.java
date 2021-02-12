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

// Time Complexity : (N)
// Space Complexity : O(max(depth)+N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
    iterate in preorder until targetSum is 0 & add list to result

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return new LinkedList<List<Integer>>();

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        helper(root,targetSum,result,list);

        return result;
    }

    public void helper(TreeNode root,int targetSum, List<List<Integer>> result, List<Integer> list){
        if(root==null)
            return;

        targetSum -= root.val;
        list.add(root.val);

        if(root.left==null && root.right==null && targetSum==0){
            List<Integer> temp = new LinkedList(list);
            result.add(temp);
            list.remove(list.size()-1);
            return;
        }


        helper(root.left,targetSum,result,list);
        helper(root.right,targetSum,result,list);
        list.remove(list.size()-1);
    }
}