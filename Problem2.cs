public class MirrorImageOfItselfTree
    {
        // Time Complexity : O(n)
        // Space Complexity : O(h)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        bool flag;
        public bool IsSymmetric(TreeNode root)
        {
            flag = true;
            dfs(root.right, root.left);
            return flag;
        }
        public void dfs(TreeNode left, TreeNode right)
        {
            //base case
            if (left == null && right == null)
                return;

            if (left == null || right == null || left.val != right.val)
            {
                flag = false;
                return;
            }

            //Logic
            if (flag)
                dfs(left.left, right.right);
            if (flag)
                dfs(left.right, right.left);
        }
    }
