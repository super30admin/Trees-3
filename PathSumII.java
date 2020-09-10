// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Recursion
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.val);
        
        if(root.val == sum && root.left==null && root.right==null){
            res.add(path);
            return;
        }else{
            helper(root.left, sum - root.val, new ArrayList<>(path));
            helper(root.right, sum - root.val, new ArrayList<>(path));
        } 
    }
}