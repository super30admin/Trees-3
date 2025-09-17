// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using dfs to traverse through the tree and maintaining the current node list at every level. When the target sum meets the current path's sum on leaf node, we insert a copy of current node list to result.
 */
class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, int currentSum, List<Integer> currentList) {
        if (node == null)
            return;

        currentSum += node.val;
        currentList.add(node.val);
        if (node.left == null && node.right == null && currentSum == targetSum) {
            result.add(new ArrayList<>(currentList));
        }

        dfs(node.left, currentSum, currentList);
        dfs(node.right, currentSum, currentList);
        // remove the last node so that recursion stack will have nodes until the current node
        currentList.remove(currentList.size() - 1);
    }
}