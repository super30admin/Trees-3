// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
class PathSumTwo {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res =  new ArrayList<>();
        
        dfs(root, targetSum, new ArrayList<>(), 0);
        return res;
    }
    
    private void dfs(TreeNode root, int targetSum, List<Integer> temp, int currentSum) {
        
        if(root==null)
            return;
        
        currentSum+=root.val;
        temp.add(root.val);
        
        if(root.left==null && root.right==null) {
            if(currentSum == targetSum){
                res.add(new ArrayList<>(temp));
            }
        }
        
        dfs(root.left, targetSum, temp, currentSum);
        dfs(root.right, targetSum, temp, currentSum);
        
        temp.remove(temp.size()-1);
        
    }
}
