import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//TC: O(n)
//SC: O(h)
public class Path_Sum2 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currentSum, int targetSum, List<Integer> path){
        //base
        if(root == null) return;
        // if(currentSum!=targetSum) return;
        //logic
        currentSum += root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(currentSum==targetSum){
                result.add(new ArrayList<> (path));
            }
        }
        helper(root.left, currentSum, targetSum, path);
        helper(root.right, currentSum, targetSum, path);

        //backtrack
        path.remove(path.size()-1);
    }
}
