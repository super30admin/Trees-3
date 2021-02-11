/**
Time complexity: O(n)
Space complexity: O(depth of tree)
Execute successfully on Leetcode: Yes
Any problems faced: No
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
    /**
    Approach:
    - This is solved using a recursive solution.
    - We calculate the current sum at each node and keep track of the nodes traversed in an array list.
    - Once a leaf node is reached, the current sum is compared with the given target sum. 
    - If they're equal, the array list tracking the path is copied into a temp array list and added to the final output list.
    - A copy is made because we are using only list to track the path and that cannot be added directly to the output list because that will be a pass by reference operation. Modifying the path array list also modifies the values added to the final output list.
    - Once a leaf node is processed, the last element in the path array is removed to track other paths.
    */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        recurr(root, targetSum, 0, output, path);
        
        return output;
    }
    
    private void recurr(TreeNode root, int targetSum, int currSum, List<List<Integer>> output, List<Integer> path) {
        if(root == null) {
            return;
        }
        
        currSum += root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null) {
            if(targetSum == currSum) {
                List<Integer> temp = new ArrayList<>(path);
                output.add(temp);
            }
            path.remove(path.size() - 1);
            return;
        }
        
        recurr(root.left, targetSum, currSum, output, path);
        recurr(root.right, targetSum, currSum, output, path);
        
        path.remove(path.size() - 1);
    }
}
