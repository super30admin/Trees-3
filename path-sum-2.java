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
    int targ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        targ = targetSum;
        backtrack(root, new ArrayList<>(), 0);
        return result;
    }
    public void backtrack(TreeNode root, List<Integer> list, int currSum){
        //base
        if(root == null){
            return;
        }
        //logic
         currSum += root.val;
        //action
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum == targ){
                result.add(new ArrayList<>(list));
            }
        }
        //recurse 
        backtrack(root.left, list, currSum);
        backtrack(root.right, list, currSum);
        //backtrack
        list.remove(list.size() - 1);
    }
}