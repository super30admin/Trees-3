/*
* Approach:
*  1. Start from root.left and root.right.
* 
*  2. Compare left subtree with right subtree,
        if equal, compare left.left with right.right for symmetry
                and also compare left.right with right.left for symmetry
        else,
            return false;
* 
*  3. finally return true
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(h)
    height of tree
* 
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree {
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        
        if(left==null || right==null)
            return false;
        
        return left.val == right.val && 
            isSymmetric(left.left, right.right) && 
            isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return false;

        return isSymmetric(root.left, root.right);
    }
}