import java.util.LinkedList;
import java.util.Queue;

/*
Time complexity: O(n). Because we traverse the entire input tree once, the total run time is O(n), where n is
the total number of nodes in the tree.

Space complexity: There is additional space required for the search queue. In the worst case, we have to insert
O(n) nodes in the queue. Therefore, space complexity is O(n).

Did this code successfully run on Leetcode: Yes
 */
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
class SymmetricIterative {
    public boolean isSymmetric(TreeNode root)
    {
        //base case
        if(root == null) return true;

        //logic
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode p = queue.poll(), q = queue.poll();

            //base case
            if (p == null && q == null) continue;
            if ((p == null || q == null) || (p.val != q.val)) return false;

            //logic
            queue.add(p.left); queue.add(q.right);
            queue.add(p.right); queue.add(q.left);
        }

        return true;
    }
}