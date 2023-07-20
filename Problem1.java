import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result;

    private void recur(TreeNode root, int currSum, List<Integer> path, int targetSum) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        if (

        root.left == null && root.right == null &&

                (currSum + root.val == targetSum)) {
            result.add(new ArrayList<>(path));
        }

        recur(root.left, currSum + root.val, new ArrayList<>(path), targetSum);
        recur(root.right, currSum + root.val, new ArrayList<>(path), targetSum);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        recur(root, 0, new ArrayList<>(), targetSum);

        return result;
    }
}