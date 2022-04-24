//T.C = O(N)
//S.C=O(N)
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
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res=new ArrayList<>();
        path=new ArrayList<>();
        if(root==null)return res;
        
        helper(root,0,targetSum);
        return res;
    }
    
    private void helper(TreeNode root,int currSum,int targetSum){
        if(root==null){
            return ;
        }
        
        currSum+=root.val;
        //Action
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                res.add(new ArrayList<>(path));
            }
        }
        //Recurse
        helper(root.left,currSum,targetSum);
        helper(root.right,currSum,targetSum);
        //Backtrack
        path.remove(path.size()-1);
    }
}
