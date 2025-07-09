// Time Complexity : O(n^2) -> O(n) to traverse and O(n) for copying the list
// Space Complexity : O(n^2) -> O(n) for recursive stack and O(n) for the list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach - I used a class level private list to store the result, I made a helper method to keep iterating the tree and adding nodes to the list. I reduce the target with the root value and go left and right. Finally, I backtrack by removing the element from the end of the list. Base case -> if the root is null, we reached the end, so return, if the target is 0 and it is a leaf node (left and right are null), then we add the current path to the res list. 

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<Integer>());
        return res;
    }
    private void helper(TreeNode root, int target, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            res.add(new ArrayList<>(list));
        } else {
            helper(root.left, target - root.val, list);
            helper(root.right, target - root.val, list);
        }
        list.remove(list.size() - 1);
    }
}