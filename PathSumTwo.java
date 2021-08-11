class Solution {
    int target;
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        result = new ArrayList<>();
        target = targetSum;
        helper(root, 0, new ArrayList<>());
        return result;

    }

    private void helper(TreeNode root, int currSum, List<Integer> path) {

        //base case
        if (root == null) return;

        currSum += root.val;
        //action
        path.add(root.val);
        helper(root.left, currSum, path);

        if (root.left == null && root.right == null) {
            if (target == currSum) {
                result.add(new ArrayList<>(path));
            }
        }

        //recurse
        helper(root.right, currSum, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}