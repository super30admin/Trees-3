/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/


// Recursive Solution: DFS

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> singleResult = new ArrayList<Integer>();
        
        getSum(root, sum, singleResult, result);
        return result;
    }
    
    public void getSum(TreeNode root, int sum, List<Integer> singleResult, List<List<Integer>> result){
        
        if(root == null)    return;
        
        singleResult.add(root.val);
        
        if(root.right == null && root.left == null && root.val == sum){
            
            result.add(new ArrayList(singleResult));
        }else{
            
            getSum(root.left, sum - root.val, singleResult, result);
            getSum(root.right, sum - root.val, singleResult, result);
        }
        
        singleResult.remove(singleResult.size() - 1);
    }
}