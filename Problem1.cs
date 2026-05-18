// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
    I perform dfs on the tree. I maintain a global variable result which is a list of list of integer. I also maintain sumSoFar and temp list of integer as variables of the recursive function. 
    In the helper function, I return if root is null. If it's a leaf node, I check if the sumSoFar = target sum, if so I add the list formed to the final resultant list. I backtrack by removing the
    last element of the temp list after recursive calls on both the left child and right child has been performed.
*/

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
public class Solution
{
    private List<IList<int>> result;
    public IList<IList<int>> PathSum(TreeNode root, int targetSum)
    {
        result = new();

        if (root == null)
        {
            return result;
        }

        Helper(root, targetSum, 0, new List<int>());
        return result;
    }

    public void Helper(TreeNode root, int targetSum, int sumSoFar, List<int> temp)
    {
        if (root == null)
        {
            return;
        }

        sumSoFar += root.val;
        temp.Add(root.val);

        if (root.left == null && root.right == null)
        {
            if (sumSoFar == targetSum)
                result.Add(new List<int>(temp));

        }

        Helper(root.left, targetSum, sumSoFar, temp);
        Helper(root.right, targetSum, sumSoFar, temp);

        temp.RemoveAt(temp.Count - 1);
    }
}