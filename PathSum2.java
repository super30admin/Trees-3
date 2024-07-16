import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.target = targetSum;
        pathSumRecursion(root, 0, new ArrayList<>());
        return result;
    }

    void pathSumRecursion(TreeNode root, int currentSum, List<Integer> path) {
        if(root == null) return;

        currentSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(currentSum == target) {
                result.add(new ArrayList<>(path));
            }
        }

        pathSumRecursion(root.left, currentSum, path);
        pathSumRecursion(root.right, currentSum, path);
        path.removeLast();
    }
}