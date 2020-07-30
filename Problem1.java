//Time Complexity :O(n*n) = O(n^2)
//    n: number of nodes
//    here O(n) for creating copy of path nodes
// Space Complexity :(hn)
//    h: height of the tree
//    For every leaf node we have h in the list
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

import java.util.List;
import java.util.ArrayList;

/**Definition for a binary tree node.*/
class TreeNode {

    // member variable
    int val;
    // referneces
    TreeNode left;
    TreeNode right;

    // default constructor
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// Your code here along with comments explaining your 
// Findig target using DFS and Pre-order traversal
class Solution {

    // global result and target
    List<List<Integer>> result;
    int target;
    /** return paths if target is achieved */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // initialize;
        result= new ArrayList<>();
        // edge case
        if(root==null)
            return result;
        target = sum;
        helper(root, 0, new ArrayList<Integer>());
        return result;   
    }
    
    /** helper function - DFS */
    private void helper(TreeNode root, int currentSum, List<Integer>path){
        // base case
        if(root==null)
            return;
        // adding current sum
        currentSum += root.val;
        // adding current processed node
        path.add(root.val);
        // leaf node
        if(root.left==null && root.right==null){
            // target reached add to global list
            if(currentSum==target)
                result.add(path);
            return;
        // not a leaf node      
        }else{
            // go left, send a copy of path
            helper(root.left, currentSum, new ArrayList<>(path));

            // go right, send a copy of path
            helper(root.right, currentSum, new ArrayList<>(path));
            return;
        }
        
    }
}