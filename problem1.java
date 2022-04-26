import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

class pathSum1{
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        if(root == null) return result;
        helper(root, 0, targetSum);
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum){
        if(root == null){
            return;
        }

        currSum = currSum + root.val;

        path.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, currSum, targetSum);
        helper(root.right, currSum, targetSum);

        path.remove(path.size()-1);

    }
}