// Time Complexity : O(n) -- n is the number of nodes
// Space Complexity : O(h) -- h is the height of the tree -- not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to refer the class discussion for the exact approach


// Your code here along with comments explaining your approach
/* 
 * At each node add the node value to the list and keep adding node values over a path till we reach the leaf node
 * then check if the sum equals the target. If yes then add the corresponding path list to the result list which is a global variable
 */

import java.util.*;
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
    List<List<Integer>> list1;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list1 = new ArrayList<>();
        helper(root,0,new ArrayList<>(),targetSum);
        return list1;
    }

    private void helper(TreeNode root, int sum, List<Integer> list,int target){
        // base condition
        if(root == null) return;

        // logic
        sum = sum + root.val;
        list.add(root.val);
        // only check the sum when the root is leaf node i.e. in between also the sum may become target but we don't want that
        if(sum == target && root.left==null && root.right==null){
            list1.add(list);
        }
        helper(root.left,sum,new ArrayList<>(list),target);
        System.out.println(list);
        helper(root.right,sum,new ArrayList<>(list),target);

    }
}