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
 
 values can be negative
 
 
 root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 
 TC - O(N) N is the number of nodes in linkedlist.
 SC - O(N) N is the number of calls in the recursion stack.
 
 */
class Solution {
    
    List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        pathSumHelper(root, 0, targetSum, new ArrayList<Integer>());
        return results;
    }
    
    private void pathSumHelper(TreeNode root, int currentSum, int targetSum, List<Integer> pathResult)
    {
        if (root == null)
        {
            return;
        }
        
        // process the sum
        currentSum += root.val;
        pathResult.add(root.val);
        
        if (isLeaf(root) && currentSum == targetSum)
        {
            results.add(new ArrayList<>(pathResult));
        }
        
        // recur left
        pathSumHelper(root.left, currentSum, targetSum, pathResult);
        
        // recur right
        pathSumHelper(root.right, currentSum, targetSum, pathResult);
        
        // Backtrack
        pathResult.remove(pathResult.size() - 1);
    }
    
    private boolean isLeaf(TreeNode root)
    {
        return root.left == null && root.right == null;
    }
}
