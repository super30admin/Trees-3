// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /*
  * Breadth First Search
  Time Complexity: O(n)
  Space Complexity: O(h) : Stack Space Height of the Tree
  */
class SymmentricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root.left);
        myQueue.add(root.right);

        while(!myQueue.isEmpty()){
            TreeNode left = myQueue.poll();
            TreeNode right = myQueue.poll();

            if(left == null && right == null)
                continue;
            if(left == null || right == null)
                return false;
            if(left.val != right.val)
                return false;

            myQueue.add(left.left);
            myQueue.add(right.right);
            myQueue.add(left.right);
            myQueue.add(right.left);
        }
        return true;
    }
}


/*
 * Depth First Search
 * Time Complexity: O(n)
  Space Complexity: O(w) : Width of the Queue
 */
class SymmentricTree {
    boolean res;
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        this.res = true;
        helper(root.left, root.right);
        return res;
    }

    private void helper(TreeNode left, TreeNode right){

        if(left == null && right == null){
            return;
        }

        if(left == null || right == null){
            res = false;
            return;
        }

        if(left.val != right.val)
            res = false;

        //Left's left Tree with Right's right Tree
        helper(left.left, right.right);
        
        //Right's left Tree with lefts right tree
        helper(left.right, right.left);
    }
}