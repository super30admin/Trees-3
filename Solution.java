// Time Complexity :o(n)
// Space Complexity :o(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        helper(root, 0, sum, new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root,int currsum,int sum,List<Integer> path)
    {
        if(root == null) return;
        path.add(root.val);
        currsum += root.val;
        if(root.left == null && root.right == null)
        {
            if(currsum == sum)
            {
                res.add(new ArrayList<>(path));
            }
        }
        helper(root.left, currsum, sum, path);
        helper(root.right, currsum, sum, path);
        
        path.remove(path.size() - 1);
    }
}