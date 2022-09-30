class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        helper(root, targetSum, res);
        return res;
    }
    
    //create sublist as global as you dont have to create a new sublist everytime. You append in the same sublist
    List<Integer> path = new ArrayList<>();
        
    public void helper(TreeNode root, int targetSum, List<List<Integer>> res){
        if(root == null)
            return;
    
        //action
        targetSum = targetSum - root.val;
        path.add(root.val);
        
        if(targetSum == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(path));
        
        //recurse
        helper(root.left, targetSum, res);
        helper(root.right, targetSum, res);
        
        //backtrack
        path.remove(path.size() - 1);
    }
}