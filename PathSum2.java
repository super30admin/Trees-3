/**
 * Time complexity is O(n)
 * space complexity - O(n) worst case stack size - O(h) average case stack size
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>(), targetSum, "-");
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path, int targetSum, String str) {
        if(root == null) {
            return;
        }
        System.out.println(str+root.val);
        path.add(root.val);
        currSum = currSum + root.val;
        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, currSum, path, targetSum, str+"-");
        helper(root.right, currSum, path, targetSum, str+"-");
        System.out.println(str+root.val);
        path.remove(path.size()-1);
    }
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
}