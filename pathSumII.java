//TC - O(N)
//SC - O(N)
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
     int target;
     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         
         res = new ArrayList<>();
         target = targetSum;
         
         helper(root,0,new ArrayList<>());
         
         return res;
         
     }
     
     private void helper(TreeNode root,int sum, List<Integer> path){
         
         //base
         if(root==null){
             return;
         }
         //logic
         path.add(root.val);
         sum = sum+root.val;
         
         if(root.left==null && root.right==null){
             if(sum==target){
                 res.add(new ArrayList<>(path));    
             }
             //return;
         }
         
         helper(root.left,sum,path);
         helper(root.right,sum,path);
         
         //backTrack
         
         path.remove(path.size()-1);
         
     }
     
 }