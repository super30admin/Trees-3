// Time Complexity : O(n)
// Space Complexity : O(n * h)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

//https://leetcode.com/problems/path-sum-ii/description/

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
        
        DFS(root, targetSum, 0, new List<int>());
        return result;
    }

    public void DFS(TreeNode node, int targetSum, int currentSum, List<int> path ){
        //base case
        if(node == null) return;
        //List<int> list = new List<int>(path); //deep copy gives O(n)
        //list = path; //shallow copy
        //action
        currentSum += node.val;
        path.Add(node.val);

        if (node.left == null && node.right == null) {
            if(currentSum == targetSum){
                result.Add(new List<int>(path));
            }
        }
        //recruse
        DFS(node.left, targetSum, currentSum, path);
        DFS(node.right, targetSum, currentSum, path);
        //backtracking
        path.RemoveAt(path.Count - 1);
    }
}