// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);

    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}

///
/// /**

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, targetSum, result, path);
        return result;

    }

    private void helper(TreeNode node, int remainingsum, List<List<Integer>> result, List<Integer> path) {
        if (node == null)
            return;
        path.add(node.val);
        int newremainingsum = remainingsum - node.val;
        if (node.left == null && node.right == null) {
            if (newremainingsum == 0) {
                result.add(new ArrayList<>(path));
            }
        } else {
            helper(node.left, newremainingsum, result, path);
            helper(node.right, newremainingsum, result, path);

        }
        path.remove(path.size() - 1);
    }
}