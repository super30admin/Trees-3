// Time Complexity:           O(n)
// Space Complexity:          O(h = log(n))
// where n is number of nodes in tree, h is height of the tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import com.sun.source.tree.Tree;

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

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        return root1.val == root2.val && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }
}


// ****************************** Iterative Approach ******************************
//class SymmetricTree {
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null)
//            return true;
//
//        Queue<TreeNode> q = new LinkedList<>();
//
//        q.add(root.left);
//        q.add(root.right);
//
//        while(!q.isEmpty()) {
//            TreeNode actual = q.poll();
//            TreeNode mirror = q.poll();
//
//            if(actual == null && mirror == null) {
//                continue;
//            }
//
//            if(actual == null || mirror == null || actual.val != mirror.val) {
//                return false;
//            }
//
//            q.add(actual.left);
//            q.add(mirror.right);
//
//            q.add(actual.right);
//            q.add(mirror.left);
//        }
//        return true;
//    }
//}