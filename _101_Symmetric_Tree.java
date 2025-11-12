/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(h)

//Successfully submitted in LeetCode

//We compare two node, starting with left and right, check if they equal or not, or if one is null and other is not, later compare left's right and right's left, and left's left and right's right, as that's how they can be symmetric.

public class _101_Symmetric_Tree {

  public boolean isSymmetric(TreeNode root) {
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null) {
      return false;
    }

    if (left.val != right.val) {
      return false;
    }

    return (
      isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right)
    );
  }
}
