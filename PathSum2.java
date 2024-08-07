// Time Complexity : O(n)
// Space Complexity : O(h*l) where h is the height of the tree and l is the length of the path
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

public class PathSum2 {
    List<List<Integer>> result;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.target = targetSum;
        pathSumRecursion(root, 0, new ArrayList<>());
        return result;
    }

    void pathSumRecursion(TreeNode root, int currentSum, List<Integer> path) {
        if (root == null) return;

        currentSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == target) {
                result.add(new ArrayList<>(path));
            }
        }

        pathSumRecursion(root.left, currentSum, path);
        pathSumRecursion(root.right, currentSum, path);
        path.remove(path.size() - 1);
    }
}