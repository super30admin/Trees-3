// Time Complexity : O(N) N no.of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach/**
Recursively traversed through the entire tree in inorder traversal and when we reah the leaf the current sum
is added to the global sum.


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,0,new ArrayList<>(),targetSum);
        return result;
    }
    private void helper(TreeNode root,int cursum,List<Integer>path, int targetSum){
        if(root==null) return;
        path.add(root.val);
        cursum=cursum+root.val;
        helper(root.left,cursum,new ArrayList<>(path),targetSum);
        if(root.left==null && root.right==null){
            if(cursum==targetSum){
            result.add(new ArrayList<>(path));
            }
        }
        
        helper(root.right,cursum,new ArrayList<>(path),targetSum);
        path.remove(path.size()-1);
        return;
    }
}