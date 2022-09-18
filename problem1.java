// Problem1 - https://leetcode.com/problems/symmetric-tree/submissions/

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem1 {
       List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        helper(root, new ArrayList(), targetSum, 0);
        return res;
    }
    
        private void helper(TreeNode root, List<Integer> path, int targetSum, int currSum){
        //base
        if(root == null) return;
        
        currSum += root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                res.add(new ArrayList<>(path));
            }
        }
        
        
        helper(root.left, path, targetSum, currSum);
        helper(root.right,path, targetSum, currSum);
            
        path.remove(path.size() - 1);
    }
}
