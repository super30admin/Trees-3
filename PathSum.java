// Time Complexity : O(n) the function visits each node once during DFS traversal.
// Space Complexity : h = height of the tree → space used by the recursive call stack.
        //Worst case (skewed tree): O(n)
        //Best case (balanced tree): O(log n)
        //p = number of valid paths that match the sum
        //p × m = space for storing the result list of paths.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

package practice.com;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = buildTree();
        List<List<Integer>> pathSum = pathSum(root, 22);
        System.out.println("LCA_BT: " + pathSum);
    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        getPathSum(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    static void getPathSum(TreeNode root, int sum, List<Integer> list,
                           List<List<Integer>> result) {
        if (root == null) return;

        list.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(list));
        } else {
            getPathSum(root.left, sum - root.val, list, result);
            getPathSum(root.right, sum - root.val, list, result);
        }

        list.remove(list.size() - 1);
    }

    private static TreeNode buildTree() {

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

            return root;

    }
}
