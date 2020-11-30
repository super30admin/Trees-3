package Nov29;

import java.util.ArrayList;
import java.util.List;

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
class PathSumII {
    
    /*

 Time complexity = O(n)
 We may have to travel all n nodes to get the path with given sum.
  
 Space complexity = O(nh) asymptotically equal to O(n^2) 
 Because we are creating new lists at every node(i.e. n lists), which can at max be of size h. This would happen when we are at those leaf node(/s) of the tree which contribute to its max height. So list size will be h in that case. 
 
 Did this code successfully run on Leetcode : Yes

 Any problem you faced while coding this : No

Approach:
  Recursive approach used.
  
*/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        // result list of list initialized. It will be passed as a fn param when calling helper method.
        List<List<Integer>> result = new ArrayList<>();
        
        // edge
        if (root == null) {
            return result;
        }
        
        // new ArrayList is for creating the list to contain the path traversed till now, where now implies when we are processing current node. 
        helper(root, 0, new ArrayList<>(), result, sum);
        
        return result;
        
    }
    
    // Recursive function 
    public void helper(TreeNode root, int curSum, List<Integer> curPath, List<List<Integer>> result, int sum) {
        
        // base condition for recursion
        if (root == null ) {
            return;
        }
     
        // logic to add current node value to current sum and current node to current path list
        curSum = curSum + root.val;
        curPath.add(root.val);
        
        // checking if current node is a leaf node and if current sum till this leaf node equals target sum
        if (root.left == null && root.right == null && curSum == sum) {
            result.add(curPath);
        }
        
        // if leaf node check fails in previous statement, then make recursive calls for left and right child of current node
        helper(root.left, curSum, new ArrayList<>(curPath), result, sum);
        helper(root.right, curSum, new ArrayList<>(curPath), result, sum);
        
    }
}