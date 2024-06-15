using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace S30_Problems
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
        }
        // Time Complexity : O(n) number of nodes in the tree
        // Space Complexity : O(h) where h is the height of the tree
        public bool IsSymmetric(TreeNode root) {
          Stack<TreeNode> LeftStack = new Stack<TreeNode>();
          Stack<TreeNode> RightStack = new Stack<TreeNode>();
          LeftStack.Push(root);
          RightStack.Push(root);
          while(LeftStack.Count>0){
              TreeNode LeftPop = LeftStack.Pop();
              TreeNode RightPop = RightStack.Pop();
              if(LeftPop.val!=RightPop.val) return false;
              
              if(LeftPop.left == null || RightPop.right == null){
                  if(!(LeftPop.left == null && RightPop.right == null))return false;
              }
              else{
                  LeftStack.Push(LeftPop.left);
                  RightStack.Push(RightPop.right);
              }
              
              if(RightPop.left == null || LeftPop.right == null){
                  if(!(RightPop.left == null && LeftPop.right == null))return false;
              }
              else{            
                  LeftStack.Push(RightPop.left);
                  RightStack.Push(LeftPop.right);
              }
          }          
          return RightStack.Count == 0;
      }

      // Time Complexity : O(n) number of nodes in the tree
      // Space Complexity : O(h) where h is the height of the tree
      IList<IList<int>> res= new List<IList<int>>();
      IList<int> currentPath = new List<int>();
      public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
          if(root == null) return res;
          helper(root, targetSum, 0);
          return res;
      }
      public void helper(TreeNode curr, int targetSum, int currSum){
          currSum+= curr.val;
          currentPath.Add(curr.val);
          if(currSum == targetSum && curr.left == null & curr.right == null){
              res.Add(new List<int>(currentPath));
              currentPath.RemoveAt(currentPath.Count-1);
              return;
          }
          if(curr.left!=null) helper(curr.left, targetSum, currSum);
          if(curr.right!=null) helper(curr.right, targetSum, currSum);
          currentPath.RemoveAt(currentPath.Count-1);
      }
  }
}
