//Approach: Using recursion we can check if the left value is not equal to right val, then return else or else the left and right subtrees are symmetric.
//Time Complexity : O(n)
//Space Complexity: O(1)
class SymetricTree {
    public boolean isSymmetric(TreeNode root)
    {
        if(root == null) return false;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right)
    {
        //base condition
        if(left == null && right == null) return true;

        //If any of the left or right nodes is null, that means the other part is not null and so not symmetric
        if(left == null || right == null) return false;

        //left value when equals to right value then it is considered symetric
        if(left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}