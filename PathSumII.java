// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PathSumII {
        List<List<Integer>> result;
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();
            helper(root, 0, new ArrayList<>(), targetSum);
            return result;
        }
        private void helper(TreeNode root, int currSum, List<Integer> path, int targetSum) {
            //base case
            if(root == null) return;
            //logic
            path.add(root.val);
            currSum += root.val;
            if(root.left == null && root.right == null) {
                if(currSum == targetSum) {
                    result.add(new ArrayList<>(path));
                }
            }
            helper(root.left, currSum, path, targetSum);
            //stack.pop()
            helper(root.right, currSum, path, targetSum);
            //stack.pop()
            //backtrack
            path.remove(path.size() - 1);
        }
}
