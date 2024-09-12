//Time Complexity: O(N) where N is the total number of nodes
//Space Complexity: O(h) where h is the height of the tree and if we consider recursive stack space

//Successfully runs on leetcode: 0 ms

//Approach: We recrusively traverse through the leftmost branch of the left subtree and rightmost branch of the right subtree,
//compare the values and if at any point, they are not same, we return false, else we go to the right children of left subtree
//and left children of light subtree in the same recursive way


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
    public boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        isValid = true;
        helper(root.left, root.right);
        return isValid;
    }
    
    private void helper(TreeNode left, TreeNode right)
    {
        //base
        if(left == null && right == null)
            return;
        
        
        //logic
        if(left == null || right == null || left.val != right.val)
        {
            isValid = false;
            return;
        }
        
        helper(left.left, right.right);
        
        helper(left.right, right.left);
    }
}



//ITERATIVE

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
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root.left);
        stack.push(root.right);
        
        while(!stack.isEmpty())
        {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }
}