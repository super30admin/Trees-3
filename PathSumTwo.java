
// Time complexity : O(n), n -> no of nodes in the binary tree
// Space complexity : O(h), h -> height of the binary tree
import java.util.*;

class TreeNode {
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

public class PathSumTwo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        List<List<Integer>> result = pathSum(root, targetSum);
        System.out.println(result);
    }

    private static List<List<Integer>> result;

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private static void helper(TreeNode root, int currSum, int targetSum, List<Integer> path) {
        if (root == null)
            return;
        currSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<Integer>(path));
            }
        }
        helper(root.left, currSum, targetSum, path);
        helper(root.right, currSum, targetSum, path);
        // Backtrack
        path.remove(path.size() - 1);
    }

}
