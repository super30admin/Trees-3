
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSumHelper(root, targetSum, ans, new ArrayList<>());
        return ans;
    }

    private void pathSumHelper(TreeNode node, int sum, List<List<Integer>> ans, List<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null && sum - node.val == 0) {
            ans.add(new ArrayList<>(path));
        }
        pathSumHelper(node.left, sum - node.val, ans, path);
        pathSumHelper(node.right, sum - node.val, ans, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        PathSumII sol = new PathSumII();
        List<List<Integer>> result = sol.pathSum(root, targetSum);

        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
