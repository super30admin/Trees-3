// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    //maste list containing all the paths that sum to target
    List<List<Integer>> result = new ArrayList<>();
    //target
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return result;
        //set target equal to sum
        target = sum;
        //call helper to find the paths
        helper(root,0,new ArrayList<>()) ;
        return result;
    }
    
    private void helper(TreeNode root, int curSum, List<Integer> path ){
        //base
        if(root == null) return;
        //logic
        //update the new currrent sum
        curSum = curSum + root.val;
        //add the node into the path now
        path.add(root.val);
        //if you are at a leaf node then check if the curSum == target. If it is then add it to the master list if not move on
        if(root.left == null && root.right == null){
            if(curSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        //call helper on the left and right
        helper(root.left, curSum ,path);
        helper(root.right, curSum, path);
        //backtrack and remove the path added
        path.remove(path.size()-1);
        
    }
}