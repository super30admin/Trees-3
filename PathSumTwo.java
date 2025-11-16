import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        if (root.val == targetSum && root.left == null && root.right == null) {
            List<Integer> res = new ArrayList<>();
            res.add(root.val);
            result.add(res);
            return result;
        }

        helper(root, Integer.MIN_VALUE, targetSum, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(TreeNode curr, int runningSum, int targetSum, List<Integer> path, List<List<Integer>> result) {
        // base case
        if (curr == null) {
            return;
        }

        if (runningSum == Integer.MIN_VALUE) { // handle first call
            runningSum = 0;
        }

        // logic
        runningSum += curr.val;
        path.add(curr.val);

        if (runningSum == targetSum && curr.left == null && curr.right == null) {
            result.add(new ArrayList<>(path));
        }

        // check left
        helper(curr.left, runningSum, targetSum, path, result);

        // check right
        helper(curr.right, runningSum, targetSum, path, result);

        // backtrack
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        PathSumTwo pathSumTwo = new PathSumTwo();
        TreeNode root = pathSumTwo.new TreeNode(5);
        root.left = pathSumTwo.new TreeNode(4);
        root.right = pathSumTwo.new TreeNode(8);
        root.left.left = pathSumTwo.new TreeNode(11);
        root.left.left.left = pathSumTwo.new TreeNode(7);
        root.left.left.right = pathSumTwo.new TreeNode(2);
        root.right.left = pathSumTwo.new TreeNode(13);
        root.right.right = pathSumTwo.new TreeNode(4);
        root.right.right.right = pathSumTwo.new TreeNode(1);
        root.right.right.left = pathSumTwo.new TreeNode(5);

        int targetSum = 22;
        List<List<Integer>> result = pathSumTwo.pathSum(root, targetSum);
        System.out.println(result);

        // input [1,2]
        TreeNode root2 = pathSumTwo.new TreeNode(1);
        root2.left = pathSumTwo.new TreeNode(2);
        int targetSum2 = 0;
        List<List<Integer>> result2 = pathSumTwo.pathSum(root2, targetSum2);
        System.out.println(result2);

        // target sum 1
        int targetSum4 = 1;
        List<List<Integer>> result4 = pathSumTwo.pathSum(root2, targetSum4);
        System.out.println(result4);

        // input [1] sum=1
        TreeNode root3 = pathSumTwo.new TreeNode(1);
        int targetSum3 = 1;
        List<List<Integer>> result3 = pathSumTwo.pathSum(root3, targetSum3);
        System.out.println(result3);
    }

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
}