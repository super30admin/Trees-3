// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PathSumSolution {
    List<List<Integer>> result;
    List<Integer> path;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        path.add(root.val);
        int currSum = sum + root.val;
        if(root.left == null && root.right == null) {
            if(currSum == target) {
                result.add(new ArrayList<>(path));
            }
        }
        
        dfs(root.left, currSum);
        dfs(root.right, currSum);
        
        path.remove(path.size() - 1);
    }
}