// Time Complexity : O(n) [Number of Nodes in the tree]
// Space Complexity : O(h) [For recursive stack the memory if equal to the height of the tree]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I have implemented another approach [isSymmetric2()]mentioned 
//                                           below, can TA look in to it once and provide any comments

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    List<Integer> arrList;

    public boolean isSymmetric(TreeNode root) {
        // return isSymmetric2(root);

        if (root == null) {
            return true;
        }

        // return helperQueue(root);
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        //base case for leaf node
        if (left == null && right == null) {
            return true;
        }

        //If either child is not present return false
        if (left == null || right == null) {
            return false;
        }

        //If value of left and right child are not same return false
        if (left.val != right.val) {
            return false;
        }

        //Check the left child of left with right child of right and check right child of left with left child of right
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    private boolean helperQueue(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if(leftNode == null && rightNode == null) {
                continue;
            }

            if(leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            queue.offer(rightNode.right);
            queue.offer(leftNode.left);

            queue.offer(rightNode.left);
            queue.offer(leftNode.right);
        }

        return true;
        
    }

    /*
     * Another approach:: isSymmetric2() Method
     * Did a inorder travesal and then find out find and comparing First and Last
     * All Test cases passed but one mentioned below [Test case no. 199]
     * [5,4,1,null,1,null,4,2,null,2,null]
     * 
     * I am using https://binary-tree-builder.netlify.app/ to contruct the Tree, it
     * gives the Array representation as well
     * Interestingly when I construct this tree
     * https://binary-tree-builder.netlify.app/?indextree=5,4,1,null,1,null,4,null,
     * null,2,null,null,null,2
     * The array representation doesn't match the input
     * [5,4,1,null,1,null,4,null,null,2,null,null,null,2]
     * 
     * And When I passed the LeetCode Inputs in the query param mentioned below
     * https://binary-tree-builder.netlify.app/?indextree=5,4,1,null,1,null,4,2,null
     * ,2,null
     * Tree is not constructed as expected
     */
    private boolean isSymmetric2(TreeNode root) {

        arrList = new ArrayList<>();
        inorderTraversal(root, false);
        if (arrList.isEmpty()) {
            return true;
        }

        int size = arrList.size();
        int mid = size / 2;

        for (int i = 0; i <= mid; i++) {

            Integer leftValue = arrList.get(i);
            Integer rightValue = arrList.get(size - i - 1);

            // Check for symmetry
            if (leftValue == null && rightValue == null) {
                continue; // Both are null, move to next pair
            } else if (leftValue == null || rightValue == null || !leftValue.equals(rightValue)) {
                return false; // Values don't match or one side is null
            }
        }

        return true;
    }

    private void inorderTraversal(TreeNode root, boolean isLeaf) {
        if (root == null) {
            //Insert null only if non leaf node
            if (!isLeaf)
                arrList.add(null);
            return;
        }
        inorderTraversal(root.left, root.left == null && root.right == null);
        arrList.add(root.val);
        inorderTraversal(root.right, root.left == null && root.right == null);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}