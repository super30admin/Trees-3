//Time Complexity: O(n)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes

public boolean isSymmetric(TreeNode root) {
        if (root == null)
        return true;
        return isSymmetric(root.left, root.right);
        }

public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
        return true;
        } else if (r == null || l == null) {
        return false;
        }

        if (l.val != r.val)
        return false;

        if (!isSymmetric(l.left, r.right))
        return false;
        if (!isSymmetric(l.right, r.left))
        return false;

        return true;
        }