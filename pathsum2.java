//tc : O(n)
//sc : O(n*n)
//run successfully
//no problem

//DFS

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
    List<List<Integer>> ans;
    List<Integer> list = new ArrayList<>();
    int target = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        // base case
        if (root == null)
            return ans;
        target = targetSum;
        list.add(root.val);
        helper(root, root.val);
        return ans;
    }

    private void helper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (target == sum)
                ans.add(new ArrayList<>(list));
            return;
        }

        if (root.left != null) {
            list.add(root.left.val);
            helper(root.left, sum + root.left.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            helper(root.right, sum + root.right.val);
            list.remove(list.size() - 1);
        }

    }
}