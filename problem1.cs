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
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        IList<IList<int>> result = new List<IList<int>>();

        helper(root,0,new List<int>(),ref result,targetSum);
        return result;        
    }
    void helper(TreeNode root, int currentValue, IList<int> currentList, ref IList<IList<int>> result, int targetSum)
    {
        if(root == null) return;
        currentValue = currentValue + root.val;
        currentList.Add(root.val);
        if(root.left == null && root.right == null)
        {
            if(currentValue == targetSum)
            {
                result.Add(new List<int>(currentList));
            }
        }
        helper(root.left,currentValue,currentList,ref result,targetSum);
        helper(root.right,currentValue,currentList,ref result,targetSum);
        currentList.RemoveAt(currentList.Count - 1);
    }
}