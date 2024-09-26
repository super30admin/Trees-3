/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* Iterative Approach: We are iteratively push left of left and right of right then right of left and left of right into stack.If left subtree and the right subtree are null then we know the tree is symmetrical till that point.
Time Complexity: O(n)
Space Complexity: O(Height)
Did the code run successfully on leetcode? Yes
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root==null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(right==null && left==null)
                continue;
            if(right==null || left==null || right.val!=left.val)
                return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }
} 

/* Recursive Program
Time Complexity: O(n)
Space Complexity: O(1)
Did the code run successfully on leetcode? Yes
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
		}
        return helper(root.left, root.right);

    }

    private boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null){
			return true;
		}
        if(left==null || right==null || left.val!=right.val){
			return false;
		}
        return (helper(left.left, right.right) && helper(left.right,right.left));
}
} 