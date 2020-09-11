//IS symettric
// Time Complexity :0(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes


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
    public boolean isSymmetric(TreeNode root) {
         return isMirror(root,root);
    }
   private boolean isMirror(TreeNode node1, TreeNode node2)  
    {  
        if (node1 == null && node2 == null) 
            return true; 
   
        
        if (node1 != null && node2 != null && node1.val == node2.val) 
            return (isMirror(node1.left, node2.right) 
                    && isMirror(node1.right, node2.left)); 
   
        
        return false; 
    } 
}

//Path sum2
// Time Complexity :0(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes


// Your code here along with comments explaining your approach
/**
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
        List<Integer> currpath=new ArrayList<>();
        List<List<Integer>> output=new ArrayList<>();
        recurr(root,sum,0,currpath,output);
        return output;
        }
    private int output=0;
     private void recurr(TreeNode root, int target, int currsum, List<Integer> currpath,List<List<Integer>> output){
         if(root==null){
             return;
         }
         if(root.left==null && root.right==null)
         {
             if(currsum+root.val==target)
             {
                 List<Integer> temp= new ArrayList(currpath);
                 temp.add(root.val);
                 output.add(temp);
             }
         }
            currpath.add(root.val);
         recurr(root.left,target,currsum+root.val,currpath,output);
         recurr(root.right,target,currsum+root.val,currpath,output);
         currpath.remove((currpath.size()-1));
}
    
}
