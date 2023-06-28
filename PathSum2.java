// Time Complexity : O(N)
// Space Complexity : O(H) H is height of tree
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach: Here the helper method takes the current node, the current sum, the target sum, and a list path representing the current path. And At each node, it adds the node's value to the currSum and adds the node's value to the path. If the current node is a leaf node (both left and right children are null), it checks if the currSum equals the targetSum. If they are equal, we add a copy of the path to the result list.
// WE recursively calls the helper method on the left and right child nodes, passing the updated currSum and path and after the recursive calls remove the last element from the path to backtrack and explore other paths.

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSum2 {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetsum, List<Integer> path) {
        // base
        if (root == null)
            return;

        // logic
        currSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == targetsum) {
                result.add(new ArrayList<>(path));
            }
        }
        // recurse
        helper(root.left, currSum, targetsum, path);
        helper(root.right, currSum, targetsum, path);

        // backtrack
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        // Create the tree
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

        // Calculate the path sums
        PathSum2 obj = new PathSum2();
        List<List<Integer>> paths = obj.pathSum(root, targetSum);

        // Display the path sums
        System.out.println("Paths with sum " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
