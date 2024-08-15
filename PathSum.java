// Problem 113. Path Sum II
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class PathSum {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        helper(root, 0, targetSum);
        return result;
    }
    private void helper(TreeNode root, int currSum, int targetSum){
        // base
        if(root == null){
            return;
        }
        // logic
        currSum += root.val;
        // action
        path.add(root.val);
        // Leaf checking logic
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, currSum, targetSum);
        helper(root.right, currSum, targetSum);
        path.remove(path.size()-1);
    }
}
