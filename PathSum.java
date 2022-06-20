import java.util.ArrayList;
import java.util.List;
// Time Complexity: O(n)
// Space Complexity: O(1) without the recursive stack space         
public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null) return result;
        helper(root, 0, new ArrayList<>(), targetSum);
        return result;
    }

    public void helper(TreeNode root, int currSum, List<Integer> path, int target){
        if(root == null) return;

        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && currSum == target){
            result.add(new ArrayList<>(path));
        }

        helper(root.left, currSum, path, target);
        helper(root.right, currSum, path, target);

        path.remove(path.size() - 1);
    }
}
