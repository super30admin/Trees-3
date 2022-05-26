//https://leetcode.com/problems/path-sum-ii/

// Time Complexity :O(n) 
// Space Complexity :O(h) h=height of the tree
// Did this code successfully run on Leetcode : yes
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
    List<List<Integer>> total=new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        inorderhelper(root,new ArrayList<Integer>(),0,targetSum);
       
        return total;
    }
     private void inorderhelper(TreeNode root,List<Integer> local,int lsum,int target)
    {
        if(root==null)
            return;
        local.add(root.val);
         System.out.println("lsum "+lsum);
        if(root.left==null && root.right==null)
        {
            lsum+=root.val;
       
            System.out.println("lsum "+lsum);
            if(lsum==target)
            {
                System.out.println("found"+local);
               
                List<Integer> temp=new ArrayList<Integer>(local);
               
                total.add(temp);
            }
                
        }
         
        inorderhelper(root.left,new ArrayList<Integer>(local),lsum+root.val,target);
        inorderhelper(root.right,new ArrayList<Integer>(local),lsum+root.val,target);
    }
}