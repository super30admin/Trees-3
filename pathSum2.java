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

 //find all root-to-leaf paths in a binary tree where the sum of node values equals a given target. 
 //DFS tracks the current path and cumulative sum, and adds the path to the result list if a leaf node with the target sum is reached. 
 //After each recursive call, it backtracks by removing the last added node to explore other paths.
 //Time complexity: O(n^2)
 //Space complexity: O(n)
class Solution {

    List<List<Integer>> result;

    int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result = new ArrayList<>();

        target = sum;

        if(root == null) return result;

        dfs(root, 0, new ArrayList<>());

        return result;

    }

    private void dfs(TreeNode root, int currSum, List<Integer> temp){

        // Base 

        if(root == null) return;

        currSum += root.val;

        temp.add(root.val);

        if(root.left == null && root.right == null){

            if(target == currSum){

                result.add(new ArrayList<>(temp));

            }

        }

        // logic

        dfs(root.left, currSum, temp);

        dfs(root.right, currSum, temp);

        // backtrack

        temp.remove(temp.size() - 1);

    }
}