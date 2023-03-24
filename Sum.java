/*The time complexity of the following implementation is O(n^2)*/
import javax.swing.tree.TreeNode;
import java.util.*;

public class Sum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> currentPath = new ArrayList<>();
        pathSumHelper(root, targetSum, currentPath, result);
        return result;
    }

    private void pathSumHelper(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;
        currentPath.add(node.val);
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            pathSumHelper(node.left, targetSum - node.val, currentPath, result);
            pathSumHelper(node.right, targetSum - node.val, currentPath, result);
        }
        currentPath.remove(currentPath.size() - 1);
    }
    public static void main(String[] args) {
        // Create a binary tree
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
        Sum solution = new Sum();
        List<List<Integer>> result = solution.pathSum(root, targetSum);
        System.out.println(result);
    }

}
