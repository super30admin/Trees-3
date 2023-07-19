// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Using inorder traversal, keep adding the node values to the list and keep track of the sum until the leaf node is reached.
 * 2. If the sum is equal to the target sum, add the list to the result.
 * 3. If the sum is not equal to the target sum, remove the last element from the list and return using backtracking.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, 0, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSum(TreeNode root, int sum, int targetSum, List<Integer> list, List<List<Integer>> result){
        if(root == null)
            return;

        sum += root.val;
        list.add(root.val);

        if(root.left == null && root.right == null){
            if(sum == targetSum){
                result.add(new ArrayList<Integer>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
           
        pathSum(root.left, sum, targetSum, list, result);
        pathSum(root.right, sum, targetSum, list, result);
        list.remove(list.size() - 1);
    }
}