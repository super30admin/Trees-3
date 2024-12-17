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
    List<List<Integer>> r;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.r = new ArrayList<>();
        helper(root,0,targetSum,new ArrayList<>());
        return r;
    }

    void helper(TreeNode root, int t, int target, List<Integer> path){
        if(root==null) return;
        t=t+root.val;
         List<Integer> list = new ArrayList<>(path);
       list.add(root.val);
        if(root.left==null && root.right==null){
            if(t==target)
             r.add(list);
            
            
        }

         helper(root.left,t,target,list);
         helper(root.right,t,target,list);

    }
}