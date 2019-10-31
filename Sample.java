// Time Complexity :O(n)
// Space Complexity :O(1_
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :edge case caused runtime error


// Your code here along with comments explaining your approach


// * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
public boolean isMirror(TreeNode node1, TreeNode node2)  
    { 
        
        if (node1 == null && node2 == null) 
            return true; 
   
        if (node1 != null && node2 != null && node1.val == node2.val) 
            return (isMirror(node1.left, node2.right) 
                    && isMirror(node1.right, node2.left)); 
   
        return false; 
    } 
   
    
    boolean isSymmetric(TreeNode node)  
    { if(node==null){
        return true;
    }else{
        // check if tree is mirror of itself 
        return isMirror(node.left, node.right); 
    }
    } 
}