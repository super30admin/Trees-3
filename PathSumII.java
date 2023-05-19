// Time Complexity : O(n+l)  is the
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use recurssive approach where we keep a track of sum and add to result when sum match targetSum.
 * We need to pass new ArrayList everytime in recurssive calls.
 */
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class PathSumIIRec {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int sum, int targetSum, List<Integer> path) {
        if(root == null) {
            return;
        }
        sum = sum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(sum == targetSum) {
                result.add(path);
            }
        }
        
        dfs(root.left, sum, targetSum, new ArrayList<>(path));
        dfs(root.right, sum, targetSum, new ArrayList<>(path));
        
    }
}

// Time Complexity : O(n+l)  is the
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
/*
 * Approach:
 * Backtrack approach: action, recurse and backtrack where we keep a track of sum and add to result when sum match targetSum.
 * We need to remove the last element need (backtrack) and add new path to result. 
 */
class PathSumIIBackTrck {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int sum, int targetSum, List<Integer> path) {
        if(root == null) {
            return;
        }
        sum = sum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        
        dfs(root.left, sum, targetSum, path);
        dfs(root.right, sum, targetSum, path);
        path.remove(path.size() - 1);
    }
}