//time complexity is O(n) since we are visiting each node once
//space complexity is O(h) since h is space used in recursive stack

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
                result.add(new ArrayList(temp));
            }
        }
        helper(root.left, currSum, temp, sum);
        helper(root.right, currSum, temp, sum);
        temp.remove(temp.size() - 1);
    }
}
