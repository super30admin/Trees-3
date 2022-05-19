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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        inorder(root, targetSum, new ArrayList<>());
        return result;

    }

    private void inorder(TreeNode root, int targetSum, List<Integer> path) {
        // base
        if (root == null) return;

        //logic
        //sum +=root.val;
        path.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList(path));
        } else {
            inorder(root.left, targetSum - root.val, path);
            inorder(root.right, targetSum - root.val, path);
        }

        path.remove(path.size() - 1);

    }
}
/**
 * class Solution {
 * List<List<Integer>> result = new ArrayList<>();
 * public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
 * inorder(root, targetSum, 0, new ArrayList<>());
 * return result;
 * <p>
 * }
 * private void inorder(TreeNode root, int targetSum, int sum, List<Integer> path){
 * // base
 * if(root ==null) return;
 * <p>
 * //logic
 * sum +=root.val;
 * path.add(root.val);
 * if(sum == targetSum && root.left == null && root.right == null){
 * result.add(path);
 * }
 * inorder(root.left, targetSum, sum, new ArrayList(path));
 * inorder(root.right, targetSum, sum, new ArrayList(path));
 * <p>
 * }
 * }
 */