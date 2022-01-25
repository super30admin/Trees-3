// Time Complexity : O(n)
// Space Complexity : O(h) , h is height of tree, worst case h = n, n - nodes in tree
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        static List<List<Integer>> res;
        int targ;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            res = new ArrayList<>();
            targ = targetSum;
            helper(root, 0, new ArrayList<>());
            return res;
        }

        private void helper(TreeNode root, int currSum, List<Integer> path) {
            //base
            if (root == null) return;

            //logic
            currSum += root.val;
            path.add(root.val);

            //st.pop internally
            if (root.left == null && root.right == null) {
                if (currSum == targ) {
                    res.add(new ArrayList<>(path));
                }
            }
            helper(root.left, currSum, path);
            helper(root.right, currSum, path);

            //backtrack
            path.remove(path.size() - 1);
        }

    public static void main(String[] args) {

        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t13 = new TreeNode(13, null, null);

        TreeNode t11 = new TreeNode(11, t7 , t2);
        TreeNode t4 = new TreeNode(4, t5 , t1);

        TreeNode t4_4 = new TreeNode(4, t11 , null);
        TreeNode t8 = new TreeNode(8, t13 , t4);

        TreeNode t5_5 = new TreeNode(5, t4 , t8);

        System.out.println("Path Sum Iteratively: " + new Path_Sum_2().pathSum(t5_5,22));

    }
}
