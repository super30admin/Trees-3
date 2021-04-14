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
class Solution113 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result= new ArrayList<>();
        if(root==null){
            return result;
        }
        backtrack(root,targetSum, 0,new ArrayList<>());
        return result;
        }
    
    private void backtrack(TreeNode root,int targetSum, int currsum,List<Integer> path){
        //base
        if(root==null){
            return;
        }
        //logic
        currsum=currsum+ root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
        if(targetSum==currsum){
            result.add(new ArrayList<>(path));
        }}
        backtrack(root.left,targetSum, currsum,path);
        backtrack(root.right,targetSum, currsum,path);
        path.remove(path.size()-1);
        
        
        
    }
}