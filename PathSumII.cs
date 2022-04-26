using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{

    public class PathSumII
    {
        /*
         * T.C: O(N) traversing through all the elements of tree
         * S.C: O(h) h is hight of tree
         */
        IList<IList<int>> Sum = new List<IList<int>>();
        public IList<IList<int>> PathSum(TreeNode root, int targetSum)
        {

            if (root == null)
                return Sum;

            helper(root, new List<int>(), targetSum, 0);

            return Sum;
        }

        private void helper(TreeNode root, List<int> path, int targetSum, int currSum)
        {
            if (root == null)
                return;

            currSum = currSum + root.val;

            path.Add(root.val);

            if (root.left == null && root.right == null)
            {
                if (currSum == targetSum)
                {

                    Console.WriteLine(path.ToArray());
                    Sum.Add(new List<int>(path));
                }
            }


            helper(root.left, path, targetSum, currSum);
            helper(root.right, path, targetSum, currSum);


            path.RemoveAt(path.Count - 1);
        }
    }
}
