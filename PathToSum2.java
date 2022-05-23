// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
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
    List<List<Integer>> paths = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPath(root, 0, new ArrayList(), targetSum);
        return paths;
    }
    
    private void findPath(TreeNode root, int sum, List<Integer> path, int tar){
        if(root == null) return;
        path.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==tar) paths.add(new ArrayList<>(path));
            return;
        }
        findPath(root.left, sum, new ArrayList<>(path), tar );
        findPath(root.right, sum, new ArrayList<>(path),  tar);
    }
}