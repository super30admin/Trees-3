//approach-we are recursiving traversing in inorder, which adding sum at each node and passing it to the next recursive call. at each call we are passing a list and updating the list according i.e removing a node if we move away from that path. when we get out sum equal to target we are adding the path(as a new list since list works as a reference value) to result.
//time complexity -> O(n+h) n-> we are visiting each node once,h->we have to copy the path into a new list(size would be height as the path is from root to leaf node).
//space complexity=O(h+h)->O(h), h-> the most we would have each time in the recursive stack which is the height of the tree, for the initial list we are passing aroung to store the path.
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
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<Integer>());
        return result;
    }

    private void helper(TreeNode root, int curSum, int target, List<Integer> path) {
        if (root == null)
            return;
        curSum += root.val;
        path.add(root.val);

        if (curSum == target &&
                (root.left == null && root.right == null)) {
            result.add(new ArrayList<>(path));
        }
        helper(root.left, curSum, target, path);
        helper(root.right, curSum, target, path);
        path.remove(path.size() - 1);

    }
}
