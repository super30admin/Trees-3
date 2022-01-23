// Time Complexity O(n)
// Space Complexity O(1)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int targ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        targ = targetSum;
        helper(root, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path){
        if(root == null) return;
        currSum += root.val;
        path.add(root.val);
        helper(root.left, currSum, new ArrayList<>(path));
        if(root.left == null && root.right == null){
            if(currSum==targ){
                result.add(path);
            }
        }
        helper(root.right, currSum, path);
    }
}