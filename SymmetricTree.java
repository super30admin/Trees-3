// Time Complexity : O(n), number of nodes in tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :



//Iterative Solution using stack  
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        //if tree empty return true
        if(root == null) return true; 
        //use stack to add nodes
        Stack<TreeNode> st = new Stack<>();
        //push left node
        //push right node
        //pop right before left
        st.push(root.left);
        st.push(root.right);
        
        //loop till stack empty, if stack is empty all nodes were check and were symmetric
        while(!st.isEmpty()) {
            //pop right before left (Stack : LIFO)
            TreeNode r = st.pop();
            TreeNode l = st.pop(); 
            //if both l and r are null then skip this loop and continue with next iteration
            if(l == null && r == null) continue;
            //if either one is null or values are not equal return result as false 
            if(l == null || r == null|| l.val != r.val) return false; 
            //else push the child nodes of the popped nodes to check for symmetry
            //push nodes in opposite order of pop
            //maintain the order of push to compare the right values
            //we push l.left with r.right to compare these two when popped 
            //then push l.right and r.left to compare these two when popped
            st.push(l.left);
            st.push(r.right);
            st.push(l.right);
            st.push(r.left);           
        }
           
        //if stack becomes empty all nodes were compared and 
        //tree was symmetric so return result as true
        return true;                 
    }    
}






//Recursive Solution 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //check if tree empty, return true
        if(root == null) return true;
        //call helper function with left and right node
        return helper(root.left,root.right);
        
    }
    
    private boolean helper(TreeNode l, TreeNode r) {
        
        //if both l and r are nyll, both are leaf node send true for that recursive call
        if(l == null && r == null) return true;
        
        //if either one is null or values are not equal, send false for that recursive call
        if(l == null || r == null || l.val != r.val) return false;
        
        //if both values are equal
        if(l.val == r.val) {
            //call helper function with
            //l.left node and r.right node, for symmetry these two should be equal
            //l.right and r.left node, for symmetry these two should be equal
            //for tree to be symmetric both the helper function should return true
            return helper(l.left, r.right) && helper(l.right, r.left);
        }
        
        return true;        
    }
}
