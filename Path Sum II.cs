/*
  Time complexity: O(n)
  Space complexity: O(h)

  Code ran successfully on Leetcode: Yes
  
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
public class Solution {
    List<IList<int>> result;
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        result = new();
        List<int> path = new();

        helper(root,0,targetSum,path);
        return result;
    }

    private void helper(TreeNode root, int currentSum, int targetSum, List<int> path)
    {
        if(root==null) return;
        currentSum+=root.val;
        path.Add(root.val);

        if(root.left==null && root.right==null && currentSum==targetSum)
        {
            result.Add(new List<int>(path));
        }

        helper(root.left,currentSum,targetSum,path);
        helper(root.right,currentSum,targetSum,path);

        path.RemoveAt(path.Count-1);
    }
}
