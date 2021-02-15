// Time Complexity :O(n)
// Space Complexity :O(depth + width)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        calculate(root, curr, 0, targetSum, output);

        return output;

    }

    private void calculate(TreeNode root, List<Integer> curr, int sum, int targetSum, List<List<Integer>> output) {

        if (root == null)
            return;

        // sum uptill now
        sum = sum + root.val;
        curr.add(root.val);

        // target matches the sum
        if (root.left == null && root.right == null && sum == targetSum) {
            output.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }

        // calculating other paths
        calculate(root.left, curr, sum, targetSum, output);
        calculate(root.right, curr, sum, targetSum, output);

        curr.remove(curr.size() - 1);
    }
}