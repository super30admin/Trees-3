/*
Time Complexity : O(n * h), n => number of nodes, at n number of nodes, we are creating a list of size h
so h can be log n if it is a completely balanced tree, and it can be n if it is a skewed tree as we are doing
a deep copy so a new reference (array) is created every time we have visited a node

Space Complexity : O(n * h) + O(h), O(h) is the stack space and O(n*h) at n number of nodes, we are creating
a list of size h

Did this code successfully run on Leetcode : Yes
 */

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


//BRUTE FORCE
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path)
    {
        //base case
        if(root == null) return;

        //logic
        //deep copy of list, so a new list will be created at every node which will be copied to list
        List<Integer> list = new ArrayList<>(path);
        currSum += root.val;
        list.add(root.val);

        //checking the leaf node
        if(root.left == null && root.right == null)
        {
            if(currSum == targetSum) {
                result.add(list);
            }
        }

        helper(root.left, targetSum, currSum, list);
        helper(root.right, targetSum, currSum, list);
    }
}
