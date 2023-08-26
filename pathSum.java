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
    List<List<Integer>> resultLists;
    int targetSum = 0;

    public List<List<Integer>> pathSum(TreeNode node, int sum) {
        targetSum = sum;
        List<Integer> currentPath = new ArrayList<Integer>();
        int currentSum = 0;
        resultLists = new ArrayList<List<Integer>>();
        findPaths(node, currentSum, currentPath);
        return resultLists;
    }

    void findPaths(TreeNode node, int currentSum, List<Integer> currentPath) {
        if(node == null) {
            return;
        }
        currentPath.add(node.val);
        currentSum += node.val;
        if(node.left == null && node.right == null) {
            if(currentSum == targetSum) {
                resultLists.add(new ArrayList<>(currentPath));
            }
        }
        findPaths(node.left, currentSum, new ArrayList<>(currentPath));
        findPaths(node.right, currentSum, new ArrayList<>(currentPath));
        return;
    }
}
