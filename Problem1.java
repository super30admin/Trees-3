//https://leetcode.com/problems/path-sum-ii/
// Time Complexity : O(N)
// Space Complexity : O(1) ignoring recursion statck
// Did this code successfully run on Leetcode : YES
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         List<List<Integer>> res = new ArrayList<>();
         helper(root,sum,res, new ArrayList<>());
         return res;
    }
    public void helper(TreeNode root, int remainingSum,List<List<Integer>> res, List<Integer> l){
        if(root == null)
            return;
        
        l.add(root.val);
        remainingSum -= root.val;
        
        if(root.left == null && root.right == null && remainingSum == 0){
            res.add(new ArrayList<>(l));
        }
         
        helper(root.left,remainingSum,res,l);
        helper(root.right,remainingSum,res,l);
        l.remove(l.size()-1);       
    }
}