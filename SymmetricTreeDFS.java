//TC: O(n)
//SC: O(h)
//approach: DFS/recursive
public class SymmetricTreeDFS {
    public boolean isSymmetric(SymmetricTreeBFS.TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(SymmetricTreeBFS.TreeNode left, SymmetricTreeBFS.TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
