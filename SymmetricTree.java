// Time Complexity : O(n)
// Space Complexity : O(h) for DFS, O(n) for BFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - A tree is symmetric if the left subtree is a mirror of the right subtree.
//    - For DFS: Recursively check if left.left == right.right and left.right == right.left.
//    - For BFS: Use a queue to compare pairs of nodes in mirror positions.

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
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

public class SymmetricTree {
    //DFS
     public boolean isSymmetricDFS(TreeNode root) {
         if(root == null) {
             return true;
         }
         return __isSymmetric(root, root);
     }

     private boolean __isSymmetric(TreeNode root1, TreeNode root2) {
         if(root1 == null && root2 == null) {
             return true;
         }
         if(root1 == null || root2 == null) {
             return false;
         }

         return (root1.val == root2.val) && __isSymmetric(root1.left, root2.right) && __isSymmetric(root1.right, root2.left);

     }


    //BFS
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }
            if(left.val != right.val) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        SymmetricTree solver = new SymmetricTree();

        System.out.println("Is tree symmetric? (BFS): " + solver.isSymmetric(root));       // Expected: true
        System.out.println("Is tree symmetric? (DFS): " + solver.isSymmetricDFS(root));
    }
}
