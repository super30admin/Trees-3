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
    List<Integer> individualpath = new ArrayList<>();
    void helper(TreeNode root, int currSum, int targetSum) {
        // base condition 
          if(root==null) {
              return;
          }

        //

        individualpath.add(root.val);
        
        currSum = currSum+root.val;
        helper(root.left,currSum, targetSum);
        if(root.left == null && root.right==null) {
            if(currSum == targetSum) {
           result.add(new ArrayList<>(individualpath));
        }
        }
        helper(root.right, currSum,targetSum);
        individualpath.remove(individualpath.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,0,targetSum);
        return result;
    }
}