/*
Time Complexity: O(N)
Space Complexity: O(N)
Code run on Leetcode: yes
Any difficulties: no

Approach
1. Recursively mirror the tree and see if there is a symmetry
 */
public class SymmetryTrees {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left  = left;
            this.right = right;
        }
    }
    public static boolean symmetricTrees(TreeNode root){
        return isMirror(root, root);
    }
    public static boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }

        return (t1.val == t2.val) &&  isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(symmetricTrees(root));
    }
}
