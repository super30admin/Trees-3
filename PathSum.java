import java.util.ArrayList;
import java.util.List;

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

// Time Complexity : O(n2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I had to put multiple checks to ensure nodeList isn't manipulated incorrectly.


class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> nodeList = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return resList;
        helper(root,targetSum);
        return resList;
    }

    private void helper(TreeNode root,int targetSum) {
        if(root == null) return;

        nodeList.add(root.val);

        if((root.left == null && root.right == null)){
            if((targetSum-root.val) == 0)
                resList.add(new ArrayList<>(nodeList));
            
            return;
        }

        pathSum(root.left,targetSum - root.val);
    
        if(nodeList.size() > 1 && root.left != null)
            nodeList.remove(nodeList.size()-1);

        pathSum(root.right,targetSum - root.val);
        
        if(nodeList.size() > 1 && root.right != null)
            nodeList.remove(nodeList.size()-1);
    }
}