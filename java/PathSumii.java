// Time Complexity : O(N2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        path(root, new ArrayList<>(),targetSum,res);

        return res;
    }

    public void path(TreeNode root,List<Integer> l, int targetSum, List<List<Integer>> res) {

        if(root==null){
            return;
        }
        l.add(root.val);


        if(targetSum==root.val && root.left==null && root.right==null ){

            res.add(l);

        }
        if(root.left!=null){
            path(root.left,new ArrayList<>(l),targetSum-root.val,res);
        }
        if(root.right!=null){
            path(root.right,new ArrayList<>(l),targetSum-root.val,res);
        }

    }
}