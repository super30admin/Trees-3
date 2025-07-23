//Time Complexity: O(n²) — due to copying the path list for up to n root-to-leaf paths.
//Space Complexity: O(n) — for recursion stack and path list during DFS traversal.

//Use DFS to explore all root-to-leaf paths, maintaining a running sum and current path.
//When reaching a leaf, check if the running sum equals the target; if so, store a copy of the path.
//Backtrack by removing the last element before returning to the previous node.

class Solution {
    List<List<Integer>> allPaths;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.allPaths = new ArrayList<>();
        findPaths(root, targetSum, 0, new ArrayList<>());
        return allPaths;
    }

    private void findPaths(TreeNode currentNode, int targetSum, int runningSum, List<Integer> currentPath) {
        // Base case
        if (currentNode == null) return;

        // Action: add current node value to path and running sum
        runningSum += currentNode.val;
        currentPath.add(currentNode.val);

        // If it's a leaf node and sum matches, add path to result
        if (currentNode.left == null && currentNode.right == null) {
            if (runningSum == targetSum) {
                allPaths.add(new ArrayList<>(currentPath));
            }
        }

        // Recurse
        findPaths(currentNode.left, targetSum, runningSum, currentPath);
        findPaths(currentNode.right, targetSum, runningSum, currentPath);

        // Backtrack: remove last added node
        currentPath.remove(currentPath.size() - 1);
    }
}
