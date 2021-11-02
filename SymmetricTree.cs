//Time: O(n)
//Space: O(n)
//LeetCode:  https://leetcode.com/submissions/detail/579248126/
using System;
using System.Collections.Generic;

namespace SymmetricTree
{
    class Program
    {
        public bool IsSymmetric(TreeNode root) {
            
            if(root == null) {
                return true;
            }
            List<int> leftList = new List<int>();
            LeftHelper(root.left, leftList);
            
            List<int> rightList = new List<int>();
            RightHelper(root.right, rightList);
            
            if(rightList.Count != leftList.Count){
                return false;
            }
            for(int i=0; i<leftList.Count; i++) {
                if(leftList[i] != rightList[i]) {
                    return false;
                }
            }
            return true;
        }
        
        void LeftHelper(TreeNode root, List<int> list) {
            
            if(root == null) {
                list.Add(-1);
                return;
            }
            list.Add(root.val);
            LeftHelper(root.left, list);
            LeftHelper(root.right, list);
        }
        
        
        void RightHelper(TreeNode root, List<int> list) {
            
            if(root == null) {
                list.Add(-1);
                return;
            }
            list.Add(root.val);
            RightHelper(root.right, list);
            RightHelper(root.left, list);
        }
        static void Main(string[] args)
        {
            TreeNode seven = new TreeNode(7, null, null);
            TreeNode two = new TreeNode(2, null, null);
            TreeNode eleven = new TreeNode(11, seven, two);
            TreeNode four = new TreeNode(4, eleven, null);
            TreeNode thirteen = new TreeNode(13 , null, null);
            TreeNode five2 = new TreeNode(5, null, null);
            TreeNode one = new TreeNode(1, null, null);
            TreeNode four2 = new TreeNode(4, five2, one);
            TreeNode eight = new TreeNode(8, thirteen, four2);
            TreeNode five = new TreeNode(5, four, eight);

            Program p = new Program();
        }
    }
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
