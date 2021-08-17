using System;
using System.Collections.Generic;
using System.Text;

namespace Tree
{
    //previous pull request failed
    class PathSumLC
    {
        //Time Complexity: O(n)
        //Space Complexity: O(h)
        //Definition of a binary tree node
        public class TreeNode
        {
            internal int val;
            internal TreeNode left;
            internal TreeNode right;
            TreeNode() { }
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right)
            {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        List<List<int>> result;
        public List<List<int>> PathSum(TreeNode root, int targetSum)
        {
            if (root == null)
            {
                return new List<List<int>>();
            }
            result = new List<List<int>>();
            dfs(root, targetSum, new List<int>);
            return result;
        }

        private void dfs(TreeNode root, int targetSum, List<int> path)
        {
            //base
            if (root == null)
            {
                return;
            }
            //logic
            //action
            path.Add(root.val);
            if (root.left == null && root.right == null)
            {
                if (targetSum - root.val == 0)
                {
                    result.Add(new List<int>(path));
                }
            }
            //recurse
            dfs(root.left, targetSum - root.val, path);
            dfs(root.right, targetSum - root.val, path);
            //backtrack
            path.Remove(path.Count - 1);
        }
    }
}
