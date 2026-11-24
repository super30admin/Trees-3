/**
 * Time Complexity:  O(n)  where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree
 */

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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return result;
        dfs(root, targetSum, 0, new ArrayList<>());
        return result;

    }

    void dfs(TreeNode node, int targetSum, int sum, List<Integer> nodeVals){

        sum += node.val;
        nodeVals.add(node.val);
        //base case
        if(node.left == null && node .right == null){
            if(sum == targetSum){
                result.add(new ArrayList<>(nodeVals));
            }
        }

        //recursive case
        if(node.left !=null){
            dfs(node.left, targetSum, sum, nodeVals);
        }
        if(node.right !=null){
            dfs(node.right,  targetSum, sum, nodeVals);
        }
        nodeVals.remove(nodeVals.size()-1);
    }


}