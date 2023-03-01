// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(h) where h is the height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use recursion. Starting from root we add val of that root to sum, val to paths list and compare with targetSum. 
   If targetSum is reached, we create a new list of paths so far and add it to result. We do this for left and right subtrees
   recursively. After recursion we backtrack to remove the values added in that step. In the end we return the result list.
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
 *         this.right = rig ht;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        search(root, 0, targetSum);

        return result;
    }

    private void search(TreeNode root, int sum, int targetSum) {
        if(root == null)
            return;

        sum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(sum == targetSum)
                result.add(new ArrayList<>(path));
        }

        search(root.left, sum, targetSum);
        search(root.right, sum, targetSum);

        path.remove(path.size() - 1);
    }
}