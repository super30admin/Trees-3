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

/*
*
*/

/*
* The concept is similar to path sum I but instead of just returning true or false, we also need to return the path of root-to-leaf that gives us the target sum.
- For tracking the path, pass path as a parameter to the recursive call as that will help us avoid creating deep copies of the node at every call as DS within a DS is a reference. 
- Once we reach the leaf, we check if we have found target, if so, add the path to the result list(global variable)
- If target is not found, we need to backtrack to store the parents state to avoid accumulating all the nodes from the previous branches
TC: O(n) -> iterate through all the nodes
SC: O(h) -> recursive stack -> at max height of the tree 
 */
class Solution {
    //global variable to store the result
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.ans = new ArrayList<>();

        // list to track path
        List<Integer> path = new ArrayList<>();
        helper(root, targetSum, path);
        return ans;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> path){
        //base
        if(root == null)
            return;
        //logic

        targetSum -= root.val;
        path.add(root.val);

        // if we have reached the leaf and the targetSum has become zero then we have found the root-to-leaf path that gives us the targetSum, so we add it to the result list
        if(root.left == null && root.right == null && targetSum == 0){
            ans.add(new ArrayList<>(path));
        }

        helper(root.left, targetSum, path);
        helper(root.right, targetSum, path);
        // backtrack to ensure path is restored to the parent's state 
        path.remove(path.size() - 1);
    }
}