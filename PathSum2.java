//Time Complexity:O(n) - O(n) visit nodes +O(n) copy 
//Space Complexity:O(h), stack space, ht of tree
//preorder traversal, backtrack
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
     List<List<Integer>> result;
     List<Integer> paths;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        paths = new ArrayList<>();
        checkSum(root,targetSum,0);
        return result;
    }
    private void checkSum(TreeNode root, int targetSum, int currSum){
        //base
        if(root==null) return;

        //action
        paths.add(root.val);
        currSum+=root.val;

        if(root.left==null && root.right==null && targetSum == currSum){
            result.add(new ArrayList<>(paths));
        }
         //recurse  
        checkSum(root.left,targetSum,currSum);
        checkSum(root.right,targetSum,currSum);

        //backtrack
        paths.remove(paths.size()-1);
    }
}