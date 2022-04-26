using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class SymmetricTree
    {
        /*
         * T.C: O(N) travers through all elements of the tree
         * S.C: O(h) hight of the tree
         */
        public bool IsSymmetric(TreeNode root)
        {
            if (root == null) return true;

            //isValid=true;

            return DFS(root.left, root.right);

            //return isValid;
        }

        private bool DFS(TreeNode rootLeft, TreeNode rootRight)
        {
            if (rootLeft == null && rootRight == null) return true;

            if (rootLeft == null || rootRight == null || rootLeft.val != rootRight.val)
            {
                return false;
            }

            if (DFS(rootLeft.left, rootRight.right) == false)
                return false;



            return DFS(rootLeft.right, rootRight.left);
        }
    }
}
