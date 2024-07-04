/**
    L.C 101. Symmetric Tree

    Approach: Tree traversal

    Working:
        Declare isSymmetric true - boolean

        recurse through left and right chile to check if it is symmetric

            recurse(root.left, root.right)

                //base
                when both are null
                    return true;

                when any one left/right is null // not symmetric
                or  when the value in left and right is not equal // not symmetric

                set isSymmetric false
                return;



                //recurse
                recurse(left.left, right.right)
                recurse(left.right, right.left)

        return isSymmetric





    Time Complexity: O(n)
    Space Complexity: O(h) //recursive stack space


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
class SymmetricTree {
    boolean isSymmetric;
    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return false;
        }
        isSymmetric = true;
        recurse(root.left, root.right);

        return isSymmetric;

    }

    private void recurse(TreeNode left, TreeNode right) {

        //base

        if(left == null && right == null) {
            return;
        }
        if(left == null || right == null) {
            isSymmetric = false;
            return;
        }

        //logic
        if(left.val!=right.val) {
            isSymmetric = false;
            return;
        }

        //recurse
        recurse(left.left, right.right);
        recurse(left.right, right.left);
    }
}
