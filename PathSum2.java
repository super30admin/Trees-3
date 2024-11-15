// Time complexity : O(n) Each node is traversed once
// Space Complexity: O(h) where h is the height of the tree. Worst case space complexity will be O(n) fro skewed tree due to call stack and current path
// Run on Leetcode: Yes
//Any Problems faced: No

import java.util.ArrayList;
import java.util.List;
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();;
        List<Integer> currentPath = new ArrayList<>();
        dfs(root,currentPath, 0, targetSum,result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> currentPath, int cummulativeSum, int targetSum, List<List<Integer>> result){

        // base case
        if(root == null) return;

        // Add current root value to the current path and sub from target sum
        currentPath.add(root.val);
        cummulativeSum += root.val;

        // check if er have reached the leaf node or targetSum = 0
        if(root.left == null && root.right == null && targetSum ==cummulativeSum){
            result.add(new ArrayList<>(currentPath));
        } else{ //recursively call left and right function
            dfs(root.left, currentPath, cummulativeSum,targetSum, result );
            dfs(root.right, currentPath, cummulativeSum, targetSum, result );
        }
        // backtracking-  to remove the current node before going back to recurssion
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        // Creating the binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        // Setting a target sum
        int targetSum = 22;

        // Finding all paths that sum up to the target sum
        PathSum2 solution = new PathSum2();
        List<List<Integer>> paths = solution.pathSum(root, targetSum);

        // Printing the result
        System.out.println("Paths with sum " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
