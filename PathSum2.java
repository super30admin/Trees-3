// Time complexity:- O(n)
// Space complexity:- O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach 
/**
 * Approach: 
 * This problem is about finding all root-to-leaf paths in a binary tree that sum to a given target. 
 * I used a recursive backtracking approach, where I traverse the tree and keep track of the current path and sum. 
 * Once a leaf node is reached, I check if the sum matches the target, and if so, I store the path in the result.
 */ 
class Solution {
     // List to store the resulting paths that sum up to targetSum
    List<List<Integer>> result;
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;

        result = new ArrayList<>();

        // Temporary list to store the current path during recursion
        List<Integer> list = new ArrayList<>();

        // Start the recursive helper function to process the tree from the root
        helper(root,0,list);

        // Return the list of paths that sum up to targetSum
        return result;
    }

    // Helper function to explore all paths recursively
    public void helper(TreeNode node, int curSum, List<Integer> curList){

        // Base case: If the current node is null, return (no further path)
        if(node == null) {
            return;
        }

        // Action - Add the current node's value to the running sum and path
        curSum = curSum + node.val; // Update the running sum

        curList.add(node.val); // Add current node's value

        // Check if the current node is a leaf and if the sum matches the targetSum
        if(node.left == null && node.right == null && curSum == targetSum){

            // If it is a valid path, make a copy of the current path and add to result
            List<Integer> tempRes = new ArrayList<>(curList);
            
            result.add(tempRes);
        }

        //recurse left
        helper(node.left,curSum,curList);

        //recurse right
        helper(node.right,curSum,curList);

        // Backtrack: Remove the current node from the path before going back up the tree
        curList.remove(curList.size()-1);
    }
}
   

     