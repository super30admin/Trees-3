// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Approach : We performed boolean based recursion here, starting by checking the left and right node of the given root. At every step, we check if we are leaf or either
// one of node is empty or node values are not equal. For symmetric check, we compare the left child of node1 with right child of node2 and continue the recursion.

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode node1, TreeNode node2){
        if(node1 ==null && node2 == null){ //reached leaf
            return true;
        }
        if(node1 == null || node2 == null){ //if either of them is null, not symmetric
            return false;
        }
        if(node1.val != node2.val){ //different node so not symmetric
            return false;
        }
        return mirror(node1.left, node2.right) && mirror(node1.right, node2.left);

    }
}