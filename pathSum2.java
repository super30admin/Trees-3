// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :	Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
    
    private void helper(TreeNode node, int sum, List<Integer> pathNodes, List<List<Integer>> pathList)
    {
     if (node == null)
     {
         return;
     }
        pathNodes.add(node.val);
        
        if(sum == node.val && node.right == null && node.left == null)
        {
            pathList.add(new ArrayList(pathNodes));
        }
        else
        {
         helper(node.left, sum - node.val, pathNodes, pathList);   
         helper(node.right, sum - node.val, pathNodes, pathList);      
        }
        pathNodes.remove(pathNodes.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList =  new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<>();
        helper(root,sum,pathNodes,pathList);
        return pathList;
    }
}