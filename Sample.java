// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    //TC O(n) SC O(h)
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;

        isValid = true;
        dfs(root.left, root.right);
        
        return isValid;
        
    }
    private void dfs(TreeNode left, TreeNode right){
        if(left == null && right == null) return;
        
        if(left == null || right == null || left.val!=right.val){
            isValid = false;
            return;
        }
        dfs(left.left , right.right);
        dfs(left.right, right.left);
    }
}


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
    //TC O(n) SC O(h)
    List<List<Integer>> result;
    //List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        helper(root, 0, targetSum, new ArrayList<>());
       return result;
        }
    private void helper(TreeNode root, int currsum, int targetSum, List<Integer> path){
        if(root == null){
            return;
        }
        
        path.add(root.val);
        currsum = currsum + root.val;
        if(root.left == null && root.right == null){
            if(targetSum == currsum){
                result.add(path);
            }
        }
        helper(root.left,currsum,targetSum, new  ArrayList<Integer>(path));
        helper(root.right,currsum,targetSum, new  ArrayList<Integer>(path));
    }
}
