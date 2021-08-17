//Time Complexity: O(n), visiting all the elements of the tree, #elements in the tree is n
//Space Complexity: O(h), recursion stack for the height of the tree
//running on leetcode: yes

class Solution {
    public boolean isSymmetric(TreeNode root) {
        //empty tree is a symmetric tree
        if (root==null)
        {
            return true;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right)
    {
        //base case: conditions of asymmetry explained above
        if (left==null && right==null)
        {
            return true;
        }
        if (left==null || right==null || left.val != right.val)
        {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
