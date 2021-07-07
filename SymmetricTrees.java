/*
Author: Akhilesh Borgaonkar
Problem: LC 101. Symmetric Tree (Trees-3)
Approach: Using iterative approach here. Maintaining a stack to put in the TreeNodes sequentially which should have equal values in a mirrored
    tree. Then pop the nodes and compare them. If found mirror nodes then, push the next pairs of possible mirror nodes. 
Time Complexity: O(n) where n is number of total nodes in the Binary Tree.
Space complexity: O(log h) where h is height of the binary tree at any given time.
LC verified.
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr1 = stack.pop();
            TreeNode curr2 = stack.pop();
            // System.out.println(curr1.val +','+ curr2.val);
            
            if(curr1 == null && curr2 == null)
                continue;
            if(curr1 == null || curr2 == null)
                return false;
            if(curr1.val != curr2.val)
                return false;
            if(curr1.val == curr2.val){
                stack.push(curr1.left);
                stack.push(curr2.right);
                stack.push(curr1.right);
                stack.push(curr2.left);
            }
        }
        return true;
    }
}