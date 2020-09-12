// https://leetcode.com/problems/path-sum-ii/submissions/
// 113. Path Sum II- MEDIUM
// Time Complexity : O(n)
// Space Complexity : O(h) + O(c*h) - stack space + space for new temporary solution list
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach -
// Traverse from root to leaf - dfs, along the way, update the path taken, and the sum remaining to reach the target.
// when the curr node's valu is equal to the remaining sum, and the node is a leaf node, add it to the answer list
// a new temp array is needed here, as java stores the list by reference, and modification will modify the resulting answer

import java.util.ArrayList;
import java.util.List;

class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }        
        
        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, path, result);
        return result;
    }
    
    public void pathSum(TreeNode root, int remainingSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            if (remainingSum == root.val) {
                List<Integer> temp = new ArrayList(path);
                temp.add(root.val);
                result.add(temp);
            }            
        }
        
        // add curr node to path and pass to children
        path.add(root.val);

        // reduce remainingSum by curr node's value
        pathSum(root.left, remainingSum - root.val, path, result);
        pathSum(root.right, remainingSum - root.val, path, result);
        
        // after processing the children, remove current node from the path, before returning the call to parent
        path.remove(path.size() - 1);
    }
}