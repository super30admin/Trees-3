import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//113. Path Sum II
//https://leetcode.com/problems/path-sum-ii/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Problem1 {

    List<List<Integer>> li = new ArrayList<>();

    public void setLi(List<List<Integer>> li) {
        this.li = li;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, targetSum, path, 0);
        return li;
    }

    private void helper(TreeNode root, int targetSum, ArrayList<Integer> path, int curr) {
        // base
        if (root == null)
            return;

        // logic
        path.add(root.val);
        helper(root.left, targetSum, new ArrayList<Integer>(path), (curr + root.val));
        if (root.left == null && root.right == null && (curr + root.val == targetSum)) {
            li.add(path);
        }

        helper(root.right, targetSum, new ArrayList<Integer>(path), (curr + root.val));
    }
}