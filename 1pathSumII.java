// this approach has a problem because arraylist is pass by reference so it doesn't 'preserve' the state when one recursive call ends
// we can solve this in multiple ways

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int curSum, int targetSum, List<Integer> path) {
        if(root == null) {
            return;
        }
        curSum = curSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(curSum == targetSum) {
                result.add(path);
            }
        }
        helper(root.left, curSum, targetSum, path);
        helper(root.right, curSum, targetSum, path);
    }
}