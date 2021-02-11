// Time Complexity - O(n)
// Space Complexity - O(n * depth) --> creation of new list of n elements

// Explanation: recursively, every path is traversed and if sum is equal to target and the node is leaf, then, in the result, the path is added.
// when going backwards, the nodes are removed from the path.

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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> path = new ArrayList();
       recur(root, targetSum, 0, result, path);
       return result;
    }
    
    private void recur(TreeNode node, int target, int currentSum, List<List<Integer>> result, List<Integer> path){
        if(node == null){
            return;
        }
        currentSum = currentSum + node.val;
        path.add(node.val);
        
        if(node.left == null && node.right == null){
            if(currentSum == target){
                List<Integer> output = new ArrayList<>(path);
                result.add(output);
            }
            path.remove(path.size() - 1);
            return;
        }
       recur(node.left, target, currentSum, result, path);
       recur(node.right, target, currentSum, result, path);

       path.remove(path.size() - 1); 
    }
}
