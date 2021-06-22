// Time Complexity: O(n) ..Since we are visiting each and every node of the tree
// Space Complexity: O(n).. Recursive stack size will be O(height of tree). But in worst case if the tree is linear then ..it is O(n)
//101. Symmetric Tree - Easy

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.right==null && root.left==null))
            return true;
        
        return areEqual(root.left,root.right);
        
    }
    
    public boolean areEqual(TreeNode node1, TreeNode node2)
    {
        if(node1==null && node2==null)
            return true;
        if(node1==null || node2==null)
            return false;
        if(node1.val!=node2.val)
            return false;
        
        return areEqual(node1.left,node2.right)&& areEqual(node1.right,node2.left);
    }
}