/**
 * Time Complexity: O(n)
 * Space Complexity: O(1) no extra space
 * Idea:
 * 1. Pass tree as two trees and check if they are mirror of one another. 
 * 2. Gives result if its mirror of itself
 * 
 * Leetcode : Yes
 */
class IsSymmettricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
    public boolean areSymmetricTrees(TreeNode root1, TreeNode root2){
        
        if(root1 == null && root2 == null)
            return true;

        // keys should be same AND
        // left subtree of root1 === right subtree of root2 AND
        // right subtree of root1 === left subtree of root2

        if(root1 != null && root2 != null && root1.val == root2.val && areSymmetricTrees(root1.left, root2.right) && (areSymmetricTrees(root1.right, root2.left))){
            return true;
        }

        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        // pass both trees as root to check if its a mirror of itself
        return areSymmetricTrees(root, root);
    }
    public static void main(String[] args){

        System.out.println("IsSymmettricTree");
        IsSymmettricTree obj = new IsSymmettricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(obj.isSymmetric(root));


    }
}