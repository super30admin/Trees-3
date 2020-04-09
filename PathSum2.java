// 113.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time - O(n) - visist all nodes in tree
//space - O(h) for recursion stack
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        buildPaths(root, 0, sum, result, currentPath);
        return result;
    }
    
    private void buildPaths(TreeNode root, int currentSum, int target, List<List<Integer>> result, List<Integer> currentPath) {
        //base
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
            if(currentSum + root.val == target)
            {
                ArrayList<Integer> temp = new ArrayList<>(currentPath);
                temp.add(root.val);
                result.add(temp);
            }
            return;
        }
        //logic
        currentSum += root.val; //keep on increasing the sum by current root value
        currentPath.add(root.val); //add root to current path
        buildPaths(root.left, currentSum, target, result, currentPath);
        buildPaths(root.right, currentSum, target, result, currentPath);
        currentPath.remove(currentPath.size() - 1); //backtrack to remove last element
    }
    
}
