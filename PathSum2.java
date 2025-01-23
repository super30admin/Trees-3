// TC: O (n)
// SC: O (h)

/*
 * Note that values, the list, is passed by reference in this problem
 * So, while keeping track of the curr sum and values as we do a dfs over the tree,
 * make sure to
 * a) create a copy of the values list when adding to result
 * b) backtrack by removing the last added value after the node is processed
 */
import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    //Definition for a binary tree node.
    public class TreeNode {
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

    List<List<Integer>> result = new ArrayList<>();
    int targetSum;

    private void findPathSum(TreeNode root, int currSum, List<Integer> values) {
        if (root == null) return;
        currSum += root.val;
        values.add(root.val);
        if (root.left == null && root.right == null && currSum == targetSum) {
            result.add(new ArrayList<>(values));
        }
        findPathSum(root.left, currSum, values);
        findPathSum(root.right, currSum, values);
        values.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        findPathSum(root, 0, new ArrayList<>());
        return result;
    }
}
