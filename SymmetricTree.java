//The approach here is that we take two nodes for left and right and perform recursion on both of them simultaneously.
//At each node, we check if the value of the left tree and right tree is same and then we check the same for child nodes.
//For child nodes, we check if the left of the left tree and the right of the right tree is same as well as the right of the left tree and the left of the right tree is same
//Time Complexity: O(n)
//Space Complexity: O(h) where h is the maximum depth of a tree from root to a leaf node
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

class Solution {
    public boolean isSymmetric(TreeNode root) {
        //base case
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p1, TreeNode p2){
        if(p1 == null && p2 == null) return true;
        if(p1 == null || p2 == null) return false;
        return p1.val == p2.val && helper(p1.left, p2.right) && helper(p1.right, p2.left);
    }
}