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
class PathSum-II {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        // Edge Case Checking
        if(root == null)
            return result;
        dfs(root, targetSum, list, result);
        return result;
    }
    
    private void dfs(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result){
        if(root == null)
            return;
        
        // Add the current node value to our list
        list.add(root.val);
        
        // If we have reached the leaf node and our targetSum is achieved then add the path to the final output list
        if(root.left == null && root.right == null && targetSum - root.val == 0)
            result.add(new ArrayList(list));
        // Else make recursive calls to explore left and right subtrees
        else{
            dfs(root.left, targetSum - root.val, list, result);
            dfs(root.right, targetSum - root.val, list, result);
        }
        
        // Remove the current node value while backtracking to previous node
        list.remove(list.size()-1);
    }
}