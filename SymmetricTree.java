/**
Time complexity: O(n)
Space complexity: O(depth of tree)
Execute successfully on Leetcode: Yes
Any problems faced: No
*/

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
    /**
    Approach:
    - This problem is solved using a recursive solution
    - If the given root is null, return true directly.
    - Else, pass the root's left and right nodes to the recursive function.
    - The base conditions are:
      - Return true when both the left and the right nodes are null i.e the leaf nodes.
      - Return false when either the left is null OR the right is null OR left.val != right.val
    - Basically, compare the left subtree with its corresponding right subtree at each level.
    */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return recurr(root.left, root.right);
    }
    
    private boolean recurr(TreeNode N1, TreeNode N2) {
        if(N1 == null && N2 == null) {
            return true;
        }
        
        if(N1 == null || N2 == null || N1.val != N2.val) {
            return false;
        }
        
        return recurr(N1.left, N2.right) && recurr(N1.right, N2.left);
    }
}
