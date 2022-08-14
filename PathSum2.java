
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
        helper(root,0,targetSum,new ArrayList());
        return result;
    }
    
    public void helper(TreeNode root,int currSum, int targetSum,List<Integer> path){
        if(root == null) return;
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right==null){
            if(currSum == targetSum)
                result.add(new ArrayList<>(path));
        }
        helper(root.left,currSum,targetSum,path);
        helper(root.right,currSum,targetSum,path);
        path.remove(path.size()-1);
    }
}
