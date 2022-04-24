import java.util.ArrayList;
import java.util.List;

public class PathToSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;


        helper(root, 0, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if(root == null) return;

        // action
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }

        // recursion
        helper(root.left, currSum, targetSum, path, result);
        helper(root.right, currSum, targetSum, path, result);

        // backtrack
        // since we are out of the recursion means we hit the base case.
        // so, whatever is the last node we added, remove it from the path list
        // During the recursion, we are storing the snapshot into the result list.
        // This is to avoid putting unnecessary nodes in the result list
        path.remove(path.size() - 1);
    }
}
