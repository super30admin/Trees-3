/* Time Complexity : O(n) where n is number of nodes 
   Space Complexity : O(h) where h is the height of the tree 
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
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
    List<List<Integer>>  res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return new ArrayList<>();
        res = new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root, int targetSum,int curSum, List<Integer> path){
        //base
        if(root==null)
            return;
        
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(curSum+root.val==targetSum)
                res.add(new ArrayList<>(path));
        }
        helper(root.left,targetSum,curSum+root.val,path);
        helper(root.right,targetSum,curSum+root.val,path);
        path.remove(path.size()-1);//backtrack
        
    }
}