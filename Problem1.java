// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Here the catch is that we are working with reference. So when we go back to a node
 * our path still has the node we are coming from. The solution to this is, either we can maintain
 * copies of the path at each node. But that will not be efficient. To optimize on that we can
 * backtrack. We can remove the last element from our path whenever moving back.
 */


public class Problem1 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode root, int targetSum, int curSum, List<Integer> path) {
        //base
        if(root == null) return;

        //logic
        curSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(curSum == targetSum) res.add(new ArrayList<>(path));
        }

        helper(root.left, targetSum, curSum, path);
        helper(root.right, targetSum, curSum, path);

        //backtrack
        path.remove(path.size() - 1);
    }
}
