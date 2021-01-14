//Problem 48: Symmetric Tree
// Time Complexity :O(N), N stands for number of nodes
// Space Complexity : (O(H)), if we are considering recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.*;

class Solution48 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

public boolean isSymmetric(TreeNode root) {
        
    if(root==null){
        return true;
    }
    
    return helper(root,root);
}

private boolean helper(TreeNode rootLeft,TreeNode rootRight){
        
    if(rootLeft==null && rootRight==null){
        return true;
    }
    
    if(rootLeft==null || rootRight==null){
        return false;
    }
    
    if(rootLeft.val!=rootRight.val){
        return false;
    }
    
    boolean case1 = helper(rootLeft.left,rootRight.right);
    boolean case2 = helper(rootLeft.right,rootRight.left);
    
    return case1 && case2;
}

/* Iterative Code--Using Stack, basically it is similar to the recursive stack
private boolean iterativeHelper(TreeNode root){
        
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    stack.push(root);
    
    while(!stack.isEmpty()){
        
        TreeNode rootLeft   = stack.pop();
        TreeNode rootRight  = stack.pop();
        
        if(rootLeft==null && rootRight==null) continue;
        
        if(rootLeft==null || rootRight==null) return false;
        
        if(rootLeft.val!=rootRight.val) return false;
        
        stack.push(rootLeft.left);
        stack.push(rootRight.right);
        
        stack.push(rootLeft.right);
        stack.push(rootRight.left);
    }
    
    return true;
}*/



}
