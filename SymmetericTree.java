//Time:O(n)
//Space:O(1)
//Run on LeetCOde? YEs
//Approach: IF both root.left and root.right is null the tree is symmeteric otherwise if only one is null then it is not.
//check t1->root.left and t2-> root.right and vice versa by using Queue 
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
        Queue <TreeNode>q = new LinkedList<>();
        
        if(root == null )
            return true;
        
        if(root.left==null && root.right==null)
            return true;
        
        if(root.left==null || root.right==null)
            return false;
     
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty())
        {
           TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
    }
}
