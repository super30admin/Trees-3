// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Backtracking solution
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList());
        return result;
    }
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> subArray) {
        if(root == null) return;
        subArray.add(root.val);
        // if leaf node is reached, we check the sum of that path
        if(root.left == null && root.right == null) {
            if(currSum+root.val == targetSum) {
                result.add(new ArrayList<>(subArray));
            }
        }
        helper(root.left, targetSum, currSum+root.val, subArray);
        helper(root.right, targetSum, currSum+root.val, subArray);
        // we are backtracking, meaning once the leaf node is done, we start removing the last visited node,
        // and go up to the start of left subtree
        subArray.remove(subArray.size()-1);
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList());
        return result;
    }
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> subArray) {
        if(root == null) return;
        subArray.add(root.val);
        // if leaf node is reached, we check the sum of that path, then add to the result
        if(root.left == null && root.right == null) {
            if(currSum+root.val == targetSum) {
                result.add(subArray);
            }
        }
        // on every iteration we create a new list and copy values from previous,
        // so the space complexity would be O(N^2)
        helper(root.left, targetSum, currSum+root.val, new ArrayList<>(subArray));
        helper(root.right, targetSum, currSum+root.val, new ArrayList<>(subArray));
    }
}