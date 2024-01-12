public class PathSum2 {
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
    // TC: O(N * N) where N is number of nodes in tree
    // SC: O(N + H) where N is number of nodes in tree and H is max height of tree
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> res) {
        if (root == null) return;
        curr.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(curr));
        } else {
            helper(root.left, targetSum - root.val, curr, res);
            helper(root.right, targetSum - root.val, curr, res);
        }
        curr.remove(curr.size() - 1);
    }
}
