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

Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
 */
class Solution 
{
    List<List<Integer>> output = new ArrayList<>();
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) 
    {
        pathSum(root, sum, 0, new ArrayList<>());
        
        return output;
    }
    
    private void pathSum(TreeNode root, int sum, int currentSum, List<Integer> current)
    {
        if(root == null) return;
        
        current.add(root.val);
        
        if(root.left == null && root.right == null)
        {
            if(currentSum + root.val == sum)
                output.add( new ArrayList<>(current) );
        }
        pathSum( root.left, sum, currentSum + root.val, current);
        pathSum( root.right, sum, currentSum + root.val, current);
        
        int removeIndex = current.size() -1;
        
        current.remove( removeIndex);
    }
}