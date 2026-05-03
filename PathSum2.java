// Time Complexity : O(n) where n is the number of nodes in the tree. We are visiting each node once.
// Space Complexity :   O(h) where h is the height of the tree. In the worst case, the tree is skewed and the height is n, so the space complexity is O(n). In the best case, the tree is balanced and the height is log(n), so the space complexity is O(log(n)).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, I did not face any problem while coding this. 


// Your code here along with comments explaining your approach
// We will be doing a pre-order traversal of the tree. 
// We will be keeping track of the current path and the sum of the values in the current path.
// When we reach a leaf node, we will check if the sum of the values in the current path is equal to the target sum.
//  If it is, we will add the current path to the result list. Note we need to make a copy of the current path before adding it to the result list,
//  because we will be backtracking and modifying the current path.
// After checking the leaf node, we will backtrack and remove the last node from the current path and subtract its value from the sum.
import java.util.*;

class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), 0);
        return res;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> path, int sum) {

        if (root == null) return;

        // include current node
        sum += root.val;
        path.add(root.val);

        // check leaf
        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(new ArrayList<>(path)); // copy path
        }

        helper(root.left, targetSum, path, sum);
        helper(root.right, targetSum, path, sum);

        // backtrack
        path.remove(path.size() - 1);
    }
}