// Time Complexity :
//      n is the number of elements
//      isSymmetric() - O(n)
//      
// Space Complexity :
//      isSymmetric() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    Stack<TreeNode> stk = new Stack<>();
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        stk.push(root.right);
        stk.push(root.left);
        
        while(!stk.isEmpty())
        {
            TreeNode n1 = stk.pop();
            TreeNode n2 = stk.pop();
            
            if(n1 == null && n2 != null) return false;
            if(n2 == null && n1 != null) return false;
            if((n1 != null && n2 != null) && (n1.val != n2.val)) return false;
            if(n1 != null && n2!= null)
            {
                stk.push(n1.left);
                stk.push(n2.right);
                stk.push(n1.right);
                stk.push(n2.left);
            }
        }
        return true;
    }
}
