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
/*
time complexity: O(n), n is number of nodes
space: O(h), h is the height of tree
*/
class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
//         Stack<TreeNode> stack = new Stack<>();
        
//         stack.push(root.right);
//         stack.push(root.left);
        
//         while(!stack.isEmpty()){
            
//             //pop left
//             TreeNode lNode = stack.pop();           
//             //pop right
//             TreeNode rNode = stack.pop();
            
//             //always check for null first
//              if(rNode == null && lNode == null) continue;
//              if(rNode == null || lNode == null)return false;
//             //then check the values of nodes
//              if(rNode.val != lNode.val)return false;
      
            
//             stack.push(lNode.right);
//             stack.push(rNode.left);
//             stack.push(rNode.right);
//             stack.push(lNode.left);
            
       
//         }
        return helper(root.left,root.right);
        //return true;
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        
        if(left == null && right == null)return true;
        if(left == null || right == null)return false;
        return (left.val == right.val) 
            && helper(left.right, right.left) 
            && helper(left.left,right.right);
    }
    
}