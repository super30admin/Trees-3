// Time Complexity : O(n^2) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class pathSum2 {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        dfs(root, 0, new ArrayList<>(), sum);
        return ans;
    }
    
    private void dfs(TreeNode root, int currSum, List<Integer> currList, int sum) {
        // base case
        if (root == null) return;
        currSum += root.val;
        currList.add(root.val);
        if (root.left == null && root.right == null) {
            if (currSum == sum) {
                ans.add(new ArrayList<>(currList));
            }
        }
        // logic
        dfs(root.left, currSum, currList, sum);
        dfs(root.right, currSum, currList, sum);
        currList.remove(currList.size() - 1); // backtrack
    }
}