import java.util.*;

public class PathSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null)
            return result;

        helper(root, targetSum, 0, new ArrayList<Integer>());

        return result;
    }

    private void helper(TreeNode root, int targetSum, int currentSum, List<Integer> path) {

        if (root == null)
            return;

        path.add(root.val);
        currentSum += root.val;
        System.out.println(currentSum);
        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                result.add(path);
                return;
            }
        }

        helper(root.left, targetSum, currentSum, new ArrayList<Integer>(path));
        helper(root.right, targetSum, currentSum, new ArrayList<Integer>(path));
    }
}
