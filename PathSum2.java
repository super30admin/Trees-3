// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Approach : We use recursion to explore all the nodes while maintaining the current sum and the path at each node. Once we reach leaf node and current Sum matches the
// target we add a copy of the path to the result. As we are backtracking here, when we come across the required path, we make a copy of it and add to result to capture it's
// state.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path){
        //base case
        if(root == null){
            return;
        }
        //action
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && currSum == targetSum){
            result.add(new ArrayList<>(path));
        }
        //recurse
        helper(root.left, currSum, targetSum, path);
        helper(root.right, currSum, targetSum, path);
        //backtrack
        path.remove(path.size()-1);
    }
}