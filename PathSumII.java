// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We perform a depth-first traversal (DFS) of the tree, maintaining a running path and sum.
// At each node, we add its value to the current path and sum.
// When we reach a leaf node, we check if the current sum equals the targetSum.
// If it does, we add a deep copy of the current path to the result list.
// After exploring both left and right subtrees, we backtrack by removing the last node from the path.
// This avoids the overhead of copying the path at each recursive call (compared to the previous version).
// The time complexity is O(n) because each node is visited once.
// The space complexity is O(h) due to the recursion stack and path list (which at max is the height of the tree).


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
    List<List<Integer>> resultPath = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<Integer> path = new ArrayList<Integer>();
        helper(root,targetSum,path,0);
        return resultPath;

    }
    private void helper(TreeNode root, int targetSum, List<Integer> path, int currSum){

        if(root == null)return;
        path.add(root.val);
        currSum+=root.val;
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                resultPath.add(new ArrayList<>(path));
            }
        }
        helper(root.left,targetSum,path,currSum);
        helper(root.right,targetSum,path,currSum);
        path.remove(path.size()-1);

    }
}