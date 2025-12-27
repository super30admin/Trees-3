// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int curr, int target, List<Integer> path){
        //base
        if(root == null) return;

        //logic
        curr += root.val;

        //action
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(curr == target){
                result.add(new ArrayList<>(path));
            }
        }
        //recurse
        helper(root.left, curr, target, path);
        helper(root.right, curr, target, path);

        //backtrack
        path.remove(path.size()-1);
    }
}