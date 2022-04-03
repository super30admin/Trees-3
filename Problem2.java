// Time Complexity : O(# of nodes)
// Space Complexity : O(h) where h is height of tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

import java.util.*;

// Recursive solution
class Solution {

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
        if (root == null) {
            return true; 
        }
        else {
            return check(root.left, root.right);
        }
    }
    
    private boolean check(TreeNode leftSubTree, TreeNode rightSubTree) {
         if (leftSubTree == null && rightSubTree == null) {
             return true;
         }
        
        else if (leftSubTree == null || rightSubTree == null || leftSubTree.val != rightSubTree.val) {
            return false;
        }
        
        else {
            return check(leftSubTree.left, rightSubTree.right) && check(leftSubTree.right, rightSubTree.left);
        }
    }
}

// Iterative solution
class Solution2 {

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
        
        if (root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root.right);
        q.add(root.left);
        
        while (!q.isEmpty()) {
            
            TreeNode leftSubTree = q.remove();
            TreeNode rightSubTree = q.remove();
            
            if (leftSubTree == null && rightSubTree == null) {
                continue;
            }
            
            if (leftSubTree == null || rightSubTree == null || leftSubTree.val != rightSubTree.val) {
                return false;
            }
            
            else {
                q.add(leftSubTree.left);
                q.add(rightSubTree.right);
                
                q.add(leftSubTree.right);
                q.add(rightSubTree.left);
            }
        }
        return true;
    }
}
