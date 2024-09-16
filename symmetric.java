/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time: O(n)
// space: O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> s=new Stack<>();
        s.push(root.left);
        s.push(root.right);
        while(!s.isEmpty())
        {
            TreeNode r=s.pop();
            TreeNode l=s.pop();
            if(l==null && r==null) continue;
            if(l==null || r==null || l.val!=r.val) return false;
            s.push(r.right);
            s.push(l.left);
            s.push(r.left);
            s.push(l.right);
        }
        return true;
    }
}