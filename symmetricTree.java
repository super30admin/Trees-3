// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);
        
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            
            if (left == null && right == null)
                continue;
            
            if (left == null || right == null)
                return false;
            
            if (left.val != right.val)
                return false;
            
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }
}
