// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    /*
     public boolean isSymmetric(TreeNode root)
     {
         if (root == null)
             return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
         
         while(!stack.isEmpty())
         {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

                if(node1 == null && node2 == null)
                    continue;
                 if(node1 == null || node2 == null)
                     return false;
                 if(node1.val!=node2.val)
                     return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
         }
         return true;
     }
     */
    
    public boolean isSymmetric(TreeNode root) {
         if(root == null || (root.left == null && root.right == null))
            return true;
        
        return isSymmetric(root.left,root.right);    
       
    }
    
    private boolean isSymmetric(TreeNode root1,TreeNode root2)
    {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(root1.val!=root2.val)
           return false;
        
        boolean result1=isSymmetric(root1.left,root2.right);
        boolean result2=isSymmetric(root1.right,root2.left);
        
        return result1 && result2;
    }
}
