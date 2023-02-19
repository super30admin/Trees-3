import java.util.ArrayList;
import java.util.List;
//  Backtracking solution: TC=O(N) SC=O(h)
public class PathSum2 {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(root,targetSum,0);
        return result;
    }
    private void helper(TreeNode root,int targetSum,int currSum){
        if(root==null) return;
        // action
        currSum+=root.val;
        path.add(root.val);
        if(root.left == null && root.right==null && targetSum == currSum){
            result.add(new ArrayList<>(path));
        }
        // recursion
        helper(root.left,targetSum,currSum);
        helper(root.right,targetSum,currSum);
        // backtrack
        path.remove(path.size()-1);

    }
}
