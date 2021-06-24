// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * We used backtracking approach to solve the problem.
 * We maintain a ArrayList and pass it to the nodes in Inorder traversal.
 * once the recursion flows back, we remove the last element which was added before recursion.
 * When we get a path with sum equal to the target, we store that in the final result List.
 */

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        inorder(root, targetSum, 0, new ArrayList<Integer>());
        
        return result;
    }
    
    private void inorder(TreeNode root, int targetSum, int curSum, List<Integer> currentList) {
        if(root == null) return;
        
        //Action
        currentList.add(root.val);
        
        if(root.left == null && root.right == null) {
            if(root.val + curSum == targetSum) {
                result.add(new ArrayList<>(currentList));
            }
        }
        
        inorder(root.left, targetSum, curSum + root.val, currentList);
        inorder(root.right, targetSum, curSum + root.val, currentList);
        
        //BackTracking
        currentList.remove(currentList.size() - 1);
    }
}