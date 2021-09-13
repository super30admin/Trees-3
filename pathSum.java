// Time Complexity : O(n) 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
import java.util.*;
public class pathSum {
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
    int target;
    List<Integer> path;
    public List<List<Integer>> pathSums(TreeNode root, int targetSum) {
        result =  new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;
        if(root == null) return result;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int currSum){
        if(root == null) return;
        path.add(root.val);
        currSum += root.val;
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, currSum);
        helper(root.right, currSum);
        path.remove(path.size()-1);
    }
}