// In this problem, we are maintaining a current sum and a list at each node. As we traverse, we keep on adding elements to the list, 
// and check if the current list or path giving us the target sum? Yes, than copying that path to new list and adding that list to the 
// result. And also, we are removing the elements, once we are done with both recursive calls of that node.

// Time Complexity : O(n) - no. of nodes
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Backtracking
class Solution {
    // Result list
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // If root is null, no path can be found
        if (root == null) {
            return new ArrayList<>();
        }
        // Initialize result list
        result = new ArrayList<>();
        // Call dfs method with root, currSum, path, targetSum
        dfs(root, 0, new ArrayList<>(), targetSum);
        // Return result list
        return result;
    }

    private void dfs(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        // If root is null, no path, return
        if (root == null) {
            return;
        }
        // Compute the currSum by adding the root val
        currSum = currSum + root.val;
        // Add the current node to the path
        path.add(root.val);
        // Check if it is a leaf node?
        if (root.left == null && root.right == null) {
            // Yes, than check if the currsum==targetsum
            if (currSum == targetSum) {
                // Yes than path is having our one of the result list, so copy from path to new
                // list and add that new list to result
                // Note if directly added the path to result here, always the list's reference
                // is added, so further when our path was modified, it would have the modified
                // result in path too, that's why copy to new list
                result.add(new ArrayList<>(path));
            }
        }
        // Make the left recursive call
        dfs(root.left, currSum, path, targetSum);
        // Make the right recursive call
        dfs(root.right, currSum, path, targetSum);
        // Remove the last node from path, since it's both recursive calls are completed
        path.remove(path.size() - 1);
    }
}

// Recursive - TC - O(nH) - SC - O(H^2)
class Solution {
    // Result list
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // If root is null, no path can be found
        if (root == null) {
            return new ArrayList<>();
        }
        // Initialize result list
        result = new ArrayList<>();
        // Call dfs method with root, currSum, path, targetSum
        dfs(root, 0, new ArrayList<>(), targetSum);
        // Return result list
        return result;
    }

    private void dfs(TreeNode root, int currSum, List<Integer> path, int targetSum) {
        // If root is null, no path, return
        if (root == null) {
            return;
        }
        // Compute the currSum by adding the root val
        currSum = currSum + root.val;
        // Add the current node to the path
        path.add(root.val);
        // Check if it is a leaf node?
        if (root.left == null && root.right == null) {
            // Yes, than check if the currsum==targetsum
            if (currSum == targetSum) {
                result.add(path);
            }
        }
        // Make the left recursive call
        dfs(root.left, currSum, new ArrayList<>(path), targetSum);
        // Make the right recursive call
        dfs(root.right, currSum, new ArrayList<>(path), targetSum);
    }
}