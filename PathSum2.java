import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

// Time Complexity : O(n^2), traverse entire tree, and worst case, we copy over current nodes path to new list to add to output list
// Space Complexity : O(n) recursive tree of height n
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this :

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> outputList = new ArrayList<List<Integer>>();
        List<Integer> currentPath = new ArrayList<Integer>();
        recurse(root, targetSum, currentPath, outputList);
        return outputList;
    }
    
    private void recurse(TreeNode node, int remainingSum, List<Integer> current, List<List<Integer>> list){
        if (node == null){
            return;
        }
        
        // add current node to current path's list
        current.add(node.val);
        
        // if current node is leaf and equal to remaining sum
        if (remainingSum == node.val && node.left == null && node.right == null){
            list.add(new ArrayList<> (current)); // add to output list
        }
        else{ // recurse
            recurse(node.left, remainingSum - node.val, current, list);
            recurse(node.right, remainingSum - node.val, current, list);
        }
        
        // pop node once done processing all of its subtrees
        current.remove(current.size() - 1);
        
    }
}