//Brute Force
//Time = O(n^2)
//Space = O(n^2)

class Solution {
    List<List<Integer>> result = new ArrayList<>(); // initialize the result list as a class variable

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) { // if the root is null, return an empty result list
            return result;
        }
        helper(root, targetSum, new ArrayList<>()); // call the helper function with the root node, target sum, and an empty list to keep track of the current path
        return result; // return the result list
    }

    private void helper(TreeNode root, int targetSum, List<Integer> currentList) {
        if (root == null) { // if the root is null, return
            return;
        }
        currentList.add(root.val); // add the current node's value to the current path
        if (root.left == null && root.right == null && targetSum == root.val) { // if the current node is a leaf node and the current path's sum equals the target sum, add the current path to the result list
            result.add(new ArrayList<>(currentList));
        } else { // if the current node is not a leaf node, recursively call the helper function on its left and right subtrees
            helper(root.left, targetSum - root.val, currentList);
            helper(root.right, targetSum - root.val, currentList);
        }
        currentList.remove(currentList.size() - 1); // remove the current node's value from the current path as we backtrack
    }
}

--------------------------------------------------------------------------------------------------------------------------------------------------
  
  //Depth-first search (DFS) approach
  //Time = O(n^2)
  //Space = O(n)
  
  class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);
        return result;
    }
    
    private void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left, targetSum - node.val, path, result);
            dfs(node.right, targetSum - node.val, path, result);
        }
        path.remove(path.size() - 1);
    }
}
