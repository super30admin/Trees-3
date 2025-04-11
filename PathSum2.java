// Time Complexity : O(N)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        //base case
        if(root == null) return;

        //ACTION
        currSum += root.val;
        path.add(root.val);       

        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        //recurse
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        //backtrack
        path.remove(path.size()-1);
    }
}