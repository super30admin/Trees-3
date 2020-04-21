// Time Complexity : O(N) N=number of elements  in  the TREE. 
// Space Complexity : O(1) no extra space used.
//  Space ComplexityWith recursive stack is: O(max(depth of tree)). 
// Any problem you faced while coding this :


// We traverse the tree recursively doing two recursive calls one with extreme leafs and another recursive call with inner leafs.   
//Success
//Details 
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
//Memory Usage: 37.6 MB, less than 74.15% of Java online submissions for Symmetric Tree.
    public boolean isSymmetric(TreeNode root) {
      if (root == null) return true;
      return isMirror(root.left, root.right);
    }

  private boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left != null && right == null) return false;
    if (left == null && right != null) return false;
    if (left.val != right.val) return false;

    return isMirror(left.left, right.right) && isMirror(left.right, right.left);
  }