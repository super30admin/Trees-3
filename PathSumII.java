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

//TC: O(n^2), n: number of nodes, (as we are copying an array (O(n)) at every iteration
//SC: O(n*h), h: height of the tree, worst case: O(n^2), average: O(n log(n))
class Solution {
    List<List<Integer>> result; int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList();
        target = sum;
        if(root == null) return result;
        dfs(root, 0, new ArrayList<>());
        return result;
    }
    
    private void dfs(TreeNode root, int currSum, List<Integer> temp){
        //base
        if(root == null) return;
        currSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(temp);
            }
        }
        
        //logic
        dfs(root.left, currSum, new ArrayList(temp));
        dfs(root.right, currSum, new ArrayList(temp));
    }
}
