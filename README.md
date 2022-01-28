# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)
// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :-


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
    // creating target as a class variable so that the preorder function can access it 
    int target;
    // creating result as the return data structure
    List<List<Integer>> result;
    
    private boolean isLeaf(TreeNode node)
    {
        if(node.left == null && node.right == null)
        {
            return true;
        }
        return false;
    }
    private void preorderTraversal(TreeNode root, int sum, List<Integer> path)
    {
        //process the root node first
        if(root == null) return;
        //1. update the sum
        sum += root.val;
        //2. update the path
        path.add(root.val);
        //3. check if we have met the target
        if( sum == target && isLeaf(root))
        {
            result.add(new ArrayList<>(path));
        }
        //left subtree call
        preorderTraversal( root.left,  sum,  path);
        //right subtree call
        preorderTraversal( root.right,  sum,  path);
        path.remove(path.size()-1);
        
    }
        
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        this.result = new ArrayList<>();
        preorderTraversal(root, 0, new ArrayList<Integer>());
        return result;
        
    }
}

## Problem2 (https://leetcode.com/problems/symmetric-tree/)
// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :-


// Your code here along with comments explaining your approach
class Solution {
    private boolean helper(TreeNode left, TreeNode right)
    {
        //base case 
        //null checks 
        if(left == null && right == null) return true;
        if(left != null && right == null) return false;
        if(left == null && right != null) return false;
        //value checks 
        if(left.val != right.val) return false;
        //recursion 
        return helper(left.left, right.right) && helper(left.right , right.left);
        
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return helper(root.left, root.right);
    }
}