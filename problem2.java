//## Problem2 (https://leetcode.com/problems/symmetric-tree/)

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// approach: solved it using DFS and BFS

// DFS approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root == null)
        {
            return true;
        }
        return check(root.left, root.right);
        
    }

    private boolean check(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
        {
            return true;
        }
        else if(left == null || right == null)
        {
            return false;
        }
        else if(left.val != right.val)
        {
            return false;
        }
        else
        {
            return check(left.left, right.right) && check(left.right, right.left);
        }
        

    }
}


// BFS solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
        {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty())
        {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if(left== null && right == null)
            {
                continue;
            }
            else if(left==null || right ==null)
            {
                return false;
            }
            else if(left.val != right.val)
            {
                return false;
            }
            else
            {
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }
        }
        return true;
    }
}