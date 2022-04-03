// Time Complexity : O(nodes)
// Space Complexity : O(nodes)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach
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
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        inorder(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    private void inorder(TreeNode root, int sum, List<Integer> path, int t)
    {
        //base
        if(root==null)
            return;
        
        //logic
        sum+=root.val;
        path.add(root.val);
        inorder(root.left, sum, path, t);
        
        if(root.left==null && root.right==null && sum==t)
        {
            result.add(new ArrayList<>(path));
        }
        
        inorder(root.right, sum, path, t);
        
        //backtrack
        path.remove(path.size() -1); 
        
    }
}







