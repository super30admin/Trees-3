//time O(n)
//space O(h) height of the tree

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, 0, result, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, List<List<Integer>> result, List<Integer> path) {
        //base
        if(root == null) return;
        
        //logic
        currSum +=  root.val;
        path.add(root.val);
        helper(root.left, targetSum, currSum, result, path);
        if(root.left == null && root.right == null && currSum == targetSum && path.size() != 0) {
            result.add(new ArrayList<>(path));
        }
        helper(root.right, targetSum, currSum, result, path);
        path.remove(path.size() - 1);
    }
}
