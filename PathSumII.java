/*
 * TC: O(n^2) its because if in worst case we have complete binary tree and for each leaf 
 * we copy the list to the result which would take O(n) for each leaf and nodes at leaf  would be (n/2).
 * SC: O(n) space for recursive stack. worst case each node has only left child.
 * 
 * Apprach: I am implementing DFS using recursion and keep track of my running sum at every node.
 * whenever the runnign sum at any node becomes equals my targetSum theni will check if it is the leaf
 * node. if it is then i will add the list to the result.  
 */

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
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      helper(root, targetSum, new ArrayList<>());   
      return result;
    }


    private void helper(TreeNode root, int targetSum, List<Integer> li){
        if(root == null) return;

        li.add(root.val);

        if(root.left == null && root.right == null && targetSum == root.val){
            result.add(new ArrayList<>(li));
        }
        else{
        helper(root.left, targetSum - root.val, li);
        helper(root.right, targetSum - root.val, li);
        }

        li.remove(li.size() - 1);
    } 
}