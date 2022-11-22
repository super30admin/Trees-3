import java.util.*;

//TC is O(n)
//SC is O(h) = O(logn)
class Solution {
    List<List<Integer>> res;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        target = targetSum;
        res = new ArrayList<>();

        recurse(root, 0, new ArrayList<>());
        return res;

    }

    private void recurse(TreeNode root, int sum, List<Integer> path) {
        // base case
        if (root == null) {
            return;
        }

        sum = sum + root.val;

        // action
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
        }

        // recurse
        recurse(root.left, sum, path);
        recurse(root.right, sum, path);

        // backtrack
        path.remove(path.size() - 1);
    }
}
