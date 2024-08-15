//Time Complexity: O(h)
//Time Complexity: O(n)
import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    int currentSum = 0;
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, currentSum);
        return paths;
    }

    public void helper(TreeNode root, int targetSum, int currentSum){
        if(root==null){
            return;
        }
        currentSum +=root.val;
        list.add(root.val);
        if(root.left==null&&root.right==null){
            if(currentSum==targetSum){
                paths.add(new ArrayList<>(list));
            }
        }
        helper(root.left, targetSum, currentSum);
        helper(root.right, targetSum, currentSum);
        list.remove(list.size()-1);
    }
}
