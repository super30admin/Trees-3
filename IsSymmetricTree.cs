using System;
using System.Collections.Generic;
using System.Text;

namespace Tree
{
    class IsSymmetricTree
    {
        //Time Complexity: O(n)
        //Space Complexity: O(h)
        //Definition of a binary tree node
        public class TreeNode
        {
            internal int val;
            internal TreeNode left;
            internal TreeNode right;
            public TreeNode() { }
            public TreeNode(int val) { this.val = val; }
            public TreeNode(int val, TreeNode left, TreeNode right)
            {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        public bool IsSymmetric(TreeNode root)
        {
            if (root == null)
            {
                return true;
            }
            return helper(root.left, root.right);
        }

        private bool helper(TreeNode left, TreeNode right)
        {
            //base
            if (left == null && right == null)
            {
                return true;
            }
            if (left == null || right == null || left.val != right.val)
            {
                return false;
            }
            return helper(left.left, right.right) && helper(left.right, right.left);
        }

        public bool IsSymmetricIterative(TreeNode root)
        {
            if (root == null)
            {
                return true;
            }
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.Push(root.left);
            s.Push(root.right);
            while (s.Count != 0)
            {
                TreeNode left = s.Pop();
                TreeNode right = s.Pop();
                if (left == null && right == null)
                {
                    continue;
                }
                if (left == null || right == null || left.val != right.val)
                {
                    return false;
                }
                s.Push(left.left);
                s.Push(right.right);
                s.Push(left.right);
                s.Push(right.left);
            }
            return true;
        }


    }
}
