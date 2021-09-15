// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // intialize list to be returned
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // call the recursive function
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int targetSum, int currentSum, List<Integer> path){
        // check the base condition
        if(root == null) return;
        // Add root's value to path list
        path.add(root.val);
        // update current sum
        currentSum += root.val;
        // check for leaf node and check if target is achieved
        if(root.left == null && root.right == null){
            if(currentSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        // call the funtion recursively for root's left child
        helper(root.left, targetSum, currentSum, path);
        // call the funtion recursively for root's right child
        helper(root.right, targetSum, currentSum, path);
        //backtracking
        path.remove(path.size() - 1);
    }
}