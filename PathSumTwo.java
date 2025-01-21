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
import java.util.List;
import java.util.ArrayList;
class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(H)
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        dfs (root, targetSum, 0, new ArrayList<Integer>());
        return res;
    }
    private void dfs (TreeNode node, int targetSum, int curSum, ArrayList<Integer> list){
        if (node == null){
            return;
        }
        curSum = curSum + node.val;
        list.add(node.val);
        if (node.left == null && node.right == null){
            if (targetSum == curSum){
                res.add(new ArrayList<>(list));
            }
        }

        dfs (node.left, targetSum, curSum, list);
        dfs (node.right, targetSum, curSum, list);
        list.remove(list.size()-1);
    }
}