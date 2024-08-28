import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

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
class PathSum2 {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<Integer>());
        return result;
    }
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path) {
        if(root == null) return;
        currSum = currSum + root.val;
        List<Integer> li = new ArrayList<>(path);
        li.add(root.val);
        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                result.add(li);
            }
        }
        helper(root.left,targetSum,currSum,li);
        helper(root.right,targetSum,currSum,li);
    }
}