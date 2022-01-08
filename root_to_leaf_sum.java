// Time Complexity : O(n^2) [n/2 leaf nodes * (copying of list into new array list takes O(n))]
// Space Complexity : O(n)  [currList only must be counted as result (list of list) is returned value of the function block. ]

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
    List<List<Integer>> result =  new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        helper(root, targetSum, 0, new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> currList){
        
        // empty node
        if (root == null){
            return;
        }
        
        // Compute the list at the leaf node if currSum matches with targetSum
        if (root.left == null && root.right == null && ((currSum + root.val) == targetSum)){
            
            // Append the root value into the List
            currList.add(root.val);
            
            // Add the curr list to the result
            result.add(new ArrayList(currList));
            
            // Backtracking to find the sum ( Undo the task of 47 line)
            currList.remove(currList.size() - 1 );
            
            return;
            
        }
        
        // Node 
        // Update the fields as per the root
        currSum += root.val; 
        currList.add(root.val);
        
        // Left sub tree
        helper(root.left , targetSum, currSum, currList);
        
        // Right sub tree
        helper(root.right , targetSum, currSum,currList);
        
        // Backtracking to find the sum ( Undo the task of 47 line)
        currList.remove(currList.size() - 1 );
    }
}