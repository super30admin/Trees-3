// TIME: O(n^2)
// SPACE: O(n)
// SUCCESS on LeetCode

public class PathSumII {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        rootToLeaf(root, 0, targetSum, new ArrayList<>());
        return answer;
    }
    
    private void rootToLeaf(TreeNode root, int value, int target, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && value + root.val == target) {
            answer.add(new ArrayList<>(list));
        } else {
            rootToLeaf(root.left, value + root.val, target, list);
            rootToLeaf(root.right, value + root.val, target, list);
        }
        list.remove(list.size() - 1);
    }
}
