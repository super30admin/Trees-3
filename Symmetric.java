// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//Keep a track of two pointers which point to the left and right child of each node.
// Compare the values of two pointers.
public class Symmetric {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);

    }

    public boolean helper(TreeNode p1, TreeNode p2) {

        if (p1 == null && p2 == null)
            return true;

        if (p1 == null || p2 == null || p1.val != p2.val)
            return false;

        return helper(p1.left, p2.right) && helper(p2.left, p1.right);

    }

    public static void main(String args[]) {
        Symmetric obj = new Symmetric();

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);

        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);

        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);

        System.out.println(obj.isSymmetric(tree));
    }
}
