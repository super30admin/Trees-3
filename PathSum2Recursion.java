class Solution {
    int target;
    List<List<Integer>> result;
    private void helper(TreeNode root, int currSum, List<Integer> path) {
        if(root == null) {
            return;
        }
        currSum += root.val;
        path.add(root.val);
        List<Integer> l = new ArrayList<>(path);
        helper(root.left, currSum, l);
        if(root.left == null && root.right == null) {
            if(target == currSum) {
                result.add(path);
                return;
            }
        }
        helper(root.right, currSum, new ArrayList<>(path));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>());
        return result;
    }
}