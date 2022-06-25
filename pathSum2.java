// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {
    // define result globally
    private static List<List<Integer>> result;

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        // null case
        if (root == null)
            return result;
        // tree traversal
        helper(root, new ArrayList<>(), targetSum, 0);
        return result;
    }

    private static void helper(TreeNode root, List<Integer> list, int target, int curSum) {
        // base case
        if (root == null)
            return;

        // main logic
        // add current rootValue to the currSum
        curSum += root.val;
        // add this into the list
        list.add(root.val);
        // call recursion for left subtree
        helper(root.left, list, target, curSum);
        // if root is last node at particular level we check that if currSum is equal to
        // target we add it into the result
        if (root.left == null && root.right == null) {
            if (curSum == target) {
                // System.out.print(list);
                result.add(new ArrayList<>(list));
            }
        }
        // call recursion for right subtree
        helper(root.right, list, target, curSum);
        // after each recursion we want to get back into current State so we remove last
        // element
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        System.out.println(pathSum(root, targetSum));

    }
}