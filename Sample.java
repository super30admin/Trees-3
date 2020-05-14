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
//Time o(n) n- no of nodes
//Space recursive stack spacw
class Solution {
    int target;
    List<List<Integer>> res;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if(root == null)
            return res;
        target = sum;
        helper(root, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<Integer>list){
        //base case
        if(root == null)
            return;
        //logic
        //action
        list.add(root.val);
        sum = sum + root.val;
        if(root.left == null && root.right == null)
        {
            if(target == sum){
                res.add(new ArrayList<>(list));
            }
        }
        
        //recurse
        helper(root.left,sum,list);
        helper(root.right,sum,list);
        
        //backtrack
        list.remove(list.size()-1);
        
        return;
    }
}

//Time o(n) n is the no of nodes
//space o(2h) == o(h) height of the tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left,root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        //base case
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
            return false;
        //logic
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}