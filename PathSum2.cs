// time complexity - O(n)
// spcae complexity - O(H) in case of balanced tree it is O(logn) else O(n) for skewed tree
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
    IList<IList<int>> result = new List<IList<int>>();
    public IList<IList<int>> PathSum(TreeNode root, int targetSum)
    {
        helper(root, 0, targetSum, new List<int> { });
        return result;
    }
    public void helper(TreeNode root, int currSum, int targetSum, List<int> path)
    {
        // base
        if (root == null)
        {
            return;
        }
        // action
        currSum += root.val;
        path.Add(root.val);
        if (root.left == null && root.right == null)
        {
            if (currSum == targetSum)
            {
                result.Add(new List<int>(path));
            }
        }
        // resurse
        helper(root.left, currSum, targetSum, path);
        helper(root.right, currSum, targetSum, path);
        // backtrack

        path.RemoveAt(path.Count - 1);
    }
}