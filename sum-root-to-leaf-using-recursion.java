import java.util.*;

class Solution {
    // Recursive Solution
    // Time complexity is O(n^2)
    // Space complexity is O(n^2)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path){
        // Base case
        if(root==null) return;
        // Logic
        // preorder
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(path);
                return;
            }
        }
        helper(root.left, currSum, targetSum, new ArrayList<>(path));
        helper(root.right, currSum, targetSum, new ArrayList<>(path));
    }
}