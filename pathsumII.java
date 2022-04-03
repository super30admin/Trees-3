/*

 Time Complexity : O(n^2) where n is numbers of nodes in the tree
 Space Complexity : O(n)   here n is arraylist which stores element.  as our output has list<list>> I am not counting that
  space in space complexity.

 Did this code successfully run on Leetcode : Yes


*/

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

class pathsumII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        helper(root, targetSum, new ArrayList(), 0);
        return result;
    }

    public void helper(TreeNode root, int target, List<Integer> list, int currSum) {
        // base case
        if (root == null)
            return;

        currSum += root.val;
        list.add(root.val);
        // checking if root has it's leaf
        if (root.left == null && root.right == null) {

            if (target == currSum) {

                result.add(new ArrayList(list));
                return;
            }

        }
        // recursive call
        helper(root.left, target, list, currSum);

        helper(root.right, target, list, currSum);

        // removing the last element
        list.remove(list.size() - 1);

    }
}