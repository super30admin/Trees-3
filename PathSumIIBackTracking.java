import java.util.ArrayList;
import java.util.List;

/**
 * Leet Code : https://leetcode.com/problems/path-sum-ii/description/
 *
 * PathSumIIBackTracking solves the Path Sum II problem using backtracking.
 *
 * Approach:
 * - Performs a depth-first traversal of the binary tree.
 * - Maintains a running path and the remaining target sum.
 * - At each node, adds the node's value to the path and subtracts from the target sum.
 * - If a leaf node is reached and the remaining sum is zero, the current path is added to the result list.
 * - After exploring both children, backtracks by removing the last node from the path.
 *
 * Time Complexity:
 * - O(N), where N is the number of nodes in the tree. Each node is visited once. Path copying at leaves is O(H), where H is the height of the tree.
 *
 * Space Complexity:
 * - O(H), where H is the height of the tree, due to the recursion stack and path list.
 * - Space for storing all paths is O(N) if all nodes are leaves.
 */
public class PathSumIIBackTracking {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void helper(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
        //base
        if (node == null) {
            return;
        }
        targetSum -= node.val;
        //action
        path.add(node.val);

        if (node.left == null & node.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }

        //recurse
        helper(node.left, targetSum, path, result);
        helper(node.right, targetSum, path, result);

        //Back Track
        path.remove(path.size() - 1);
    }
}
