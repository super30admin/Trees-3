import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPaths(root, sum, res, path);
        return res;
    }

    private void findPaths(TreeNode root, int remSum, List<List<Integer>> res, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null && remSum == root.val) {
            res.add(new ArrayList<>(path));
        }
        findPaths(root.left, remSum - root.val, res, path);
        findPaths(root.right, remSum - root.val, res, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        PathSum2 ps = new PathSum2();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int sum = 3;

        System.out.println(ps.pathSum(root, sum).toString());
    }
}
