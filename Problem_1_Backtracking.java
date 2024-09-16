// Time complexity - O(n^2), if all the possible paths sum is equal to target. A copy of path is created while adding to result list. Hence, O(n * (n/2)) = O(n^2).
// Space complexity - O(n)

// backtrack by removing the leaf node from path.


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
    List<List<Integer>> result;
        int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        backtrack(root, 0 , new ArrayList<>());
        return result;
    }
    
    private void backtrack(TreeNode root, int currSum, List<Integer> path){
        // base
        if(root == null){
            return;
        }
        // logic
        currSum += root.val;
        path.add(root.val);
        
        // action
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        
        backtrack(root.left,currSum,path);
        backtrack(root.right,currSum,path);
        
        // backtrack
        path.remove(path.size()-1);
    }
}
