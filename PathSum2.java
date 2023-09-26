import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> path = new ArrayList<>();
        inOrder(root, 0, targetSum, path);
        return list;
    }

    private void inOrder(TreeNode root, int sum, int targetSum, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        inOrder(root.left, sum + root.val, targetSum, path);
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                list.add(new ArrayList<>(path));
            }
        }
        inOrder(root.right, sum + root.val, targetSum, path);
        path.remove(path.size() - 1);

    }
}
