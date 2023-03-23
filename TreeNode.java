import java.util.List;
import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h); h = height of tree
// Did this code run on leetcode? : Yes
class Solution {
    List<List<Integer>> result;

    private void pathSumHelper(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        // base case
        if(root == null) {
            return;
        }

        // logic
        path.add(root.val);

        if(
            // Leaf node
            root.left == null && root.right == null && 
            // root-to-leaf path sum equals target
            (currSum + root.val == targetSum)
        ) {
            result.add(new ArrayList<>(path));
        }

        pathSumHelper(root.left, currSum + root.val, new ArrayList<>(path), targetSum);
        pathSumHelper(root.right, currSum + root.val, new ArrayList<>(path), targetSum);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        pathSumHelper(root, 0, new ArrayList<>(), targetSum);

        return result;
    }
}