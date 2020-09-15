/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// Time :O(N^2)
// Space:O(N)
class Solution {
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        this.target = sum;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> pathNodes = new ArrayList<Integer>();

        dfs(root, 0, result, pathNodes);

        return result;
    }

    void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> pathNodes) {

        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.val + sum == target) {
                ArrayList tmp = new ArrayList(pathNodes);
                tmp.add(root.val);
                result.add(tmp);
            }

            return;
        }

        pathNodes.add(root.val);
        dfs(root.left, sum + root.val, result, pathNodes);
        dfs(root.right, sum + root.val, result, pathNodes);

        pathNodes.remove(pathNodes.size() - 1);

    }
}