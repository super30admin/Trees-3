

// TC : O(n)
// SC : O(h)

package S30_Codes.Trees_3;

// Definition for a binary tree node.
class TreeNode {
    int val;
    S30_Codes.Trees_3.TreeNode left;
    S30_Codes.Trees_3.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, S30_Codes.Trees_3.TreeNode left, S30_Codes.Trees_3.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;

        if(node1 == null || node2 == null)
            return false;

        if(node1.val != node2.val)
            return false;

        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}