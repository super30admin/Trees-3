// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> p = new ArrayList<>();
        helper(root, targetSum, p);
        return res;
        
    }
    private void helper(TreeNode root, int target, List<Integer> path){
        //base case
        if(root == null){
            return;
        }
        //logic
        path.add(root.val);
        target = target - root.val;
            
        if(root.left == null && root.right == null){
            if(target == 0){
                res.add(path);
            }
        }
        
        helper(root.left, target, new ArrayList<>(path)); 
        helper(root.right, target, new ArrayList<>(path)); 
    }
}