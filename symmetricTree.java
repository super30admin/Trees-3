/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* 101. Symmetric Tree - Recursion
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }

    // why private? due to abstraction, we don't want methods outside this class to access this method, only visible within the enclosing class
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;

        if(left == null || right == null || left.val != right.val)
            return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

// DFS -Iterative using Stack
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if(right == null && left == null)
                continue;
            if(right == null || left == null || right.val != left.val)
                return false;

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// BFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}