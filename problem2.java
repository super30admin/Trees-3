// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:

/*
 * Approach:
 * 1. The problem is to determine if a binary tree is symmetric around its center.
 * 2. We use a recursive approach to compare the left and right subtrees.
 * 3. If the tree is empty (root is null), it is symmetric by definition.
 * 4. Otherwise, we call the `symm` helper function, passing in the left and right subtrees.
 * 5. In the `symm` function:
 *    - If both left and right nodes are null, they are symmetric.
 *    - If one of them is null while the other is not, they are not symmetric.
 *    - If the values of the left and right nodes are not equal, the tree is not symmetric.
 * 6. We recursively check:
 *    - `left.left` with `right.right`
 *    - `left.right` with `right.left`
 * 7. If both recursive checks return true, the subtree is symmetric.
 */
public class problem2 {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isSymmetric(TreeNode root) {

        if(root==null)
        {
            return true;
        }
        return symm(root.left, root.right);
    }
    public boolean symm(TreeNode left, TreeNode right)

    {
        if(left==null || right==null)
            return left== right;

        if(left.val != right.val)
        {
            return false;
        }
        return symm(left.left, right.right) && symm(left.right, right.left);
    }
}
