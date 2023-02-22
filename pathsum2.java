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
        result= new ArrayList<>();
        helper(root,targetSum,new ArrayList<Integer>(), 0);
        return result;
    }
    private void helper(TreeNode root,int targetSum, List<Integer> path, int curSum ){
        if(root==null) return;

        curSum+=root.val;
        path.add(root.val);
        if(root.left==null&&root.right==null)
        {
            if(curSum==targetSum){
                result.add(new ArrayList<>(path));
            }}
            helper(root.left, targetSum,path,curSum);
            helper(root.right, targetSum,path,curSum);
            path.remove(path.size()-1);
        }

    }
