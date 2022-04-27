// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        
        if(root == null) return result;
        
        dfs(root, targetSum, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int targetSum, int sum) {
        if(root == null) return;
        
        sum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && targetSum == sum) {
            result.add(new ArrayList<>(path));
        }
        
        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
        path.remove(path.size() - 1);
    }
}