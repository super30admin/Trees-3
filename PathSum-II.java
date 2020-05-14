// Time Complexity : O(n) where n = total nodes in the tree
// Space Complexity : O(h*n) where h=height of tree and n=number of nodes of the path from root to leaf node
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if(result==null)
            return result;
        
        helper(root, sum, result, new LinkedList<Integer>());
        return result;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tmpList) {
        if(root==null)
            return;
        
        sum-=root.val;
        tmpList.add(root.val);
        if(root.left==null && root.right==null && sum==0){
            result.add(new LinkedList<Integer>(tmpList));
        }
        
         helper(root.left, sum, result, new LinkedList<>(tmpList));
         helper(root.right, sum, result, new LinkedList<>(tmpList));
         
    }
}

// Time Complexity : O(n) where n = total nodes in the tree
// Space Complexity : O(h) where h=height of tree 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if(result==null)
            return result;
        
        helper(root, sum, result, new LinkedList<Integer>());
        return result;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> tmpList) {
        if(root==null)
            return;
        
        sum-=root.val;
        tmpList.add(root.val);
        if(root.left==null && root.right==null && sum==0){
            result.add(new LinkedList<Integer>(tmpList));
        }
        
         helper(root.left, sum, result, tmpList);
         helper(root.right, sum, result, tmpList);
         tmpList.remove(tmpList.size()-1);
    }
}
