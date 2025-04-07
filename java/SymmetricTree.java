package java;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    boolean flag;

    public boolean isSymmetric(TreeNode root) {
        this.flag = true;
        helper(root, root);
        return flag;
    }

    private void helper(TreeNode t1, TreeNode t2) {
        //base
        if (!flag || (t1 == null && t2 == null))
            return;

        if (t1 == null || t2 == null || t1.val != t2.val) {
            flag = false;
            return;
        }

        helper(t1.right, t2.left);
        helper(t1.left, t2.right);
    }
}

//TC: O(n)
//SC: O(h)


//Approach-2

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);

        }
        return true;
    }
}

//TC: O(n)
//SC: O(h) - worst case is O(n)