// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        path=new ArrayList<>();
        helper(root, 0, targetSum);
        return result;
    }
    private void helper(TreeNode root, int curSum, int target){
        if(root==null) return;
        
        curSum+=root.val;
        path.add(root.val);
        
        if(root.left==null && root.right==null){
            if(curSum==target){
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.left, curSum, target);
        helper(root.right, curSum, target);
        path.remove(path.size()-1);
    }
}