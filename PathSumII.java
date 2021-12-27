// Time Complexity : O(n^2)
// Space Complexity : O(h)

// Backtracking
public class PathSumII {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        dfs(root, targetSum, 0, new ArrayList<>());
        
        return result;
    }
    
    private void dfs(TreeNode root, int targetSum, int currSum , List<Integer> path)
    {
        // base case
        if(root == null)
            return;
        
        // recursive case
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum)
        {
            result.add(new ArrayList<>(path));
        }
        
        dfs(root.left, targetSum, currSum, path);
        dfs(root.right, targetSum, currSum, path);
        path.remove(path.size()-1);
    }
}