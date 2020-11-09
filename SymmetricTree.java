package S30.Trees_3;

/*
Time Complexity : O(n) [O(n/2) to be more precise]
Space Complexity : O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.Stack;

public class SymmetricTree {

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

    public boolean isSymmetricRecursive(TreeNode root) {

        return checkSymmetry(root,root);

    }

    public boolean checkSymmetry(TreeNode left, TreeNode right){


        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return left.val == right.val && checkSymmetry(left.left, right.right) && checkSymmetry(left.right,right.left);
    }

    public boolean isSymmetricIterative(TreeNode root){

        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){

            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }

        return true;

    }
}
