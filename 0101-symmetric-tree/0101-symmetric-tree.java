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
Approach:
-We are given the root of a binary treeand need to determine if it is symmetric
-A tree is symmetric if the left subtree is a mirror of the right subtree.
-We use recursion to compare nodes in the left and right subtrees:
    -Both nodes must be non-null and have equal values.
    -The left child of the left subtree must match the right child of the right subtree, and vice versa
-If all corresponding pairs of nodes are mirror images, the tree is symmetric.

Time Complexity: O(h)
-We visit each node to compare its mirror node -> O(n), where n is the number of nodes

Space Complexity : O(h)
- h = height of the tree node (due to recursion stack)
-In the worst case (skewed tree), h=n. In the best case(balanced tree), h = log(n)

 */

 //Definition for a binary tree node
public class TreeNode{
    int val; //Value of the node
    TreeNode left; //Left child
    TreeNode right; //Right child

    TreeNode() {} //Default Constructor

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        //Base Case: An empty tree is symmetric
        if(root == null) return true;

        //Call helper to compare left and right subtrees
        return helper(root.left, root.right);
        
    }

    //Helper function to compare two subtrees for mirror symmetry
    private boolean helper(TreeNode left, TreeNode right){
        //if both nodes are null, it' symmetric so far
        if(left==null && right ==null) return true;

        //If one of the nodes is null but not the other, not symmetric
        if(left == null || right == null) return false;

        //If values at the nodes are different, not symmetric
        if(left.val != right.val) return false;

        //Recurse
        //Compare the outer nodes(left.left vs right.right)
        //and the inner nodes (left.right vs right.left)
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

}