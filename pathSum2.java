//time complexity: O(max height of tree * number of leaf nodes)
//space complexity: O(n^2) a new copy list of nodes is created for each node
//executed on leetcode: yes

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(root,sum,new ArrayList<>(),result);
        return result;
        
    }
    public void helper(TreeNode root,int sum,List<Integer> current,List<List<Integer>> result)
    {
        if(root==null) return;
        current.add(root.val);
        if(root.left==null && root.right==null && root.val==sum) //sum of the list elements is equal to the required sum
        {   
            result.add(current);
            return;
            
        }
        helper(root.left,sum-root.val,new ArrayList<>(current),result);
        helper(root.right,sum-root.val,new ArrayList<>(current),result);
    }
}