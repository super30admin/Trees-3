// Time Complexity : O(n)
// Space Complexity : O(h)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private List<List<Integer>> ans;
    private List<Integer> path;
    private int remSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        this.ans = new ArrayList<>();
        this.path = new ArrayList<>();
        this.remSum = targetSum;

        pathSumRec(root);
        return ans;

    }

    private void pathSumRec(TreeNode root) {

        if (root == null) {
            return;
        }

        remSum -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {

            if (remSum == 0) {
                ans.add(new ArrayList<Integer>(path));
            }

        }

        pathSumRec(root.left);
        pathSumRec(root.right);

        remSum += root.val;
        path.remove(path.size() - 1);

    }
}