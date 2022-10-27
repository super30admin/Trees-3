// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        public List<List<Integer>> res;
        public List<Integer> sum;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            res = new ArrayList<>();
            sum = new ArrayList<>();
            pathSumR(root, targetSum);
            return res;
        }

        private void pathSumR(TreeNode root, int psum){


            if(root == null){
                return;
            }

            sum.add(root.val);

            if(root.left == null && root.right == null){
                if(psum == root.val){
                    res.add(new ArrayList<>(sum));
                }
            }

            pathSumR(root.left, psum - root.val);
            pathSumR(root.right, psum - root.val);

            sum.remove(sum.size()-1);

        }
    }
