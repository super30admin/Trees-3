//time complexity O(n)
//space complexity O(n^2)
//This is normal recursion and it's not efficient because we are creating a new space for ArrayList at every node we traverse. We can optimize using backtracking and using the same temporary list at each node.

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
    List<List<Integer>> result; List<Integer> temp;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>(); temp = new ArrayList<>();
        helper(root, 0, temp, sum);
        return result;
    }

    private void helper(TreeNode root, int currSum, List<Integer> temp, int sum){
        if(root == null) return;
        currSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == sum){
                result.add(temp);
            }
        }
        helper(root.left, currSum, new ArrayList(temp), sum);
        helper(root.right, currSum, new ArrayList(temp), sum);
    }
}
