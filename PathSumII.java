// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class PathSumII {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList();
        result = new ArrayList();
        helper(root, targetSum, 0, new ArrayList());
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int sum, List<Integer> path){
        if(root == null) return;
        sum += root.val;
        path.add(root.val);
        
        //System.out.println(sum + " " + path.toString());
        if(sum == targetSum && root.left == null && root.right == null){
            result.add(new ArrayList(path));
        }
        helper(root.left, targetSum, sum, path);
        helper(root.right, targetSum, sum, path);
        
        
        if(path.size() > 0) path.remove(path.size()-1); //remove the current root
    }
}