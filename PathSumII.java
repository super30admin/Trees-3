import java.util.ArrayList;
import java.util.List;

/**
 * PathSumII solves the Path Sum II problem using a recursive DFS approach.
 *
 * Approach:
 * - Recursively traverses the binary tree, maintaining a path list and the remaining target sum.
 * - At each node, creates a copy of the current path, adds the node's value, and recurses into left and right children with the updated sum.
 * - If a leaf node is reached and the remaining sum equals the node's value, the current path (including the leaf) is added to the result list.
 * - Uses path copying at each recursive call, so no explicit backtracking is needed.
 *
 * Time Complexity:
 * - O(N), where N is the number of nodes in the tree. Each node is visited once. Path copying at leaves is O(H), where H is the height of the tree.
 *
 * Space Complexity:
 * - O(H), where H is the height of the tree, due to the recursion stack.
 * - Additional space for storing all valid paths, which can be O(N) in the worst case if all nodes are leaves.
 */

public class PathSumII {

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

        if (node.left == null & node.right == null) {
            if (targetSum - node.val == 0) {
                List<Integer> list = new ArrayList<>(path);
                list.add(node.val);
                result.add(list);
            }
            return;
        }
        //logic
        List<Integer> list = new ArrayList<>(path);
        list.add(node.val);
        helper(node.left, targetSum - node.val, list, result);
        helper(node.right, targetSum - node.val, list, result);
    }
}
