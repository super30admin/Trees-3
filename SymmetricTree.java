// Time Complexity : O(n) we have to visit every node
// Space Complexity : O(1) auxilary space - constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach
//Recursively compare left with right and right with left

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        return compare(root.left, root.right);
        
    }
    
    
    private boolean compare(TreeNode node1, TreeNode node2){
        if((node1 == null && node2 != null) || (node1 != null && node2 == null)) return false;
        if(node1 == null && node2 == null) return true;
        //logic
        return node1.val == node2.val && compare(node1.left, node2.right) && compare(node1.right, node2.left);
    }
}
