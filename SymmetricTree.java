/**
 * Time Complexity - O(N) where N is the number of elements in Tree.
 * Space Complexity - O(H) for the recursion stack. H is equal to N in case of a skewed tree.
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
    public boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null)
            return true;
        if(tree1 == null || tree2 == null)
            return false;
        return (tree1.val == tree2.val && isSymmetric(tree1.left, tree2.right) && isSymmetric(tree1.right, tree2.left));
    }
}

/*
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList();       
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;       
    }
*/
