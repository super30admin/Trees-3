
//  iterative approach
// time complexity: o(n)
// space complexity: o(n);
// did this code run on leetcode: yes

// approach:
// this is a breadth first search approach. 
// push the value into queue from left most node's left val, right most node's right val as and when reaching each level, until there are no nodes left
// find the left and right val of the top two element's in queue, and compare whether they are equal.
// do this until there are no elements left in queue

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        if(root == null) {
        return true;
        }
        s1.add(root.left);
        s1.add(root.right);
        while(!s1.isEmpty()) {
        TreeNode left = s1.pop();
        TreeNode right = s1.pop();
        if(left==null && right==null) continue;
        if(left == null || right == null) return false;
        if(left.val!=right.val) return false;
        s1.add(left.left); 
        s1.add(right.right);
        s1.add(left.right);
        s1.add(right.left);
        }
        return true;
    }
}