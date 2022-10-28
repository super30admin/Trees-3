package s30.trees.trees3;

import s30.trees.TreeNode;


// Time Complexity O(2n) n being the nodes of tree, 2n because we are repeating the steps.
// space complexity O(h) height of the resultant tree, logn <= h <= n;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {


        return isSymmetric(root, root);

    }

    private boolean isSymmetric(TreeNode node, TreeNode mirrorNode){
        if(node == null && mirrorNode == null) return true;
        if(node == null || mirrorNode == null || node.val != mirrorNode.val ) return false;

        return isSymmetric(node.left, mirrorNode.right) && isSymmetric(node.right, mirrorNode.left);


    }
    public static void main(String[] args) {

    }
}
