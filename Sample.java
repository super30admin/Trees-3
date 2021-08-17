// Time Complexity :
// Space Complexity :
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
    List<List<Integer>> result =new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return new ArrayList<>();
        }
        dfs(root,targetSum,new ArrayList<>());
        return result;
        
        
    }
    public void dfs(TreeNode root,int targetSum,List<Integer> path){
        //base
        if(root==null){
            return;
        }
    
        
        //logic
        path.add(root.val);
            if(root.left==null && root.right==null){
                if(targetSum-root.val==0){
                    result.add(new ArrayList<>(path));
                }
            }
        dfs(root.left,targetSum-root.val,path);
        dfs(root.right,targetSum-root.val,path);
        path.remove(path.size()-1);
    }
}



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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null||right==null||left.val!=right.val){
            return false;
        }
        
            return (helper(left.left,right.right) && helper(left.right,right.left));
        
    }
}