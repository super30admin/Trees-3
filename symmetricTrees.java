
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
 *
 * TC --> O(n)
 * SC --> O(n)
 */
import java.util.*;

class Solution {

    public boolean isSymmetric(TreeNode root) {

        return Helper(root.left, root.right);

    }

    public boolean Helper(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            //System.out.print("root1 :"+root1.val);
            //System.out.print("root2 :"+root2.val);
            if (root1.val != root2.val) {
                return false;
            }
            return Helper(root1.left, root2.right) && Helper(root1.right, root2.left);
        } else if (root1 == null && root2 == null) {
            return true; 
        }else {
            return false;
        }
    }
}
