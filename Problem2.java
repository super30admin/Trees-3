
//Time Complexity: O(n) where n is the number of nodes in the tree
//Space Complexity: O(h) for the recursion stack where h is the height of the tree

//we use recursion to check if the left and right subtrees are mirror images of each other
//we compare the left child of one subtree with the right child of the other subtree and vice versa
//if both nodes are null we return true
//if one of them is null or their values are not equal we return false

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return mirror(root.left,root.right);
    }
    private boolean mirror(TreeNode r1,TreeNode r2){
        if(r1==null&&r2==null)
            return true;
        if(r1==null||r2==null) return false;
        if(r1.val!=r2.val)
            return false;
        return mirror(r1.left,r2.right)&&mirror(r1.right,r2.left);
    }
}