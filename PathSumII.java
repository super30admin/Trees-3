//Time Complexity : O(N)
//Space Complexity: O(h) height of tree
//Leetcode: Yes

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    /**
     * Definition for a binary tree node. */
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
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            if (root == null) {
                return result;
            }
            List<Integer> path = new ArrayList<Integer>();
            helper(root, targetSum, path);
            return result;

        }

        public void helper(TreeNode root, int targetSum, List<Integer> path) {

            if (root == null) {
                return;
            }
            path.add(root.val);

            if (root.left == null && root.right == null && targetSum -root.val == 0) {
                result.add(new ArrayList<>(path));
            }

            helper(root.left, targetSum - root.val, path);
            helper(root.right, targetSum -root.val, path);
            //if we come here that means this node is not forming the path equal to target so remove the node from the answer
            path.remove(path.size() -1);

        }
    }
}
