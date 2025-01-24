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
    IList<IList<int>> result;
    public IList<IList<int>> PathSum(TreeNode root, int targetSum)
    {
        result = new List<IList<int>>();
        FindPathSum(root, 0, new List<int>(), targetSum);
        return result;
    }

    public void FindPathSum(TreeNode root, int currentSum, List<int> list, int targetSum)
    {
        if (root == null)
        {
            return;
        }
        currentSum += root.val;
        list.Add(root.val);
        if (root.left == null && root.right == null && currentSum == targetSum)
        {
            result.Add(new List<int>(list));
        }
        FindPathSum(root.left, currentSum, list, targetSum);
        FindPathSum(root.right, currentSum, list, targetSum);
        list.RemoveAt(list.Count - 1);
    }
}