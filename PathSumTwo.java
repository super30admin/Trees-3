// Time Complexity O(n)
// Space Complexity O(h)
// Runs on LeetCode: YES
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
class PathSumTwo {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> currentList = new ArrayList<Integer>();
        inorder(root, targetSum, 0, currentList);
        return result;
    }

    private void inorder(TreeNode root, int targetSum, int currentSum, List<Integer> currentList){

        if(root == null){
            return;
        }

        currentList.add(root.val);
        currentSum = currentSum + root.val;

        if(root.left == null && root.right == null && currentSum == targetSum){
            result.add(new ArrayList<Integer>(currentList));
        }

        inorder(root.left, targetSum, currentSum, currentList);
        inorder(root.right, targetSum, currentSum, currentList);
        currentList.remove(currentList.size() -1);
    }
}