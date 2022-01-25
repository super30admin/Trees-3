// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//traverse and store values in sum and take a list. but list last element has to be popped when backtracking

import java.util.ArrayList;
import java.util.List;

public class PathSUm {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
              TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        int tar ;
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            tar = targetSum;
            sum1(root,new ArrayList<>(), 0);
            return list;
        }
        public void sum1(TreeNode root, List<Integer> lis, int val) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                lis.add(root.val);
                val = val  + root.val;
                // System.out.println("geger" + lis + " " +val);
                if(tar == val) {
                    List<Integer> n = new ArrayList(lis) ;
                    list.add(n);
                }
                lis.remove(lis.size()-1);
            }
            if (root.left != null){

                lis.add(root.val);
                // System.out.println("beforeprint" + lis );

                sum1(root.left, lis, val  + root.val);
                lis.remove(lis.size()-1);
                // System.out.println("afterprint" + lis );

            }
            if (root.right != null){

                lis.add(root.val);
                // System.out.println("nnnprint" + lis );

                sum1(root.right, lis, val + root.val);
                lis.remove(lis.size()-1);
                // System.out.println("nnnprint" + lis );

            }
        }
    }

}
