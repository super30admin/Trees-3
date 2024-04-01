// Time Complexity : O(n*h) - n = numer of nodes, h = height of tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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

//Approach: keep track for sum of value till now, if we reach the leaf node and that values becomes equal to targetSum add the path to the result
// keep a new path for each recursion as a DS within a DS is a refernce
// other than creating different path arrays for each node, we can do the deep copy only if we reach the target
class PathSum {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    private void helper(TreeNode root, int curr, List<Integer> path, int targetSum){
        //base
        if(root == null) return;
        curr = curr + root.val;
        path.add(root.val);

        //breach
        if( root.left == null && root.right == null){
            if(curr == targetSum){
                result.add( new ArrayList(path));
            }
        }
        //recursion
        helper(root.left, curr, path, targetSum);
        helper(root.right, curr, path, targetSum);

        }
}