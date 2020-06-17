// Time Complexity : O(N) where N number of nodes
// Space Complexity : O(H) where H is height of the tree
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No


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
<----Recursive--->
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //base
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
	//Logic
        if(left == null || right == null){
            return left == right;
        } 
        if(left.val != right.val){
            return false;
        } 
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

<----Iterative--->
// Time Complexity : O(N) where N number of nodes
// Space Complexity : O(N)

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
    class Pair {
        TreeNode left;
        TreeNode right;
        
        public Pair(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
        
        public TreeNode getKey() {
            return this.left;
        }
        
        public TreeNode getValue() {
            return this.right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        //base
        if(root == null){
            return true;
        }
        
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root));
        
        while(!stack.isEmpty()){
            Pair val = stack.pop();
            TreeNode left = val.left;
            TreeNode right = val.right;
            
            if(left != null || right != null){
                if(left != null && right != null && left.val == right.val){
                    stack.push(new Pair (left.left, right.right));
                    stack.push(new Pair (left.right, right.left));    
                }else{
                    return false;
                }           
            }
        }
        return true;
    }    
    
}
