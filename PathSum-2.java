//tc=O(n+L) - n is number of nodes in tree and L is the level of the leaf nodes
//sc=O(h+h) - recursion stack and the extra array  

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
    int tSum;
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }
        tSum = targetSum;
        res = new ArrayList<>();
        dfs(root, 0, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path) {
        if(root == null) {
            return;
        }

        sum += root.val; // compute sum till current node in path
        path.add(root.val); // add current node to current path

        if(root.left == null && root.right == null) {
            if(sum == tSum) { // if target sum reached at leaf
                // we need to add a new List here since
                // we're making use of the same single
                // ArrayList reference for all paths
                res.add(new ArrayList<>(path));
            }
        }

        dfs(root.left, sum, path);
        dfs(root.right, sum, path);
        path.remove(path.size()-1); // remove last element to backtrack
    }
}