using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class Tree_IsSymmetric
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Based on class
        public bool IsSymmetric(TreeNode root)
        {
            return isMirror(root, root);
        }

        private bool isMirror(TreeNode t1, TreeNode t2)
        {
            if (t1 == null && t2 == null) return true;
            if (t1 == null || t2 == null) return false;
            return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }


        public bool IsSymmetric_Iterative(TreeNode root)
        {

            Stack<TreeNode> st = new Stack<TreeNode>();
            st.Push(root);
            st.Push(root);
            while (st.Count != 0)
            {
                TreeNode t1 = st.Pop();
                TreeNode t2 = st.Pop();
                if (t1 == null && t2 == null) continue;
                if (t1 == null || t2 == null) return false;
                if (t1.val != t2.val) return false;
                st.Push(t1.left);
                st.Push(t2.right);
                st.Push(t1.right);
                st.Push(t2.left);
            }
            return true;
        }
    }
}
