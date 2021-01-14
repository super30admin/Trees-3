// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the tree, space used in the recursive stack, under the hood
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Recurse to the left and right node of the tree, while checking if either the left node or right node is not equal to null and left node equals to the right node.

public class SymmetricTreeIterative {
    
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode left = root.left;
        TreeNode right = root.right;

        while((left != null && right != null) || (left == null && right != null) ||  (left != null && right == null) || !stack.isEmpty()){
            while(left != null && right != null){
                stack.push(left);       
                stack.push(right);

                left = left.left;
                right = right.right;
            }
            
            if(left == null && right == null){
                
                right = stack.pop(); //pop() will give out the right node first
                left = stack.pop();

                if(right.val != left.val) return false;

                left = left.right;
                right = right.left;
                
            } else{
                return false;
            }
        }
        
        return true;
    }
}
