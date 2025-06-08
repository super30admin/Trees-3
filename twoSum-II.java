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

 //Time complexity - O(n^2)
 // Space complexity - O(n)
 // Did you face any issue - No
 // Solved on leetcode - yes
 // This solution performs a depth-first traversal of the binary tree while maintaining a running path and sum. At each node, it adds the current value to a temporary path and checks if a leaf node is reached and the sum matches the target; if so, it adds a copy of the path to the result list. After visiting both child nodes recursively, it performs backtracking by removing the last added node from the path to explore other paths correctly.
class Solution {
            List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
         helper(root, targetSum, 0, path );
         return result;
    }

    public void helper(TreeNode root, int targetSum, int currentSum, List<Integer> path) {
       // base
        if(root == null) return;
       // logic
       path.add(root.val);
       currentSum = currentSum + root.val;
       if(root.left == null && root.right== null && currentSum == targetSum) {
            result.add(new ArrayList<>(path));
       }
       helper(root.left, targetSum, currentSum, path);
       helper(root.right,targetSum, currentSum, path);
        path.remove(path.size()-1);
    }
}
