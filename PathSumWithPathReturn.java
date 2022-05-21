// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


import java.util.ArrayList;
import java.util.List;

public class PathSumWithPathReturn {
    class TreeNode {
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
    private List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if(root == null) return result;
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int sum, int targetSum, List<Integer> path){
        //base condition
        if(root == null) return;
        //path = new ArrayList<>(path);
        path.add(root.val);
        sum += root.val;
        if(sum == targetSum && root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
        }
        helper(root.left, sum, targetSum, path);
        helper(root.right, sum, targetSum, path);
        path.remove(path.size() -1);
    }
}
