// Time Complexity : O(n^2). n is the number of nodes in a tree
// Space Complexity : O(n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




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
import java.io.*; 
import java.util.ArrayList;
class Solution {
    
    int target;
    List<List<Integer>>list;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        
        if(root==null) return new ArrayList();
        list = new ArrayList();
        target=sum;
        
        path(root,0,new ArrayList());
        return list;
        
    }
    
    private void path(TreeNode root,int sum,List<Integer> al){
        
        if(root==null) return;
        
        
        
         sum+=root.val;
         al.add(root.val);
       
        if(root.left==null && root.right==null){
            if(sum==target) list.add(new ArrayList<>(al));
        } 
        
        path(root.left,sum,al);
        path(root.right,sum,al);
        
        al.remove(al.size()-1);
        
        
    }
}
