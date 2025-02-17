import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) + O(n*h) n is the no of nodes and h is the height
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//The worst-case time complexity is O(n * h), where n is the number of nodes and h is the height of the tree.
//In the worst case (skewed tree), the height h is O(n), making the complexity O(n²).
//In a balanced tree, h is O(log n), leading to a better complexity of O(n log n).
//The main reason for O(n * h) is the deep copy of the path list at each valid leaf node.
//In the best case (only one valid path), it is O(n).

/*
At each node, calculate the sum
check the sum only at leaf nodes and if it is equal to the target, add it to the result - deep copy
 */

/* Your code here along with comments explaining your approach in three sentences only
/*
 * Here, a global result is taken for adding all the paths that gives us the desired target sum. For every node, we add the value of node to path
 * and whenever the path current sum is equals to target sum,create deep copy of it and add it to result. Remove the last element after every
 * recursive stack. The result gives us all the paths that gives target sum.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class PathSum2 {
    List<List<Integer>> result;

    int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result = new ArrayList<>();

        target = sum;

        if (root == null) return result;

        dfs(root, 0, new ArrayList<>());

        return result;

    }

    private void dfs(TreeNode root, int currSum, List<Integer> temp) {

        // Base

        if (root == null) return;

        currSum += root.val;

        temp.add(root.val);

        if (root.left == null && root.right == null) {

            if (target == currSum) {

                result.add(new ArrayList<>(temp));

            }

        }

        // logic

        dfs(root.left, currSum, temp);

        dfs(root.right, currSum, temp);

        // backtrack

        temp.remove(temp.size() - 1);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
