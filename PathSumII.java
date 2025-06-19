/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 * 
 * Approach: Depth-First Search (DFS)
 * 1. Traverse the tree recursively using DFS.
 * 2. Maintain a running sum and a list representing the current path.
 * 3. When a leaf node is reached and the running sum equals targetSum, add a copy of the path to the result list.
 * 4. After exploring both children, backtrack by removing the current node from the path.
 * 5. Continue exploring until all paths from root to leaves are checked.
 * 
 * This recursive approach explores all root-to-leaf paths and collects those that match the target sum.
 * 
 * Time Complexity: 
 * - O(N) for visiting all nodes during DFS traversal, where N is the number of nodes.
 * - In the worst case, up to O(2^H) valid paths can exist (e.g., in a balanced binary tree).
 * - Copying each path takes O(H), so total copying cost can be O(2^H * H).
 * - Therefore, total time complexity: O(N + 2^H * H), where H is the height of the tree.
 * 
 * Space Complexity:
 * - O(H) for the recursion stack (in the worst case of a skewed tree).
 */
public class PathSumII {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        dfs(root, targetSum, 0, new ArrayList<>());
        return res;
    }

    /**
     * Depth-First Search to find all paths from root to leaf nodes
     * where the sum of the node values equals the target.  
     * 
     * @param root The current node in the binary tree
     * @param target The target sum to be achieved by the path
     * @param currSum The current sum of the path from root to the current node
     * @param path The current path from root to the current node
     * This method explores all paths recursively and adds valid paths to the result list.
     * It uses backtracking to remove the last node from the path after exploring both left and right children.
     * 
     */

    private void dfs(TreeNode root, int target, int currSum, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        currSum = currSum + root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && currSum == target) {
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, target, currSum, path);
        dfs(root.right, target, currSum, path);

        path.remove(path.size() - 1);
    }
}
