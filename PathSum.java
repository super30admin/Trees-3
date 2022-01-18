import java.util.ArrayList;
import java.util.List;

// TC O(N)
// SC O(h) - Average case. We could include the
// space occupied by the new lists (and hence the output) 
// in the space complexity and in that case the space would
// be O(N^2) in the worst case

public class PathSum {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }
        helper(root, new ArrayList<>(), targetSum);
        return result;
    }

    private void helper(TreeNode root, List<Integer> path, int targetSum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, path, targetSum);
        helper(root.right, path, targetSum);
        path.remove(path.size() - 1);
    }
}
