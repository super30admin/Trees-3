// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//We are passing the current some from root to thhe child node and maintaining the path
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
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        int curr = 0;
        recurr(root,targetSum,curr,output,path);
        
        return output;
    }
    
    private void recurr(TreeNode root,int target,int curr,List<List<Integer>> output,List<Integer> path){
        if(root==null){
            return;
        }
        
        curr+=root.val;
        path.add(root.val);
        
        if(root.left==null && root.right==null){
            if(curr==target){
                List<Integer> temp = new ArrayList<>(path);
                // temp = path;
                output.add(temp);
            }
            
            path.remove(path.size()-1);
            return;
        }
        recurr(root.left,target,curr,output,path);
        recurr(root.right,target,curr,output,path);
        
        path.remove(path.size()-1);
    }
    
}