// Time complexity: O(n) n for traversing the nodes
// Space complexity: O(n) recursive stack

// Approach: Optimized. We add to the curr sum at every node and store the sum, and use the same pathnodes list. We need to backtrack, which is reverse the action done so that we can use our same list everytime. Also, we need to make sure that when we find the target at a leaf node, we need to add a new list in teh result by copying elements of previous list

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> pathNodes) {
        // base
        if (root == null) return;
        
        // action
        // Add the current node to the path's list
        pathNodes.add(root.val);
        
        // logic
        // add node value to current sum
        // Check if the current node is a leaf and also, if it
        // equals our remaining sum. If it does, we add the path to
        // our list of paths. Note we use a new list in this case and copy all our elements otherwise after backtracking
        // we will have an empty list as we will remove all elements one by one when they are done processing
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(new ArrayList<>(pathNodes));
            }
        }
        helper(root.left, targetSum, currSum, pathNodes);
        helper(root.right, targetSum, currSum, pathNodes);
        
        // backtracking step. Very important. We reverse the action perfomed (pathNodes.add(root.val))
        // We need to pop the node once we are done processing ALL of it's subtrees.
        pathNodes.remove(pathNodes.size() - 1);
    }
}