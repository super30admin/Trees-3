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
 // Iterative Solution
 // Time complexity - O(N) or O(H)
 // Space complexity - O(N) 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return true;
        }
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode root1 = stack.pop();
            TreeNode root2 = stack.pop();
            if(root1 == null && root2 == null){
               continue;
            }
             if(root1 == null || root2 == null || root1.val != root2.val){
                 return false;
             }
            stack.push(root1.left);
            stack.push(root2.right);
            stack.push(root1.right);
            stack.push(root2.left);
        }
        return true;
    }
}

/*
Recursive Solution
Time COmplexity - O(N)
Space Complexity - O(N)
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSame(root.left,root.right);
    }
    
    public boolean isSame(TreeNode root1, TreeNode root2){
        if(root1==null || root2==null){
            return root1==root2;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isSame(root1.left,root2.right) && isSame(root1.right,root2.left);
    }
}