/*Time Complexity: O(n) traversing to every node once.
 * Space Complexity: O(1) constant space and O(h) will be the stack space.
 * Leetcode: yes
 * Any Issues: No
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean symm(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null)
            return true;
        else if(root1 == null || root2 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        
        return (symm(root1.left, root2.right) && symm(root1.right, root2.left));
    }
    public boolean isSymmetric(TreeNode root) {
        
        return symm(root.left, root.right);
    }
}