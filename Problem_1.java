// Time Complexity : O(n), n = no. of nodes in tree
// Space Complexity : O(h), height of tree. 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        helper(root, targetSum, new ArrayList<>(), 0);
        return out;
    }
    public void helper(TreeNode root, int targetSum, List<Integer> path, int currSum){
        if(root == null)
            return;
        path.add(root.val);
        currSum += root.val;
        if(root.right == null && root.left == null){
            if(currSum == targetSum){
                out.add(new ArrayList<>(path));
            }
        }
        helper(root.left, targetSum, path, currSum);
        helper(root.right, targetSum, path, currSum);
        path.remove(path.size()-1);
    }
}
