// Time Complexity :o(n)
// Space Complexity : worst case o(n) or o(height of tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : RECURSIVE
 I faced issue in line 27 
 if(nodeA.val !=nodeB.val || nodeA==null || nodeB==null)
 If I run above condition it is throwing run time error . 
 How is above code different from current line 27

// Any problem you faced while coding this : ITERATIVE

If I change my order of if conditions it is throwing run time error.

        if(a.val!=b.val){
    return false;
    }
if(a ==null && b ==null) continue;
if(a ==null || b ==null){
    return false;
    }
    
    


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Iterative SOLUTION
class Solution {
    public boolean isSymmetric(TreeNode root) {
             if(root==null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
    
        queue.add(root.left);
          queue.add(root.right);
     
    
         while(!queue.isEmpty()) {
         TreeNode a= queue.poll();
         TreeNode b=queue.poll();
             
          
            if(a ==null && b ==null) continue;
    
                if(a ==null || b ==null){
               return false;
             }
                    if(a.val!=b.val){
              return false;
          }
                   queue.add(a.left);
                queue.add(b.right); 
             queue.add(a.right);
                 queue.add(b.left);}
          
          return true;
      }
}

// Recursive SOLUTION
public boolean isSymmetric(TreeNode root) {
    if(root==null) return true;
    return isSymmetric(root.left,root.right);
}
  private boolean isSymmetric(TreeNode nodeA,TreeNode nodeB) {
   
      if(nodeA==null && nodeB==null){
          return true;
      }
         if(nodeA==null || nodeB==null || nodeA.val !=nodeB.val){
          return false;
      }
      return isSymmetric(nodeA.left,nodeB.right) && isSymmetric(nodeB.left,nodeA.right);
  }