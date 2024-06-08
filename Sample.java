// Problem 1
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
 // backtracking
class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if( root==null) return new ArrayList<>();
        result=new ArrayList<>();
        path= new ArrayList<>();
        dfs(root,0,targetSum);
        return result;
    }
    private void dfs(TreeNode root, int curSum, int target)
    {
        if(root==null) return;
        curSum=curSum+root.val;
        path.add(root.val);
        // action
        if(root.left==null && root.right==null)
        {
            if(curSum==target)
            {
                result.add(new ArrayList<>(path));
               
            }
         
        }
        // recurse
        dfs(root.left, curSum,target);
        dfs(root.right,curSum,target);
        //backtrack
        path.remove(path.size()-1);
    }
}
/**
class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return new ArrayList<>();
        result=new ArrayList<>();
        dfs(root,0,new ArrayList<Integer>(),targetSum);
        return result;
      
        
    }
    private void dfs(TreeNode root, int currSum, List<Integer> path, int targetSum)
    {
        if(root==null) return;
        path.add(root.val);
        currSum=currSum+root.val;
        if(root.left==null && root.right==null)
        {
            if(currSum==targetSum)
            {
                result.add(path);
                
            }
            return;
        }
        dfs(root.right,currSum,new ArrayList<>(path),targetSum);
        dfs(root.left,currSum,new ArrayList<>(path),targetSum);
    }
}
 */


 // Problem 2
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

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
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        isSymmetric=true;
        dfs(root.left,root.right);
        return isSymmetric;
    }
    private void dfs(TreeNode left,TreeNode right)
    {
        if(left==null && right==null)
        {
return;
        }
        if(left==null || right==null)
        {
            isSymmetric=false;
            return;
        }
        if(left.val!=right.val)
        {
            isSymmetric=false;
            return;
        }
        dfs(left.left,right.right);
        dfs(left.right,right.left);
    }
}