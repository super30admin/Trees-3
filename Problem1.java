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
class Problem1 {
    List<List<Integer>> result;
    List<Integer> localResult;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        localResult = new ArrayList<>();
        helper(root, 0, targetSum, localResult);
        return result;
    }

    private void helper(TreeNode root, int sum, int targetSum, List<Integer> localResult ) {
        // base case
        if(root == null) return;
        //logic 
        localResult.add(root.val);
        sum += root.val;
        
        if(root.left == null && root.right == null && sum == targetSum) {
            result.add(new ArrayList<>(localResult));
        }
        helper(root.left, sum, targetSum, new ArrayList<>(localResult));
        helper(root.right, sum, targetSum, new ArrayList<>(localResult));
        localResult.remove(localResult.size() -1);
    }
}
