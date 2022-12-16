// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private IList<IList<int>> result;
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        result = new List<IList<int>>();
        var li = new List<int>();        
        helper(root, 0, li, targetSum);
        return result;        
    }

    public void helper(TreeNode root, int currSum, List<int> li, int targetSum)
    {
        if(root == null) return;

        li.Add(root.val);
        currSum += root.val;
                
        helper(root.left, currSum, new List<int>(li), targetSum);

        if(root.left == null && root.right == null && currSum == targetSum)
        {            
            result.Add(li);                    
        }
        helper(root.right, currSum, new List<int>(li), targetSum);
                     
    }
}
