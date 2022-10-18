// TC - O(n)
//SC - O(h)
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
        List<Integer> curr = new ArrayList<>();
        findPath(root,targetSum,res,curr);
        return res;
    }
    public void findPath(TreeNode root,int targetSum, List<List<Integer>> res,List<Integer> curr){
        
        if(root==null) return;
        curr.add(root.val);
        if(root.left==null && root.right==null && targetSum==root.val){
            res.add(new ArrayList<Integer>(curr));
        }
        
        findPath(root.left,targetSum-root.val,res,curr);
        findPath(root.right,targetSum-root.val,res,curr);
        curr.remove(curr.size()-1);
        return;
        
    }
}