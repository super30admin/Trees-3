// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Node

public class PathSumTwo {
    class Solution {
        private List<List<Integer>> result;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();
            helper(root, targetSum, 0, new ArrayList<>());
            return result;
        }
        private void helper(TreeNode root, int targetSum, int curSum, List<Integer> path){
            if(root == null)
                return;

            path.add(root.val);

            curSum += root.val;

            if(root.left == null && root.right == null && (curSum == targetSum)){
                List<Integer> sumPath = new ArrayList<>(path);
                result.add(sumPath);
            }

            helper(root.left, targetSum, curSum, path);
            helper(root.right, targetSum, curSum, path);

            path.remove(path.size() - 1);
        }
    }
}
