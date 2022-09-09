// Time complexity: O(n^2) n for traversing the nodes and n for deep copying to a new list everytime
// Space complexity: O(n*H) recursive stack times a new list for every call

// Approach: Brute force. We add to the curr sum at every node and store the sum, and pathnodes as a new list at every stack element. We don't use the same list as it is just a pointer to the list. So at the end our list will contain all elements instead of the actual path that summed up to the target. To overcome this, we use a new list for every function call

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
        pathNodes.add(root.val);
        
        // logic
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == targetSum) {
                result.add(pathNodes);
            }
        }
        helper(root.left, targetSum, currSum, new ArrayList<>(pathNodes));
        helper(root.right, targetSum, currSum, new ArrayList<>(pathNodes));
    }
}