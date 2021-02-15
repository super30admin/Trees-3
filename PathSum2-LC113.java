/**
T: O(n) as we are vising each node
S: O(d) under the hood stack, max depth of the tree 
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
    private int sum = 0;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        sum = targetSum;
        dfs(root, 0, new ArrayList<>());  
        return result;
    }
    
    public void dfs(TreeNode root, int cursum, List<Integer> path){
        //base case
        if(root == null)
            return ;
        //logic
        path.add(root.val);
        cursum += root.val;

        //check it the sum is equal to target sum and it is leaf node
        if(cursum == sum && root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
            //return if we found the path
            path.remove(path.size() - 1);
            return;
        }
            
        dfs(root.left, cursum, path);        
        dfs(root.right, cursum, path);
        path.remove(path.size() - 1);
    }
}