/*
Time Complexity: O(N) where N is the number of nodes in the tree.
Space Complexity: O(h) where h is the height of the tree.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: I used a depth-first search (DFS) approach to traverse the tree and keep track of the current path and the remaining sum. When I reach a leaf node, I check if the path sum equals the target sum.
*/

import java.util.*;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        pathSumHelper(root, new ArrayList<Integer>(), sum, paths);
        return paths;

    }

    public void pathSumHelper(TreeNode root, ArrayList<Integer> current, int sum, List<List<Integer>> paths) {

        if (root == null)
            return;
        current.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {// found it and it is a leaf node
            paths.add(current);
            return;
        }

        pathSumHelper(root.left, new ArrayList<Integer>(current), sum - root.val, paths);
        pathSumHelper(root.right, new ArrayList<Integer>(current), sum - root.val, paths);
    }

}
