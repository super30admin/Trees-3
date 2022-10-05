/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        target = targetSum;
        
        dfs(root, 0, new ArrayList<>());
        return result;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> path) {
        // base
        if (root == null) return;
        // logic
        path.add(root.val);
        int currSum = sum + root.val;
        if (root.left == null && root.right == null) {
            if (target == currSum) {
                result.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, currSum, new ArrayList<>(path));
        dfs(root.right, currSum, new ArrayList<>(path));
        path.remove(path.size()-1);
    }
}

// Executed
// T.C: O(n)
// S.C: O(h) WHERE h is the height of the tree