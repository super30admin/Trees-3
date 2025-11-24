// 113. Path Sum II
// https://leetcode.com/problems/path-sum-ii/description/

/**
 * Time Complexity: O(n) since we process all nodes
 * Space Complexity: O(h) where h is height of the tree
 */

/**
 * Approach: We use recursion + backtracking
 * On each node, we process the node i.e add it to currSum and add it to path.
 * We check if the root is leaf, if yes, we add the path to result
 * Before going back for different path, we remove the previously added value from path
 * since now we will be checking different path
 */

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();

        helper(root, targetSum, 0, new ArrayList());

        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){
        // base case
        if(root == null){
            return;
        }

        // logic
        currSum = currSum + root.val;
        path.add(root.val);

        // check if leaf
        if(root.left == null && root.right == null){
            if(targetSum == currSum){
                result.add(new ArrayList(path));
            }
        }

        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        path.remove(path.size() - 1);
    }
}