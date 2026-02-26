import java.util.*;

// O(n) time, O(h) space
class Solution {

    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return ans;
    }

    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path) {
        if (root == null) return;

        currSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        }

        helper(root.left, currSum, targetSum, path);
        helper(root.right, currSum, targetSum, path);

        path.remove(path.size()-1);
    }
}

class TreeNode {
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