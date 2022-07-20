class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        if(root == null) return result;
        
        helper(root, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path){
        if(root == null) return;
        
        path.add(root.val);
        currSum += root.val;
        
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.left, currSum, path);
        helper(root.right, currSum, path);
        path.remove(path.size() - 1);
    }
}