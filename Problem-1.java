import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We maintain currPath & currSum at every node
// We don't create seperate object of currPath & currSum at each node instead
// We use backtracking while traversing the tree
// when at leaf node & (currSum == target) -> add currPath to final result
class PathSum2 {
    List<List<Integer>> result;
    int target;
    int currSum;
    List<Integer> currPath;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        currPath = new ArrayList<Integer>();
        target = targetSum;

        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        // base
        if (root == null)
            return;

        // logic
        currSum += root.val;
        currPath.add(root.val);

        if (root.left == null && root.right == null) {
            if (currSum == target) {
                result.add(new ArrayList(currPath));
            }
        }

        helper(root.left);
        helper(root.right);

        // backtracking
        currSum -= root.val;
        currPath.remove(currPath.size() - 1);
    }
}