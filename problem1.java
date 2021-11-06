// 113 Path Sum II 
// soved on leetcode
// Time complexity-- O(n)
// scpace complexity -- O(n)
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
        result = new ArrayList();
        
        helper(root,targetSum,0,new ArrayList());
        return result;
    }
    
    private void helper(TreeNode root,int targetSum,int num, List<Integer> array){
        if(root==null){
            return ;
        }
        num=num+root.val;
        array.add(root.val);
        helper(root.left,targetSum,num,array);
        
        if(root.left==null && root.right==null){
            if(num==targetSum){
                result.add(new ArrayList(array));
            }
             array.remove(array.size()-1);
            return;
        }
        helper(root.right,targetSum,num,array);
        array.remove(array.size()-1);
    }
}