// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

import java.util.*;
class PathSumSolution {
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
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    result = new ArrayList<>();
    if(root==null)
        return result;
    helper(root, 0, sum, new ArrayList<>());
    return result;
}
private void helper(TreeNode root, int rsum, int sum, List<Integer> path) {
    if(root==null)
        return;
    int newSum = rsum+root.val;
    path.add(root.val);
    if(root.left == null && root.right == null) {
        if(newSum == sum) {
            result.add(new ArrayList<>(path));
        }
    }
    helper(root.left, newSum, sum, new ArrayList<>(path));
    helper(root.right, newSum, sum, new ArrayList<>(path));
    path.remove(path.size()-1);
}
}
