
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
        result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        helper(root,new ArrayList<Integer>(),root.val,targetSum);
        return result;
    }
    
    private void helper(TreeNode root,List<Integer> path,int curSum,int targetSum){
        //base case
        if(root == null)
            return;
        //logic
        //left
        path.add(root.val);
        if(root.left == null && root.right == null && curSum == targetSum){
            result.add(new ArrayList<>(path));
        }
        if(root.left!=null)
        helper(root.left,path,curSum+root.left.val,targetSum);
        //right
        if(root.right!=null)
        helper(root.right,path,curSum+root.right.val,targetSum);
        path.remove(path.size()-1);
    }

}