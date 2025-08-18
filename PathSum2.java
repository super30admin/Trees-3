// Time Complexity : O(n) — visit each node once
// Space Complexity : O(h) 
// Did this code successfully run on LeetCode : Yes

// approach:
// 1) DFS with backtracking, carrying current sum and current path list.
// 2) On visit: add node value to sum and path.
// 3) If leaf and sum == target, add a copy of path to result; recurse left/right; backtrack.


import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){
        if(root == null) return;

        currSum = currSum + root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        path.remove(path.size() - 1);
    }
}
