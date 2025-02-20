//TC: O(n)
//SC: O(n) stack space in worst case
//approach: dfs with backtracking

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    List<List<Integer>> result;
    int target;

    public List<List<Integer>> pathSum(SymmetricTreeBFS.TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        if(root == null) return result;
        backtrack(root, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(SymmetricTreeBFS.TreeNode root, int currSum, List<Integer> path){
        if(root == null) return;
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(new ArrayList<>(path));
            }
        }

        backtrack(root.left, currSum, path);
        backtrack(root.right, currSum, path);
        path.remove(path.size() - 1);

    }
}
