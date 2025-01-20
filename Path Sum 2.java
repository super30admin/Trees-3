//TC: O(N)
//SC: O(logN) recursive stack  and path
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        //base
        if(root == null) return new ArrayList<>();
        int sum = 0; 
        List<Integer> path = new ArrayList<>();
        
        helper(path, targetSum, root, 0);
        return result;
    }
    
    private void helper(List<Integer> path, int target, TreeNode root, int sum){
        
        //base to return; check the target sum condition and add to the result
        if(root == null)
            return;
        
        // List<Integer> path2 = path;
        path.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null && sum == target){
            result.add(new ArrayList<>(path));
        }
        //recursion left and right
        helper(path, target, root.left, sum );
        helper(path, target, root.right, sum );
        sum -= root.val;
        path.remove(path.size()-1);

    }
}