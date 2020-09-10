// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Traverse the entire tree from the root and sum the value at each level until it is equal t the target sum
//2. Store the nodes that sum up to the value.

import java.util.*;

public class PathSumTwo {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        helper(root, sum, 0, curPath, res);

        return res;

    }

    public void helper(TreeNode root, int target, int curSum, List<Integer> curPath, List<List<Integer>> res) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (curSum + root.val == target) {
                List<Integer> temp = new ArrayList(curPath);
                temp.add(root.val);
                res.add(temp);
            }
        }

        curPath.add(root.val);
        helper(root.left, target, curSum + root.val, curPath, res);
        helper(root.right, target, curSum + root.val, curPath, res);

        curPath.remove(curPath.size() - 1);
    }

    public static void main(String args[]) {
        PathSumTwo obj = new PathSumTwo();
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);

        tree.left.left = new TreeNode(11);

        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);

        tree.left.left.right = new TreeNode(2);
        System.out.println(obj.pathSum(tree, 22));
    }

}