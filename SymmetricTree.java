// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
import java.util.LinkedList;
import java.util.Queue;

// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSymmetricRecursion(root.left, root.right);
    }

    static boolean isSymmetricRecursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return isSymmetricRecursion(left.left, right.right) &&
               isSymmetricRecursion(left.right, right.left);
    }

    public static void main(String[] args) {
        Integer[] values = {1, 2, 2, 3, 4, 4, 3};

        TreeNode root = createTree(values);

        boolean result = isSymmetric(root);

        System.out.println("Is the tree symmetric? " + result);
    }

    public static TreeNode createTree(Integer[] values) {
        if (values.length == 0) return null;
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}