// Time - O(n)
// Space - O(n)

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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList<Integer>());
        return res;
    }

    public void helper(TreeNode root, int targetSum, int sum, List<Integer> path){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            sum  = sum +root.val;
            if(sum==targetSum){
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;

        }
        path.add(root.val);
        helper(root.left, targetSum, sum+root.val, path);
        helper(root.right, targetSum, sum+root.val, path);
        path.remove(path.size()-1);
    }
}
