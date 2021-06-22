// Time Complexity : O(N)
// Space Complexity : O(H=N)
// Did this code successfully run on Leetcode : Yes


class Solution {
    List<List<Integer>> paths;
    List<Integer> curr_path;
    int target;
    int currSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.paths = new ArrayList<>();
        this.curr_path = new ArrayList<>();
        this.target = targetSum;
        this.currSum = 0;
        helper(root);
        return paths;
    }
    
    private void helper(TreeNode root){
        //base
        if(root == null)
            return;
         
        //logic
        curr_path.add(root.val);
        currSum+=root.val;
       
        if(root.left == null && root.right == null && currSum == target)
            paths.add(new ArrayList<>(curr_path));
            
        helper(root.left);
        
        helper(root.right);
        
        curr_path.remove(curr_path.size() - 1);
        currSum -= root.val;
    }
}