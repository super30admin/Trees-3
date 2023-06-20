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
// Time Complexity o(n) Space complexity o(h)
class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        helper(root,targetSum,path,0);
        return res;
    }
    public void helper(TreeNode root,int targetSum, List<Integer> path,int currSum){
        if(root == null) return;
       
        currSum+=root.val;
        
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum == targetSum){
                res.add(new ArrayList<>(path));
            }
            
        }
        helper(root.left,targetSum,path,currSum);
        helper(root.right,targetSum,path,currSum);
        path.remove(path.size()-1);
        
        
    }
}