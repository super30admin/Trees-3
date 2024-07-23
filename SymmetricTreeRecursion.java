// https://leetcode.com/problems/symmetric-tree/

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use a DFS to compare (left's right with right's left) &
// (left's left with right's right), at any point if not equal
// tree is asymmetric

class Solution {
    // 1. DFS / Recursion 
    // TO(N)
    // SO(N)
    List<Integer> in;
    private boolean helper(TreeNode l, TreeNode r){
        if(l==null && r==null)  return true;
        if(l==null||r==null)    return false;
        if(l.val!=r.val)    return false;
        return helper(l.left, r.right) && helper(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
}
