// Time Complexity : O(n)
// Space Complexity : O(h) h is height of tree
// Did this code successfully run on Leetcode : Yes

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
    List<List<Integer>> result = new ArrayList<>();
    int target;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return result;
        target = sum;        
        backtrack(root, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(TreeNode root, int curSum, List<Integer> pathList){
        if(root == null)
            return;
        
        curSum += root.val;
        pathList.add(root.val);
        if(root.left == null && root.right == null){
            if(curSum == target)
                result.add(new ArrayList<>(pathList));
        }
        
        backtrack(root.left, curSum, pathList);
        backtrack(root.right, curSum, pathList);
        pathList.remove(pathList.size() - 1);
        return;
    }
}

/*
// Recursive Solution O(n*n)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int target;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return result;
        target = sum;        
        helper(root, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int curSum, List<Integer> pathList){
        if(root == null)
            return;
        
        curSum += root.val;
        pathList.add(root.val);
        if(root.left == null && root.right == null){
            if(curSum == target)
                result.add(pathList);
        }
        
        helper(root.left, curSum, new ArrayList<>(pathList));
        helper(root.right, curSum, new ArrayList<>(pathList));
        return;
    }
}
*/