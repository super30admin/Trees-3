import java.util.*;

public class Path_Sum_2 {

// Approach: Recursion and backtracking
    // Time: O(n^2) - n for recursion and n for copying path to paths list, Space: O(n) for path list

    List<List<Integer>> paths;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths = new ArrayList();
        List<Integer> path = new ArrayList();
        getPaths(root, targetSum, 0, path);
        return paths;
    }

    void getPaths(TreeNode root, int targetSum, int currSum, List<Integer> path) {

        if (root == null) return;

        path.add(root.val);
        currSum += root.val;

        if (currSum == targetSum && root.left == null && root.right == null) {
            paths.add(new ArrayList(path));
        }
        else {
            getPaths(root.left, targetSum, currSum, path);
            getPaths(root.right, targetSum, currSum, path);
        }

        // backtrack - pop the node once all its subtrees are traversed and we don't get the targetSum
        path.remove(path.size() - 1);
    }
}