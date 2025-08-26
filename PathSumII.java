// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int target, int currSum, List<Integer> path) {
        if(root == null) return;
        path.add(root.val);
        currSum += root.val;
        if(root.left == null && root.right == null && currSum == target) {
            result.add(new ArrayList<>(path));
        }
        helper(root.left, target, currSum, path);
        helper(root.right, target, currSum, path);
        path.remove(path.size() - 1);
    }
}