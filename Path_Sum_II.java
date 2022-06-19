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
        result = new ArrayList<>();
        //null
        if(root==null) return result;
        helper(root,0,new ArrayList<>(),targetSum);
        return result;
    }
    
    private void helper(TreeNode root,int currSum,List<Integer> path, int target){
        //base
        if(root == null ) return;
        
        //logic
        currSum += root.val;
        path.add(root.val);
         if(root.left == null && root.right== null){
            if(currSum == target){
                result.add(path);}}
        //left
        helper(root.left,currSum,new ArrayList<>(path),target);
        //st.pop
         helper(root.right,currSum,new ArrayList<>(path),target);
            }
        }
    //}
//}