//Time Complexity: O(n)
//Space Complexity: O(h) where h is the height of the tree

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, targetSum, new ArrayList<Integer>(), result);
        return result;
    }
    public static void helper(TreeNode node, int targetSum, int remainingSum, List<Integer> currentPath, List<List<Integer>> result){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            if(remainingSum==node.val)   {
                currentPath.add(node.val);
                result.add(new ArrayList<>(currentPath));
                currentPath.remove(currentPath.size()-1);
            }
            else
                return;
        }

        currentPath.add(node.val);
        helper(node.right, targetSum, remainingSum-node.val, currentPath, result);
        helper(node.left, targetSum, remainingSum-node.val, currentPath, result);
        currentPath.remove(currentPath.size()-1);
    }
}