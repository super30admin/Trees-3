import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        helper(root, 0, targetSum, new ArrayList<>());
        return paths;
    }

    private void helper(TreeNode root, int sum, int targetSum, List<Integer> path){
        if(root == null){
            return;
        }

        sum+= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                paths.add(new ArrayList(path));
            }
        }

        helper(root.left,sum, targetSum, path);
        helper(root.right,sum, targetSum, path);

        path.remove(path.size() - 1);
    }
}
