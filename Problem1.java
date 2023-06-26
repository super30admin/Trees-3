// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the number of nodes present in the tree.

// Your code here along with comments explaining your approach
    //We use a preorder traversal with a backtracking approach. We use a helper function with parameters the node and the 1-D array path, 2-D array pathList, and the sum, and also the targetSum.
    //Whenever ever we come to a node, we add the node's val to the parameter sum, we also add the node's val to the array "path". We will then recursively call the helper function for the node's children along with the updated parameters.
    //When we come to a leaf node, we check if the sum of all the numbers to the path are equal or not. If they are equal, we will add a new instance of path to 2-D Array "pathList" to preserve the list added.
    
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        open(root, path, pathList, 0, targetSum);
        return pathList;
    }

    private void open(TreeNode root, List<Integer> path, List<List<Integer>> pathList, int sum, int targetSum)
    {
        if (root==null)
        {
            return;
        }
        path.add(root.val);
        sum += root.val;
        //check if leaf
        if (root.left==null && root.right==null)
        {
            if (sum==targetSum)
            {
                pathList.add(new ArrayList<>(path));
            }
        }
        open(root.left, path, pathList, sum, targetSum);
        open(root.right, path, pathList, sum, targetSum);
        path.remove(path.size()-1);
    }
}