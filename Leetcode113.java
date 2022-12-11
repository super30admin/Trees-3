import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode113
 */
public class Leetcode113 {

    List<List<Integer>> result;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return new ArrayList<>();
        result = new ArrayList<>();
        target = targetSum;
        recursion(root, 0, new ArrayList<>());
        return result;
    }

    private void recursion(TreeNode root, int sum, List<Integer> paths) {
        if (root == null)
            return;

        // //action
        sum = sum + root.val;
        paths.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(paths));
            }
        }

        // //action
        // sum=sum+root.val;
        // paths.add(root.val);

        // recursion
        recursion(root.left, sum, paths);
        recursion(root.right, sum, paths);

        // backtrack:
        paths.remove(paths.size() - 1);
    }
}

//tc--> O(N)
//sc-->O(height of tree)