// Time Complexity : O(n^2)
// Space Complexity : O(n) height of tree for recursion stack
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
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        sum(root,targetSum,0, new ArrayList<>());  
        return result;
    }
  // Used recursion to traverse from root to leaf node and temp sum to add the node values in a path
  // Also add the node values of the path in a temporary list. If the temporary sum == target sum, then add the temporary list to global list
  // Used backtracking to remove the elements from temporary list and traverse in another right direction
  
    public void sum(TreeNode root, int targetSum, int temp, List<Integer> list){
        if(root == null) return;
        temp += root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && targetSum == temp) result.add(new ArrayList(list));
        if(root.left != null) sum(root.left,targetSum,temp,list);
        if(root.right != null) sum(root.right,targetSum,temp,list);
        list.remove(list.size()-1);
    }
}
