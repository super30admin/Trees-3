// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path, int target){
        //base
        if(root == null)
            return;

        //logic
        currSum += root.val;

        //action
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target)
                result.add(new ArrayList<>(path));
        }

        //recursion
        helper(root.left, currSum, path, target);
        helper(root.left, currSum, path, target);

        //backtrack
        path.remove(path.size()-1);
    }
}