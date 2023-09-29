import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//SC: O(n)
 //TC: O(n*H)
class PathSumII {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<Integer>());
        return result;
    }

    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path){
        //base
        if(root == null) return;
        //logic
        currSum += root.val;
        //action
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(currSum == targetSum) result.add(new ArrayList<>(path));
        }
        //recurse
        helper(root.left, currSum, targetSum, path);
        helper(root.right, currSum, targetSum, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}