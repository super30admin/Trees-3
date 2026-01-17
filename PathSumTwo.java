// Time Complexity : O(N), Need to visit all nodes in the tree.
// Space Complexity : O(h), height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Backtracking is space optimization here, better than passing new arraylist to the left and right child and causing
// the copying of curr path again and again.

// Approach :
// We can pass the current node val to left and the right child. At the leaf node, we will check if the current sum is
// equal to the target sum. Add the current path to the result array. Since current path is passed by reference, any changes
// made to current path will update the existing current path added to the result. To avoid that we will create new list
// from current path and add it to result.
// Also since the current path will contain all the nodes from root node to left child, to calculate the correct path,
// at right child we should back track/pop off the last node added in the current path.
import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {
    // We can share the result and targetSum variables as global because they are not getting updated and need to be used
// by all recursion calls.

    List<List<Integer>> result = new ArrayList<>();
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return result;
        this.targetSum = targetSum;
        pathSumWithPath(root, 0, new ArrayList<>());
        return result;
    }

    private void pathSumWithPath(TreeNode root, int currentSum, List<Integer> currPath) {
        if (root == null) return;

        currentSum += root.val;
        currPath.add(root.val);
        if (root.left == null && root.right == null && currentSum == targetSum) {
            result.add(new ArrayList<>(currPath));
            //If we are back tracking dont return here, will skip the back tracking operation
        }
        pathSumWithPath(root.left, currentSum, currPath);
        pathSumWithPath(root.right, currentSum, currPath);
        // Back tracking to a state before the left and right child recursions were done. We are removing the last
        // node added to the path
        currPath.removeLast();
    }
}
