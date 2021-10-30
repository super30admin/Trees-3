//Time: O(n)
//Space: O(n) - h is height of the tree, which can be equal to n
using System;
using System.Collections.Generic;

namespace Path_Sum_II
{
    public class Solution {
    IList<IList<int>> result;
    public Solution(){
        result = new List<IList<int>>();
    }
    
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        List<int> list = new List<int>();
        int sum=0;
        Helper(root, list, sum, targetSum);
        return result;
    }
    
        void Helper(TreeNode root, List<int> list, int sum, int target){
            if(root == null) {
                return;
            }
            if(root.left == null && root.right == null){
                sum += root.val;
                list.Add(root.val);
                if(sum == target) {
                    result.Add(new List<int>(list));
                }
                list.RemoveAt(list.Count - 1);
                return;
            }
            list.Add(root.val);
            sum += root.val;
            Helper(root.left, list, sum, target);
            Helper(root.right, list, sum, target);
            list.RemoveAt(list.Count - 1);
            return;
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

            Solution s = new Solution();
            IList<IList<int>> result = s.PathSum(five, 22);
           
          
            Console.WriteLine("Hello World!");
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
