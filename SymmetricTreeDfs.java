//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode :Yes
//Approach: Looking closely at the examples, we see that the elements to the left and to the right of the tree should be the mirror image of each other
//Taking that into consideration, if we move beyond the 2nd level, we figure that left.left = right.right, left.right = right.left, else the tree is not symmetric,
// if both left and right nodes are null, which means we are beyond the leaf node, return true
//This can be done using BFS, DFS, but we will implement this using DFS
public class SymmetricTreeDfs {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public static void main(String[] args) {
        final SymmetricTreeDfs symmetricTreeDfs = new SymmetricTreeDfs();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        System.out.println(symmetricTreeDfs.isSymmetric(root)); //return true
        root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        System.out.println(symmetricTreeDfs.isSymmetric(root)); //return false
    }
}
