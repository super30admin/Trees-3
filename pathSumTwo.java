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

//  Tc: O(n), sc:O(h)
class Solution {
    List<List<Integer>> resList;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        resList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root,targetSum,0,list);
        return resList;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> list){
        if(root==null) return;

        list.add(root.val);
        currSum+=root.val;
        if(currSum==targetSum && root.left==null && root.right==null){
            resList.add(new ArrayList<>(list));
        }
        helper(root.left, targetSum,currSum,list);
        helper(root.right, targetSum,currSum,list);

        list.remove(list.size()-1);
    }
}