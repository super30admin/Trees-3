import java.util.*;

// Time Complexity : O(n) touched ll nodes and copied only desired sum elements into array list
// Space Complexity :O(h) maximum elementin the internal array list and h being the height of the arraylist
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
 
class Solution {

    // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return res;
        
        helper(root,targetSum,0,new ArrayList<>());
        
        return res;
    }
    private void helper(TreeNode root, int targetSum, int currSum, List<Integer>path){
        
        // base
        if(root==null)
            return;
        currSum=currSum+root.val;
        path.add(root.val);
        if(root.left==null & root.right==null){
            if(currSum==targetSum)
                res.add(new ArrayList<>(path));
        }
        helper(root.left,targetSum,currSum,path);
        helper(root.right,targetSum,currSum,path);
        path.remove(path.size()-1);
    }
}