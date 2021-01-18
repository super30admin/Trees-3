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
    int target;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList<>();
        if(root==null) return result;
        target=sum;
        helper(root,0,new ArrayList<>());
        return result;
        
    }
    public void helper(TreeNode root, int currSum, List<Integer> path){
        //base
        if(root==null) return;
        //logic
        currSum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum==target){
                result.add(path);
            }
        }
        helper(root.left,currSum,new ArrayList<>(path));
        helper(root.right,currSum,new ArrayList<>(path));
        
    }
}