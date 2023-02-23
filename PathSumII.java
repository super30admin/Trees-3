// TC: O(n)
// SC: O(1)
class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int t) {
        if(root == null) {
            return result;
        }
        helper(root, t, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int t, int curr, List<Integer> path) {
        if(root == null) {
            return;
        }
        curr += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && t == curr) {
            result.add(new ArrayList<>(path));
        }
        helper(root.left, t, curr, path);
        helper(root.right, t, curr, path);
        path.remove(path.size() - 1);
    }
}