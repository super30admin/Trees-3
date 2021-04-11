//sc : O(height of tree); recursion stack
//tc : O(n)
public class PathSumII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();

        helper(root, targetSum, list);
        return ans;
    }
    private void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (sum == root.val && root.left == null && root.right == null) {

            ans.add(new ArrayList<>(list));

        }
        else {

            helper(root.left, sum - root.val, list);
            helper(root.right, sum - root.val, list);
        }
        list.remove(list.size() - 1);

    }
}