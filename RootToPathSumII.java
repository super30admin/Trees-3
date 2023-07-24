package BST;
// Time Complexity : O(n)
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class RootToPathSumII {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int targetSum, int curSum, List<Integer> path)
    {
        if(root == null) return;
        path.add(root.val);

        //action
        curSum += root.val;
        if(root.left == null && root.right == null && curSum == targetSum)
        {
            result.add(new ArrayList<>(path));
        }

        //recurse
        helper(root.left, targetSum, curSum, path);
        helper(root.right, targetSum, curSum, path);

        // backtrack
        path.remove(path.size()-1);
    }
}