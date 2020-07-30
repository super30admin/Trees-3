// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :	Yes
// Any problem you faced while coding this : No

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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> current = new ArrayList<>();                
        findPaths(root, sum, current, paths);                           
        return paths;
    }
    
    private void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> paths) {
        //base
         if(root == null)  return;
        
       //logic
        current.add(root.val);
        if(sum == root.val && root.left == null && root.right == null)
                paths.add(new ArrayList<>(current));

        findPaths(root.left, sum - root.val, current, paths);
        findPaths(root.right, sum - root.val, current, paths);

        current.remove(current.size() - 1);  //if we hit null recurse back up through stack and remove elements in current list
    }
}