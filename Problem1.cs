public class Solution
    {
        // Time Complexity : O(n) - traverse all nodes
        // Space Complexity : O(h) - h is height of the tree- recursion stack will at the max have h function calls
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        IList<IList<int>> result;
        public IList<IList<int>> PathSum(TreeNode root, int targetSum)
        {
            result = new List<IList<int>>();
            helper(root, targetSum, 0, new List<int>());
            return result;
        }

        public void helper(TreeNode root, int targetSum, int currSum, List<int> path)
        {
            //Base case
            if (root == null) return;

            currSum = currSum + root.val;
            //action
            path.Add(root.val);
            //Console.WriteLine(root.val);
            if (root.left == null && root.right == null)
            {
                if (currSum == targetSum)
                {
                    List<int> resPath = new List<int>();
                    for (int i = 0; i < path.Count; i++)
                    {
                        resPath.Add(path[i]);
                        Console.WriteLine(path[i]);
                    }
                    Console.WriteLine();
                    result.Add(resPath);
                }
            }

            //recurse
            helper(root.left, targetSum, currSum, path);

            helper(root.right, targetSum, currSum, path);

            //backtrack
            path.RemoveAt(path.Count - 1);

        }
    }
