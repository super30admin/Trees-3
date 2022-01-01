// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * we traverse the tree to consider each path that takes us to leaf node. For each path we use a list and curr variable to hold current sum
 * As soon as we reach leaf node, we check if curr sum is equal to target sum. If yes, we take all the elements from temp list which is storing 
 * current path we travelled, and put as a new separate list into final result list.
 * As soon as we are done traveling both in left and right direction of current node, we will remove it from temp list.
*/


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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        
        check( root,  targetSum,  0,  new ArrayList<>());
        return ans;
    }
    
    private void check(TreeNode root, int target, int curr, List<Integer> temp){
        if(root == null)return;
        curr = curr + root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
           
            if(curr == target){
                ans.add(new ArrayList<>(temp));
            }
        }
        check(root.left, target, curr, temp);
        check(root.right, target, curr, temp);
        
        temp.remove(temp.size() - 1);
        
    }
}