# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)

```Java
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> path, int target){
        //base
        if(root == null)
            return;

        //logic
        currSum += root.val;

        //action
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target)
                result.add(new ArrayList<>(path));
        }

        //recursion
        helper(root.left, currSum, path, target);
        helper(root.left, currSum, path, target);

        //backtrack
        path.remove(path.size()-1);
    }
}
```

## Problem2 (https://leetcode.com/problems/symmetric-tree/)

```Java
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}
```