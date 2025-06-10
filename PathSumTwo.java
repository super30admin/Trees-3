// Time Complexity : O(n) where n is the number of tree nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

public class PathSumTwo {
    List<List<Integer>> sol = new ArrayList<>();
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        makeTargetSum(root, 0, targetSum, list);
        return sol;
    }

    public void makeTargetSum(TreeNode node, int curr, int target, List<Integer> list) {
        if (node == null) return;

        curr += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (curr == target) sol.add(new ArrayList<>(list));
        }
        makeTargetSum(node.left, curr, target, list);
        makeTargetSum(node.right, curr, target, list);
        list.remove(list.size() - 1);
    }
    public static void main(String[] args) {
        PathSumTwo path = new PathSumTwo();
        /*       5
                / \
               4   8
              /   / \
             11  13  4
            /  \      \
           7    2      1
         Target  = 22   */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> result = path.pathSum(root, 22);
        System.out.println("Paths with sum 22:");
        for (List<Integer> i : result) {
            System.out.println(path);
        }
    }
}

