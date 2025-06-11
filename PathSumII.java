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

//Time: O(n)
//Space: O(h)+O(h)
class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        this.res=new ArrayList<>();
        helper(root,targetSum,0, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer>path){

        if(root==null) return;

        //Action
        currSum=currSum+root.val;
        path.add(root.val);

        if(root.left==null && root.right==null && currSum==targetSum){
            res.add(new ArrayList<>(path));

        }
        //recurse
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        //backtrack
        path.remove(path.size()-1);

    }
}