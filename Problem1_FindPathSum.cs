// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
    IList<IList<int>> result;
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        this.result = new List<IList<int>>();
        FindPathSum(root, targetSum, 0, new List<int>(), -1);
        return this.result;
    }

    private void FindPathSum(TreeNode root, int targetSum, int sum, List<int> list, int index) {
        //base
        if(root == null) return;

        //Action
        sum += root.val;
        index++;
        list.Add(root.val);
        
        //At leaf node, compare the path sum with targetSum
        if(root.left == null && root.right == null) {
            if(sum == targetSum) {
                var pathList = new List<int>();
                foreach(var num in list) {
                    pathList.Add(num);
                }
                result.Add(pathList);
            }
        }

        //Traverse Left
        FindPathSum(root.left, targetSum, sum, list, index);

         //Traverse Right
        FindPathSum(root.right, targetSum, sum, list, index);

        //Backtracking
        list.RemoveAt(index);
        index--;
    }
}