// Time Complexity : O(n) n nodes in the tree
// Space Complexity : O(height of tree)
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

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        result = new ArrayList();
        helper(root, 0, new ArrayList<>(),targetSum);

        return result;
    }

    //maintain currSum as local variable to each recursion call
    private void helper(TreeNode root, int currSum, List<Integer> path, int target)
    {
        //base
        if(root == null)
            return;

        //logic

        //keep updating the currSum as recursion moves on
        currSum += root.val;

        //keep updating the path list with node vals as recursion moves on
        path.add(root.val);

        //left recursive call
        helper(root.left, currSum, path, target);

        //leaf node reached
        if(root.left == null && root.right == null)
        {
            //sum equals target
            if(currSum == target)
                result.add(new ArrayList<>(path));
            //we needed new list here because in further calls, the nodes in path right now will be removed during backtracking. And we will be referencing the same list from which nodes have been removed
        }

        //right recursive call
        helper(root.right, currSum, path, target);

        //backtrack, because we want to use the same list to reduce TC

        path.remove(path.size()-1);

    }
}
