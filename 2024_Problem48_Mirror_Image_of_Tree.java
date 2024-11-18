//101. Symmetric Tree - https://leetcode.com/problems/symmetric-tree/
//Time Complexity: O(n)
//Space Complexity: O(1)


class Solution {
    public boolean isSymmetric(TreeNode root) {
        //base case
        if(root == null)
            return true;

        return mirror(root, root);
    }

    public boolean mirror(TreeNode tree1, TreeNode tree2){

        //if no node present
        if(tree1==null && tree2==null){
            return true;
        }

        //if single subtree is present (therefore not mirrorred)
        // or if value is not the same
        else if(tree1==null || tree2==null || tree1.val != tree2.val){
            return false;
        }

        //both left and right is present -> check if are mirror
        else{
            return tree1.val==tree2.val &&
                    mirror(tree1.left, tree2.right) &&
                    mirror(tree1.right, tree2.left);
        }
    }
}