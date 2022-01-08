// Time Complexity : O(n) 
// Space Complexity : O(n) : Stack

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
        
        // Empty node
        if (root == null){
            return false;
        }
        
        // Iterative approach
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);


        while(!stack.isEmpty()){


            // right is pushed last so it comes first when popped.
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            // leaf node (single node itself is symmetric , so check for next nodes)
            if ( left == null && right == null){
                continue;
            }
            
            // root has only one child (either left or right sub tree)
            if (left == null || right == null){
                return false;
            }
            
            // Value of left must be equal to value of right
            if (left.val != right.val){
                return false;
            }

            // Push the elements in the stack

            // Order matters here, as two top elements are compared and considered as Stack
            stack.push(left.left);
            stack.push(right.right);

            stack.push(left.right);
            stack.push(right.left);


        }

        // Executed the entire stack without any returned value as false. So, it must be Symmetric.
        return true;
       
        
    }
    
        
}