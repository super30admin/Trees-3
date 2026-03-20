
/**
    Time Complexity : O(N)
    Explanation:
    We traverse each node once. For each valid path, copying the path
    takes O(H), so overall complexity can be O(N * H) in worst case.

    Space Complexity : O(H)
    Explanation:
    Recursion stack and path list can go up to tree height H.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially forgot to backtrack (remove last element from path),
    which caused incorrect paths.
    Also needed to copy the path into a new list before adding to result,
    otherwise all references would point to the same list.
*/

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


    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        this.res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), 0);
        return res;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> path, int sum) {

        if (root == null) return;

        sum += root.val;
        path.add(root.val);

        // Check if leaf node and sum matches
        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(new ArrayList<>(path));
        }

        helper(root.left, targetSum, path, sum);
        helper(root.right, targetSum, path, sum);

        // Backtrack
        path.remove(path.size() - 1);
    }
}