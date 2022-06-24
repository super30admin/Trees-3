//Time : O(n)
//Space : O(h)

public class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path, int target) {
        // base
        if (root == null)
            return;
        // logic

        currSum += root.val;
        path.add(root.val);
        helper(root.left, currSum, path, target);
        if (root.left == null && root.right == null) {
            if (currSum == target) {
                result.add(new ArrayList<>(path));
            }

        }
        helper(root.right, currSum, path, target);
        path.remove(path.size() - 1);
    }
}
