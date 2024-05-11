// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

public class SumII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>());
        return result;

    }

    private void helper(TreeNode root, int currSum, List<Integer> path) {
        // Base case
        if (root == null)
            return;

        // logic
        //Action
        currSum = currSum - root.val;
        path.add(root.val); // add here not below the if condition because currnet sum is tied with root.val
        if (root.left == null && root.right == null && currSum == 0) {
            result.add(path);
        }

        //Recursion

        helper(root.left, currSum, new ArrayList<>(path));
        helper(root.right, currSum, new ArrayList<>(path));

        path.remove(path.size()-1);
        // No impact
        currSum=0;

    }
}