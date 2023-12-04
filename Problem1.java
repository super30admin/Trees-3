// Time Complexity : O(n)
// Space Complexity : O(H) height of the tree in stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//to find the target sum paths. in addition to current sum , use another variable to
// record paths at each node and when ever recursion reaches to leaf node
//check the target sum and add to list

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Problem1 {
    int currSum;
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        currSum = 0;
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, targetSum, currSum, path);
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if (root == null) return;

        currSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && currSum == targetSum) {
            result.add(new ArrayList<>(path));
        }

        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Problem1 pathSumFinder = new Problem1();

        // Constructing a sample tree
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

        List<List<Integer>> result = pathSumFinder.pathSum(root, targetSum);

        // Print the result
        for (List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
