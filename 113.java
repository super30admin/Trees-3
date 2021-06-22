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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        prepareList(root,result,new ArrayList<Integer>(),targetSum);
        return result;
    }
    
    public static void prepareList(TreeNode root, List<List<Integer>> result ,ArrayList<Integer> tempList, int targetSum){
        if(root==null){
            return;
        }
        tempList.add(root.val);
        
        if(root.left==null && root.right == null && targetSum == root.val){
                result.add(new ArrayList<Integer>(tempList));
            } 
        else {
                prepareList(root.left,result,tempList,targetSum-root.val);
                prepareList(root.right,result,tempList,targetSum-root.val);
            }
        
        tempList.remove(tempList.size()-1);
        
    }
    
}