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

/*
    Leetcode problem 113: Path Sum II 
    T.C: O(n) - copying the elements of the path to a new list for each recursive call
    S.C: O(n) - Maintaining a list for every node + recursive stack space

    Solved using Recursive approach (DFS): We pass the root node, currSum
    and the path (traversed from root to curr node) to the helper method.
    Maintain a list of list of Integers as a global variable and call it result. 
    Now call this helper method recursively to the left and right of the root node, 
    the instructions to execute before the recursive call would be to add the curr value
    of the node to the path and calculate the curr sum and check if the node is the leaf
    node (if yes then check if the sum == target and add the path to result, else do nothing).

    Note:
    The base case would simply have to return as its a void method.
    Make sure you pass a new ArrayList<>(path) for each recursive call, as list is passed by 
    reference in Java.
*/

class Solution {

    List<List<Integer>> result;
    List<Integer> path;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();

        result = new ArrayList<>();
        path = new ArrayList<>();
        target = targetSum;

        helper(root, 0);

        return result;
    }

    private void helper(TreeNode root, int sum) {
        //Base case
        if (root == null) return;
        //Logic - DFS
        //Action
        path.add(root.val);
        sum += root.val;

        //Add the path to result if root to leaf sums up to target
        if (root.left == null && root.right == null && sum == target) {
            result.add(new ArrayList<>(path));
        }

        //Recursion
        helper(root.left, sum);
        helper(root.right, sum);

        //Backtracking
        path.remove(path.size() - 1);
    }
}